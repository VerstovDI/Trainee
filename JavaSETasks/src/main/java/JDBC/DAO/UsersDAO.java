package JDBC.DAO;

import JDBC.ConnectionFactory;
import JDBC.DTO.UserDTO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class UsersDAO implements DAO<UserDTO> {

    @Override
    public UserDTO getById(Integer id) {
        Connection connection = ConnectionFactory.getConnectionToDB();
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            connection.createStatement();
            preparedStatement = connection
                    .prepareStatement("SELECT * FROM \"Users\" WHERE \"Users\".user_id = ?");
            preparedStatement.setInt(1, 1);
            resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                System.out.println("Success!");
            }
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }
        UserDTO userDTO = new UserDTO();
        try {
            userDTO.setUserId(resultSet.getInt("user_id"));
            userDTO.setUsername(resultSet.getString("username"));
            userDTO.setBirthdayDate(resultSet.getDate("birthday_date"));
            userDTO.setAge(resultSet.getInt("age"));
            userDTO.setSecurityLevel(resultSet.getInt("security_level"));
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        } finally {
            try {
                connection.close();
            } catch (SQLException se) {
                se.printStackTrace();
            }
            try {
                assert preparedStatement != null;
                preparedStatement.close();
            } catch (SQLException se) {
                se.printStackTrace();
            }
            try {
                resultSet.close();
            } catch (SQLException se) {
                se.printStackTrace();
            }
        }
        // обработка ошибок не до конца правильная, стоит условно
        return userDTO;
    }

    @Override
    public boolean insert(UserDTO userDTO) {
        Connection connection = ConnectionFactory.getConnectionToDB();
        PreparedStatement preparedStatement = null;
        try {
            connection.createStatement();
            preparedStatement = connection
                    .prepareStatement("INSERT INTO \"Users\" VALUES (?,?,?,?,?)");
            preparedStatement.setInt(1, userDTO.getUserId());
            preparedStatement.setString(2, userDTO.getUsername());
            preparedStatement.setDate(3, userDTO.getBirthdayDate());
            preparedStatement.setInt(4, userDTO.getAge());
            preparedStatement.setInt(5, userDTO.getSecurityLevel());
            preparedStatement.execute();
            System.out.println("Success!");
            return true;
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        } finally {
            try {
                connection.close();
            } catch (SQLException se) {
                se.printStackTrace();
            }
            try {
                assert preparedStatement != null;
                preparedStatement.close();
            } catch (SQLException se) {
                se.printStackTrace();
            }
        }
        return false;
    }

    @Override
    public boolean update(UserDTO userDTO) {
        Connection connection = ConnectionFactory.getConnectionToDB();
        PreparedStatement preparedStatement = null;
        try {
            connection.createStatement();
            preparedStatement = connection
                    .prepareStatement("UPDATE \"Users\" SET security_level = ? WHERE user_id = ?");
            preparedStatement.setInt(1, userDTO.getSecurityLevel());
            preparedStatement.setInt(2, userDTO.getUserId());
            int updated = preparedStatement.executeUpdate();
            if (updated != 0) {
                System.out.println("Success!");
                return true;
            }
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        } finally {
            try {
                connection.close();
            } catch (SQLException se) {
                se.printStackTrace();
            }
            try {
                assert preparedStatement != null;
                preparedStatement.close();
            } catch (SQLException se) {
                se.printStackTrace();
            }
        }
        return false;
    }

    @Override
    public boolean delete(UserDTO userDTO) {
        Connection connection = ConnectionFactory.getConnectionToDB();
        PreparedStatement preparedStatement = null;
        try {
            connection.createStatement();
            preparedStatement = connection
                    .prepareStatement("DELETE FROM \"Users\" WHERE user_id = ?");
            preparedStatement.setInt(1, userDTO.getUserId());;
            preparedStatement.execute();
            System.out.println("Success!");
            return true;
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        } finally {
            try {
                connection.close();
            } catch (SQLException se) {
                se.printStackTrace();
            }
            try {
                assert preparedStatement != null;
                preparedStatement.close();
            } catch (SQLException se) {
                se.printStackTrace();
            }
        }
        return false;
    }

    @Override
    public ArrayList<UserDTO> getAll() {
        Connection connection = ConnectionFactory.getConnectionToDB();
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        ArrayList<UserDTO> dtoArrayList = new ArrayList<>();
        try {
            connection.createStatement();
            preparedStatement = connection
                    .prepareStatement("SELECT * FROM \"Users\"");
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                dtoArrayList.add(new UserDTO(
                        resultSet.getInt("user_id"),
                        resultSet.getString("username"),
                        resultSet.getDate("birthday_date"),
                        resultSet.getInt("age"),
                        resultSet.getInt("security_level")));
            }
            System.out.println("Success!");
            return dtoArrayList;
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        } finally {
            try {
                connection.close();
            } catch (SQLException se) {
                se.printStackTrace();
            }
            try {
                assert preparedStatement != null;
                preparedStatement.close();
            } catch (SQLException se) {
                se.printStackTrace();
            }
            try {
                assert resultSet != null;
                resultSet.close();
            } catch (SQLException se) {
                se.printStackTrace();
            }
        }
        return dtoArrayList;
    }
}
