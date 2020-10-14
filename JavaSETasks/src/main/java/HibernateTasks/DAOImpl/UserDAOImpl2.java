package HibernateTasks.DAOImpl;

import HibernateTasks.DAO.UserAbstractDAO;
import HibernateTasks.Entity.User;
import HibernateTasks.Util.SessionFactoryUtil;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
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
            CriteriaQuery<User> criteriaQuery = criteriaBuilder.createQuery(User.class);
            //criteriaQuery.
        }
        return false;
    }

    @Override
    public Optional<User> delete(User user) {
        return Optional.empty();
    }

    @Override
    public List<User> getAll() {
        return null;
    }

    @Override
    public List<User> getPage(int pageSize, int numberOfPage) {
        return null;
    }
}
