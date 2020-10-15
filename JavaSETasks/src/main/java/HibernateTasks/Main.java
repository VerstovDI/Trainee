package HibernateTasks;

import HibernateTasks.DAOImpl.UserDAOImpl;
import HibernateTasks.DAOImpl.UserDAOImpl2;
import HibernateTasks.Entity.User;

import java.sql.Date;

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
        System.out.println(usr.getById(56).orElse(null));

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

        // ----- via CriteriaAPI -----
        // getById
        UserDAOImpl2 usr2 = new UserDAOImpl2();
        System.out.println("Criteria" + usr2.getById(56));
        // insert
        User userGrisha = new User("Grisha", Date.valueOf("2004-04-20"), 32, 1);
        System.out.println(usr2.insert(userGrisha));
        // update
        userGrisha.setUserId(46);
        userGrisha.setAge(700);
        userGrisha.setSecurityLevel(20);
        usr2.update(userGrisha);
        // delete
        User userSergey = new User("Sergey", Date.valueOf("1980-10-10"), 500, 2);
        usr2.delete(userSergey);
        // getAll
        System.out.println(usr2.getAll());
        // getPage
        System.out.println(usr2.getPage(3, 2));
    }
}
