package JDBC;

import java.sql.DriverManager;
import java.util.ArrayList;

public class UsersDAO implements DAO{
    private static final String dbName = "jdbc:postgresql://localhost:5432/jdbc_task_db";
    private static final String userName = "postgres";
    private static final String password = "Kolobok11274";

    @Override
    public Object getById(int id) {
        return null;
    }

    @Override
    public void insert(Object adr) {

    }

    @Override
    public boolean update(Object adr) {
        return true;
    }

    @Override
    public boolean delete(Object adr) {
        return true;
    }

    @Override
    public ArrayList getAll() {
        return null;
    }
}
