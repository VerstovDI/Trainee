package JDBC;

import java.sql.*;

public class Main {

    public static void main(String[] args) {
        // without DAO pattern
        Connection connection = null;
        Statement statement = null;
        try {
            System.out.println("Registering JDBC driver...");
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            System.err.println("No appropriate JDBC driver");
            e.printStackTrace();
        }
        try {
            System.out.println("Creating database connection...");
            connection = DriverManager
                    .getConnection("jdbc:postgresql://localhost:5432/jdbc_task_db",
                            "postgres", "Kolobok11274");
            if (connection != null) {
                statement = connection.createStatement();
            } else {
                System.err.println("Connection is null");
                System.exit(0);
            }
            String sqlQuery;
            sqlQuery = "SELECT * FROM public.\"Users\"";
            // Just an inspection. Use Data Sources -> New Data Source -> my db...
            // to avoid this thing
            ResultSet resultSet = statement.executeQuery(sqlQuery);
            while (resultSet.next()) {
                int id = resultSet.getInt("user_id");
                String name = resultSet.getString("username");
                String age = resultSet.getString("age");
                int securityLevel = resultSet.getInt("security_level");
                Date date = resultSet.getDate("birthday_date");

                System.out.println("\n================\n");
                System.out.println("id: " + id);
                System.out.println("Name: " + name);
                System.out.println("Age: " + age);
                System.out.println("Security level" + securityLevel);
                System.out.println("Birthday_date" + date);
            }
            System.out.println("Closing connection and releasing resources...");
            resultSet.close();
            statement.close();
            connection.close();
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }
    }
}
