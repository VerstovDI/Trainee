package HibernateTasks.DAOImpl;

import HibernateTasks.DAO.UserAbstractDAO;
import HibernateTasks.Entity.User;
import HibernateTasks.Util.SessionFactoryUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import javax.persistence.criteria.*;
import java.util.List;
import java.util.Optional;

public class UserDAOImpl2 implements UserAbstractDAO<User> {
    @Override
    public Optional<User> getById(Integer id) {
        return Optional.of(SessionFactoryUtil
                .getSessionFactory()
                .openSession()
                .get(User.class, id));
    }

    @Override
    public Optional<User> insert(User user) {
        try (Session session = SessionFactoryUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.save(user);
            transaction.commit();
            return Optional.of(user);
        }
    }

    @Override
    public boolean update(User user) {
        try (Session session = SessionFactoryUtil.getSessionFactory().openSession()) {
            CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
            // или session.update(user)
            CriteriaUpdate<User> criteriaUpdate = criteriaBuilder.createCriteriaUpdate(User.class);
            Root<User> root = criteriaUpdate.from(User.class);
            criteriaUpdate.set("username", user.getUsername());
            criteriaUpdate.set("birthdayDate", user.getBirthdayDate());
            criteriaUpdate.set("age", user.getAge());
            criteriaUpdate.set("securityLevel", user.getSecurityLevel());
            criteriaUpdate.where(criteriaBuilder.equal(root.get("userId"), user.getUserId()));
            Transaction transaction = session.beginTransaction();
            session.createQuery(criteriaUpdate).executeUpdate();
            transaction.commit();
        }
        return false;
    }

    @Override
    public Optional<User> delete(User user) {
        try (Session session = SessionFactoryUtil.getSessionFactory().openSession()) {
            CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
            CriteriaDelete<User> criteriaDelete = criteriaBuilder
                    .createCriteriaDelete(User.class);
            Root<User> root = criteriaDelete.from(User.class);
            criteriaDelete
                    .where(criteriaBuilder.greaterThan(root.get("age"), user.getAge()));
            Transaction transaction = session.beginTransaction();
            session.createQuery(criteriaDelete).executeUpdate();
            transaction.commit();
        }
        return Optional.of(user);
    }

    @Override
    public List<User> getAll() {
        try (Session session = SessionFactoryUtil.getSessionFactory().openSession()) {
            CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
            CriteriaQuery<User> cr = criteriaBuilder.createQuery(User.class);
            Root<User> root = cr.from(User.class);
            cr.select(root);

            Transaction transaction = session.beginTransaction();
            Query<User> query = session.createQuery(cr);
            List<User> results = query.getResultList();
            transaction.commit();
            return results;
        }
    }

    @Override
    public List<User> getPage(int pageSize, int numberOfPage) {
        try (Session session = SessionFactoryUtil.getSessionFactory().openSession()) {
            CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
            CriteriaQuery<User> cr = criteriaBuilder.createQuery(User.class);
            Root<User> root = cr.from(User.class);
            cr.select(root);
            Transaction transaction = session.beginTransaction();
            Query<User> query = session.createQuery(cr);
            query.setFirstResult(numberOfPage-1).setMaxResults(pageSize);
            List<User> results = query.getResultList();
            transaction.commit();
            return results;
        }
    }
}
