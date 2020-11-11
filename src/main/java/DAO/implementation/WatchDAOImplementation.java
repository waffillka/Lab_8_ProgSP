package DAO.implementation;

import DAO.interfaces.WatchDAO;
import Models.User;
import Models.Watch;
import utilities.DatabaseUtility;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class WatchDAOImplementation implements WatchDAO {
    private static final String INSERT_WATCH = "INSERT INTO Watch(nameWatch, typeWatch, price, count, manufacturer, country) VALUES (?, ?, ?, ?, ?, ?);";
    private static final String UPDATE_WATCH = "UPDATE User SET nameWatch = ?, typeWatch = ?, price = ?, count = ?, manufacturer = ?, country = ? WHERE id = ?;";
    private static final String SELECT_WATCH = "SELECT * FROM Watch WHERE id = ?;";
    private static final String SELECT_ALL_WATCH = "SELECT * FROM Watch;";
    private static final String DELETE_WATCH = "DELETE FROM Watch WHERE id = ?;";
    private static final String SELECT_WATCH_TYPE = "SELECT * FROM Watch WHERE typeWatch = ?;";
    private static final String SELECT_WATCH_TYPE_PRICE = "SELECT * FROM Watch WHERE typeWatch = ? AND price = ?;";
    //id, nameWatch, typeWatch, price, count, manufacturer,country;
    @Override
    public void insert(Watch watch)
    {
        try (Connection connection = DatabaseUtility.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(INSERT_WATCH)) {
            preparedStatement.setString(1, watch.getNameWatch());
            preparedStatement.setString(2, watch.getTypeWatch());
            preparedStatement.setString(3, String.valueOf(watch.getPrice()));
            preparedStatement.setString(4, String.valueOf(watch.getCount()));
            preparedStatement.setString(5, watch.getManufacturer());
            preparedStatement.setString(6, watch.getCountry());
            preparedStatement.executeUpdate();
        }
        catch (SQLException exception) {
            exception.printStackTrace();
        }
    }

    @Override
    public boolean updateWatch(Watch watch)
    {
        boolean rowUpdated = false;
        try (Connection connection = DatabaseUtility.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_WATCH)) {
            preparedStatement.setString(1, watch.getNameWatch());
            preparedStatement.setString(2, watch.getTypeWatch());
            preparedStatement.setString(3, String.valueOf(watch.getPrice()));
            preparedStatement.setString(4, String.valueOf(watch.getCount()));
            preparedStatement.setString(5, watch.getManufacturer());
            preparedStatement.setString(6, watch.getCountry());
            preparedStatement.setInt(7, watch.getId());
            rowUpdated = preparedStatement.executeUpdate() > 0;
        }
        catch (SQLException exception) {
            exception.printStackTrace();
        }
        return rowUpdated;
    }

    @Override
    public Watch selectWatch(int id)
    {
        Watch watch = null;
        try (Connection connection = DatabaseUtility.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_WATCH)) {
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                String nameWatch = resultSet.getString("nameWatch");
                String typeWatch  = resultSet.getString("typeWatch");
                double price = resultSet.getDouble("price");
                int count = resultSet.getInt("count");
                String manufacturer = resultSet.getString("manufacturer");
                String country = resultSet.getString("country");
                watch = new Watch(id, nameWatch, typeWatch, price, count, manufacturer,country);
            }
        }
        catch (SQLException exception) {
            exception.printStackTrace();
        }
        return watch;
    }
    //id, nameWatch, typeWatch, price, count, manufacturer,country;
    @Override
    public List<Watch> selectWatch(String typeWatch)
    {
        List<Watch> watch = new ArrayList<>();
        try (Connection connection = DatabaseUtility.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_WATCH_TYPE)) {
            preparedStatement.setString(1, typeWatch);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String nameWatch = resultSet.getString("nameWatch");
                double price = resultSet.getDouble("price");
                int count = resultSet.getInt("count");
                String manufacturer = resultSet.getString("manufacturer");
                String country = resultSet.getString("country");
                watch.add(new Watch(id, nameWatch, typeWatch, price, count, manufacturer,country));
            }
        }
        catch (SQLException exception) {
            exception.printStackTrace();
        }
        return watch;
    }

    @Override
    public List<Watch> selectWatch(int price, String typeWatch)
    {
        List<Watch> watch = new ArrayList<>();
        try (Connection connection = DatabaseUtility.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_WATCH_TYPE_PRICE)) {
            preparedStatement.setString(1, typeWatch);
            preparedStatement.setDouble(2, price);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String nameWatch = resultSet.getString("nameWatch");
                int count = resultSet.getInt("count");
                String manufacturer = resultSet.getString("manufacturer");
                String country = resultSet.getString("country");
                watch.add(new Watch(id, nameWatch, typeWatch, price, count, manufacturer,country));
            }
        }
        catch (SQLException exception) {
            exception.printStackTrace();
        }
        return watch;
    }

    @Override
    public List<Watch> selectWatchCountry(String country)
    {
        List<Watch> watch = new ArrayList<>();
        try (Connection connection = DatabaseUtility.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_WATCH_TYPE)) {
            preparedStatement.setString(1, country);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String nameWatch = resultSet.getString("nameWatch");
                double price = resultSet.getDouble("price");
                int count = resultSet.getInt("count");
                String manufacturer = resultSet.getString("manufacturer");
                String typeWatch = resultSet.getString("typeWatch");
                watch.add(new Watch(id, nameWatch, typeWatch, price, count, manufacturer,country));
            }
        }
        catch (SQLException exception) {
            exception.printStackTrace();
        }
        return watch;
    }

    @Override
    public List<Watch> selectAllWatch()
    {
        List<Watch> watch = new ArrayList<>();
        try (Connection connection = DatabaseUtility.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_WATCH)) {
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String nameWatch = resultSet.getString("nameWatch");
                String typeWatch  = resultSet.getString("typeWatch");
                double price = resultSet.getDouble("price");
                int count = resultSet.getInt("count");
                String manufacturer = resultSet.getString("manufacturer");
                String country = resultSet.getString("country");
                watch.add(new Watch(id, nameWatch, typeWatch, price, count, manufacturer,country));
            }
        }
        catch (SQLException exception) {
            exception.printStackTrace();
        }
        return watch;
    }

    @Override
    public void deleteWatch(int id)
    {
        try (Connection connection = DatabaseUtility.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(DELETE_WATCH)) {
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
        }
        catch (SQLException exception) {
            exception.printStackTrace();
        }
    }
}
