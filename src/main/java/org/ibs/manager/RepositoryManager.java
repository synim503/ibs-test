package org.ibs.manager;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class RepositoryManager {
     private static RepositoryManager INSTANCE;
    private static final String JDBC_URL = "jdbc:h2:tcp://localhost:9092/mem:testdb";
    private static final String USERNAME = "user";
    private static final String PASSWORD = "pass";

    private Connection connection;

    private RepositoryManager() {
    }

    public static RepositoryManager getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new RepositoryManager();
        }
        return INSTANCE;
    }


    public Connection openConnection()  {
        try {
            if (connection == null || connection.isClosed()) {
                connection = DriverManager.getConnection(JDBC_URL, USERNAME, PASSWORD);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return connection;
    }

    public void closeConnection() {
        try {
            if (connection != null && !connection.isClosed()) {
                connection.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
