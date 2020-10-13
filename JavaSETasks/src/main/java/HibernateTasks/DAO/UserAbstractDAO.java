package HibernateTasks.DAO;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public interface UserAbstractDAO<T> {
    Optional<T> getById(Integer id);
    Optional<T> insert(T adr);
    boolean update(T adr);
    Optional<T> delete(T adr);
    List<T> getAll();
    List<T> getPage(int pageSize, int pageNumber);
    // добавить пагинацию (getPage)
}
