package org.ibs.repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProductRepository {
    private Connection connection;

    public ProductRepository(Connection connection) {
        this.connection = connection;
    }

    public List<Food> getAll() {
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM FOOD");
            List<Food> foodList = new ArrayList<>();
            while (resultSet.next()) {
                Long id = resultSet.getLong(1);
                String name = resultSet.getString(2);
                String type = resultSet.getString(3);
                Integer exotic = resultSet.getInt(4);
                foodList.add(new Food(id, name, type, exotic));
            }
            return foodList;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public Integer addFood(Food food) {
        try {
            PreparedStatement statement = connection.prepareStatement("INSERT INTO FOOD(food_name, food_type, food_exotic) VALUES (?,?,?)");

            statement.setString(1, food.getFoodName());
            statement.setString(2, food.getTypeProduct());
            statement.setInt(3, food.getFoodExotic());
            return statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    public Integer addFood(Long id, String name, String type, Boolean exotic) throws SQLException {

        PreparedStatement statement = connection.prepareStatement("INSERT INTO FOOD(food_id, food_name, food_type, food_exotic) VALUES (?,?,?,?)");
        statement.setLong(1, id);
        statement.setString(2, name);
        statement.setString(3, type);
        statement.setBoolean(4, exotic);
        return statement.executeUpdate();


    }

    public Integer addFood(String name, String type) throws SQLException {
        PreparedStatement statement = connection.prepareStatement("INSERT INTO FOOD(food_name, food_type) VALUES (?,?)");
        statement.setString(1, name);
        statement.setString(2, type);
        return statement.executeUpdate();


    }

    public Integer addFood(String name, String type, Boolean exotic) throws SQLException {

        PreparedStatement statement = connection.prepareStatement("INSERT INTO FOOD(food_name, food_type, food_exotic) VALUES (?,?,?)");
        statement.setString(1, name);
        statement.setString(2, type);
        statement.setBoolean(3, exotic);
        return statement.executeUpdate();

    }

    public Integer deleteByName(String name) {
        try {
            PreparedStatement statement = connection.prepareStatement("DELETE FROM FOOD WHERE FOOD_NAME=?");
            statement.setString(1, name);
            return statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
