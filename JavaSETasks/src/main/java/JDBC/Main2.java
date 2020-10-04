package JDBC;

import JDBC.DAO.UsersDAO;
import JDBC.DTO.UserDTO;

import java.sql.Connection;
import java.sql.Date;

public class Main2 {
    public static void main(String[] args) {
        Connection connection = ConnectionFactory.getConnectionToDB();
        UsersDAO usersDAO = new UsersDAO();
        UserDTO usersDTO = usersDAO.getById(1);
        System.out.println(usersDTO.toString());
        usersDAO.insert(new UserDTO(6, "Dima", Date.valueOf("1999-05-29"), 21, 2));
        usersDAO.update(new UserDTO(1,"Alina", Date.valueOf("1999-09-09"), 23, 2));
        usersDAO.delete(new UserDTO(6, "asdasda", Date.valueOf("1999-05-05"), 12, 2));
    }
}
