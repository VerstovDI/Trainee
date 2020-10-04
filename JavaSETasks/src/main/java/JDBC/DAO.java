package JDBC;

import java.util.ArrayList;

public interface DAO<T> {
    T getById(int id);
    void insert(T adr);
    boolean update(T adr);
    boolean delete(T adr);
    ArrayList<T> getAll();
}
