package HibernateTasks;

import HibernateTasks.DAOImpl.UserDAOImpl;
import HibernateTasks.DAOImpl.UserDAOImpl2;
import HibernateTasks.Entity.User;
import HibernateTasks.Util.SessionFactoryUtil;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.sql.Date;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hibernate tutorial start");
        /*Session session = SessionFactoryUtil.getSessionFactory().openSession();
        *//*User user = new User(8, "Ella",
                Date.valueOf("1999-10-10"), 27, 2);*//*
        session.getSession().beginTransaction();
        String sql = "FROM User";
        Query<User> query = session.createQuery(sql, User.class);
        // Execute query.
        List<User> employees = query.getResultList();
        System.out.println(employees.size());
        for (User usr : employees) {
            System.out.println(usr);
        }

        // Commit data.
        session.getTransaction().commit();
        session.close();*/

        UserDAOImpl usr = new UserDAOImpl();
        System.out.println(usr.getById(2).orElse(null));

        // inserted id is calculated in INSERT function
        User userElla = new User(12,"Ella",
                Date.valueOf("1999-10-10"), 27, 2);
        System.out.println(usr.insert(userElla));

        // update
        System.out.println(usr.update(userElla)); // вообще по id обновляют

        // delete
        System.out.println(usr.delete(userElla));

        // getAll
        System.out.println(usr.getAll());

        // getPage
        System.out.println(usr.getPage(3, 1));

        // via CriteriaAPI
        UserDAOImpl2 usr2 = new UserDAOImpl2();
        System.out.println("Criteria" + usr2.getById(4));

        User userGrisha = new User("Grisha", Date.valueOf("2004-04-20"), 32, 1);
        System.out.println(usr2.insert(userGrisha));
    }
}
