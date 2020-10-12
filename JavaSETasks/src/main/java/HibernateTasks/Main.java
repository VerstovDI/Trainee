package HibernateTasks;

import HibernateTasks.Entity.User;
import HibernateTasks.Util.SessionFactoryUtil;
import org.hibernate.Session;
import org.hibernate.query.Query;

import javax.persistence.Column;
import java.sql.Date;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hibernate tutorial start");
        Session session = SessionFactoryUtil.getSessionFactory().openSession();
        /*User user = new User(8, "Ella",
                Date.valueOf("1999-10-10"), 27, 2);*/
        session.getSession().beginTransaction();
        String sql = "FROM User";
        Query<User> query = session.createQuery(sql);
        // Execute query.
        List<User> employees = query.getResultList();
        System.out.println(employees.size());
        for (User usr : employees) {
            System.out.println(usr);
        }

        // Commit data.
        session.getTransaction().commit();
    }
}
