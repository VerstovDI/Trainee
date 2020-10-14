package HibernateTasks.DAOImpl;

import HibernateTasks.DAO.UserAbstractDAO;
import HibernateTasks.Entity.User;
import HibernateTasks.Util.SessionFactoryUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.Arrays;
import java.util.Collections;
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
            User resUser = query.getResultList().get(0);
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
            //System.out.println(lastUser);
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
        boolean result = false;
        try (Session session = SessionFactoryUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
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
            int resN = query.executeUpdate();
            transaction.commit();
            if (resN > 0) {
                result = true;
            }
        } catch (Exception ex) {
            System.err.println(ex.getMessage());
        }
        return result;
    }

    @Override
    public Optional<User> delete(User user) {
        try (Session session = SessionFactoryUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            String hql = "DELETE FROM User WHERE id =:user_id";
            Query query = session.createQuery(hql);
            query.setParameter("user_id", user.getUserId());
            int resN = query.executeUpdate();
            transaction.commit();
            if (resN == 1) {
                return Optional.of(user);
            }
            return Optional.empty();
        }
    }

    @Override
    public List<User> getAll() {
        try (Session session = SessionFactoryUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            String hql = "FROM User";
            Query<User> query = session.createQuery(hql, User.class);
            // User resUser = (User) query.getSingleResult();
            // getSingleResult() бросает исключение, если не найдет.
            List<User> userList = query.getResultList();
            transaction.commit();
            return userList;
        }
    }

    @Override
    public List<User> getPage(int pageSize, int numberOfPage) {
        try (Session session = SessionFactoryUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            String countQ = "SELECT count(U.userId) from User U";
            Query<Long> countQuery = session.createQuery(countQ, Long.class);
            Long countResults = countQuery.uniqueResult();
            int lastPageNumber = (int) (countResults/pageSize) + 1;
            if ((lastPageNumber < numberOfPage) || (numberOfPage <= 0)) {
                return Collections.emptyList();
            }
            Query<User> selectQuery = session.createQuery("From User ORDER BY userId", User.class);
            selectQuery.setFirstResult((numberOfPage-1) * pageSize);
            selectQuery.setMaxResults(pageSize);
            List<User> listPage = selectQuery.getResultList();
            transaction.commit();
            return listPage;
        }


    }
}
