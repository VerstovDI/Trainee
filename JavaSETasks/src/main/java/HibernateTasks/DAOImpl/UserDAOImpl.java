package HibernateTasks.DAOImpl;

import HibernateTasks.DAO.UserAbstractDAO;
import HibernateTasks.Entity.User;

import java.util.List;
import java.util.Optional;

public class UserDAOImpl implements UserAbstractDAO<User> {
    @Override
    public Optional<User> getById(Integer id) {
        return Optional.empty();
    }

    @Override
    public boolean insert(User adr) {
        return false;
    }

    @Override
    public boolean update(User adr) {
        return false;
    }

    @Override
    public Optional<User> delete(User adr) {
        return Optional.empty();
    }

    @Override
    public List<User> getAll() {
        return null;
    }

    @Override
    public List<User> getPage(int pageSize, int pageNumber) {
        return null;
    }
}
