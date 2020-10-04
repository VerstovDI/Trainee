package JDBC.DAO;

import java.util.ArrayList;

public interface DAO<T> {
    T getById(Integer id);
    boolean insert(T adr);
    boolean update(T adr);
    boolean delete(T adr);
    ArrayList<T> getAll();
}
