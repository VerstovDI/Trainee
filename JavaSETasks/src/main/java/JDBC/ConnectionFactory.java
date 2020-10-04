package JDBC;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionFactory {
    private static final String connectionPropertiesFileName
            = "jdbc_connection_properties.properties";

    private static Properties loadConnectionPropertiesFile() {
        Properties properties = new Properties();
        try {
            InputStream inputStream = ConnectionFactory.class
                    .getClassLoader()
                    .getResourceAsStream(connectionPropertiesFileName);
            properties.load(inputStream);
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
        return properties;
    }

    public static Connection getConnectionToDB() {
        Connection connectionToDB = null;
        Properties properties = loadConnectionPropertiesFile();
        String driverName = properties.getProperty("driverName");
        String DB_URL = properties.getProperty("DB_URL");
        String username = properties.getProperty("username");
        String password = properties.getProperty("password");
        try {
            Class.forName(driverName);
        } catch (ClassNotFoundException e) {
            System.err.println("No appropriate JDBC driver");
            e.printStackTrace();
        }
        System.out.println("Creating database connection...");
        try {
            connectionToDB = DriverManager.getConnection(DB_URL, username, password);
            if (connectionToDB != null) {
                if (connectionToDB.isValid(1)) {
                    System.out.println("Successfully connected!");
                }
            }
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }
        return connectionToDB;
    }
}
