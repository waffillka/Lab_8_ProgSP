package DAO.implementation;

import Models.User;
import DAO.interfaces.UsersDAO;
import utilities.DatabaseUtility;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UsersDAOImplementation implements UsersDAO {
    private static final String INSERT_USER = "INSERT INTO User(firstName, surname, username, password, contactPhone) VALUES (?, ?, ?, ?, ?);";
    private static final String UPDATE_USER = "UPDATE User SET firstName = ?, surname = ?, username = ?, password = ?, contactPhone = ? WHERE id = ?;";
    private static final String SELECT_USER = "SELECT * FROM User WHERE id = ?;";
    private static final String SELECT_BY_NAME_AND_PASSWORD = "SELECT * FROM User WHERE username = ? AND password = ?;";
    private static final String SELECT_ALL_USERS = "SELECT * FROM User;";
    private static final String DELETE_USER = "DELETE FROM User WHERE id = ?;";

    @Override
    public Boolean insertUser(User user)
    {
        boolean inserted = false;
        try (Connection connection = DatabaseUtility.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(INSERT_USER)) {
            preparedStatement.setString(1, user.getFirstName());
            preparedStatement.setString(2, user.getSurname());
            preparedStatement.setString(3, user.getUsername());
            preparedStatement.setString(4, user.getPassword());
            preparedStatement.setString(5, user.getContactPhone());
            preparedStatement.executeUpdate();
            inserted = true;
        }
        catch (SQLException exception) {
            exception.printStackTrace();
        }
        return inserted;
    }

    @Override
    public boolean updateUser(User user)
    {
        boolean rowUpdated = false;
        try (Connection connection = DatabaseUtility.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_USER)) {
            preparedStatement.setString(1, user.getFirstName());
            preparedStatement.setString(2, user.getSurname());
            preparedStatement.setString(3, user.getUsername());
            preparedStatement.setString(4, user.getPassword());
            preparedStatement.setString(5, user.getContactPhone());
            preparedStatement.setInt(6, user.getId());
            rowUpdated = preparedStatement.executeUpdate() > 0;
        }
        catch (SQLException exception) {
            exception.printStackTrace();
        }
        return rowUpdated;
    }

    @Override
    public User selectUser(int id)
    {
        User user = null;
        try (Connection connection = DatabaseUtility.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_USER)) {
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                String firstName = resultSet.getString("firstName");
                String surname  = resultSet.getString("surname");
                String username = resultSet.getString("username");
                String password = resultSet.getString("password");
                String contactPhone = resultSet.getString("contactPhone");
                user = new User(id, firstName, surname, username, password, contactPhone);
            }
        }
        catch (SQLException exception) {
            exception.printStackTrace();
        }
        return user;
    }

    @Override
    public User selectUser(String username, String password)
    {
        User user = null;
        try (Connection connection = DatabaseUtility.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_BY_NAME_AND_PASSWORD)) {
            preparedStatement.setString(1, username);
            preparedStatement.setString(2, password);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("ID");
                String firstName = resultSet.getString("firstName");
                String surname  = resultSet.getString("surname");
                String contactPhone = resultSet.getString("contactPhone");
                user = new User(id, firstName, surname, username, password, contactPhone);
            }
        }
        catch (SQLException exception) {
            exception.printStackTrace();
        }
        return user;
    }

    @Override
    public List<User> selectAllUsers()
    {
        List<User> users = new ArrayList<>();
        try (Connection connection = DatabaseUtility.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_USERS)) {
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String firstName = resultSet.getString("firstName");
                String surname  = resultSet.getString("surname");
                String username = resultSet.getString("username");
                String password = resultSet.getString("password");
                String contactPhone = resultSet.getString("contactPhone");
                users.add(new User(id, firstName, surname, username, password, contactPhone));
            }
        }
        catch (SQLException exception) {
            exception.printStackTrace();
        }
        return users;
    }

    @Override
    public boolean deleteUser(int id)
    {
        boolean rowDeleted = false;
        try (Connection connection = DatabaseUtility.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(DELETE_USER)) {
            preparedStatement.setInt(1, id);
            rowDeleted = preparedStatement.executeUpdate() > 0;
        }
        catch (SQLException exception) {
            exception.printStackTrace();
        }
        return rowDeleted;
    }
}
