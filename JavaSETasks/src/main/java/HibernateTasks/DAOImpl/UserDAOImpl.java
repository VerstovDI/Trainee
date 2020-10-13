package HibernateTasks.DAOImpl;

import HibernateTasks.DAO.UserAbstractDAO;
import HibernateTasks.Entity.User;
import HibernateTasks.Util.SessionFactoryUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.sql.Date;
import java.util.List;
import java.util.Optional;

public class UserDAOImpl implements UserAbstractDAO<User> {

    @Override
    public Optional<User> getById(Integer id) {
        /* Вариант - 1
        return Optional.of(SessionFactoryUtil
                .getSessionFactory()
                .openSession()
                .get(User.class, id));*/
        try (Session session = SessionFactoryUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            String hql = "FROM User WHERE id=:user_id";
            Query<User> query = session.createQuery(hql, User.class);
            query.setParameter("user_id", id);
            // User resUser = (User) query.getSingleResult();
            // getSingleResult() бросает исключение, если не найдет.
            User resUser = (User) query.getResultList().get(0);
            transaction.commit();
            return Optional.of(resUser);
        }
    }

    @Override
    public Optional<User> insert(User user) {
        try (Session session = SessionFactoryUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            User lastUser = (User) session.createQuery("FROM User ORDER BY userId DESC")
                    .setMaxResults(1).uniqueResult();
            System.out.println(lastUser);
            /*Booking booking =  (Booking) session.createQuery("from Booking ORDER BY id DESC")
                    .setMaxResults(1).uniqueResult();*/
            user.setUserId(lastUser.getUserId()+1);
            session.save(user);
            transaction.commit();
            return Optional.of(user);
        }
    }

    @Override
    public boolean update(User user) {
        try (Session session = SessionFactoryUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            int updatedId = user.getUserId();
            String hql = "UPDATE User SET username =:username," +
                    "birthdayDate =:birthday_date," +
                    "age =: age," +
                    "securityLevel =: security_level" +
                    " WHERE id =:user_id";
            Query query = session.createQuery(hql); // TODO: Если типизировать, то Update/delete queries cannot be typed
            query.setParameter("username", user.getUsername());
            query.setParameter("birthday_date", user.getBirthdayDate());
            query.setParameter("age", user.getAge());
            query.setParameter("security_level", user.getSecurityLevel());
            query.setParameter("user_id", user.getUserId());
            query.executeUpdate();
            transaction.commit();
            return true;
        }
    }

    @Override
    public Optional<User> delete(User adr) {
        return Optional.empty();
    }

    @Override
    public List<User> getAll() {
        return null;
    }

    @Override
    public List<User> getPage(int pageSize, int pageNumber) {
        return null;
    }
}
