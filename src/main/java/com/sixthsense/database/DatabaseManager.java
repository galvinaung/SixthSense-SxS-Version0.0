package com.sixthsense.database;

import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseManager {

    private static final String DATABASE_PATH = "database/sixthsense.db";
    private static final String DATABASE_URL = "jdbc:sqlite:" + DATABASE_PATH;

    public void initializeDatabase() {

        try {

            File databaseFolder = new File("database");

            if (!databaseFolder.exists()) {
                databaseFolder.mkdirs();
                System.out.println("Database folder created.");
            }

            Connection connection = DriverManager.getConnection(DATABASE_URL);

            System.out.println("SQLite database connected successfully.");
            System.out.println("Database Location : " + DATABASE_PATH);

            connection.close();

            System.out.println("Database connection closed.");

        } catch (SQLException exception) {

            System.out.println("Database connection failed.");
            exception.printStackTrace();

        }

    }

}