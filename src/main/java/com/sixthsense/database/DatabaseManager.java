package com.sixthsense.database;

import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

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

    public void createTables() {

        String sql = """
                CREATE TABLE IF NOT EXISTS system_information (

                    id INTEGER PRIMARY KEY AUTOINCREMENT,

                    computer_name TEXT,
                    username TEXT,

                    os_name TEXT,
                    os_version TEXT,

                    java_version TEXT,

                    cpu_architecture TEXT,
                    processors INTEGER,

                    total_memory REAL,
                    free_memory REAL,
                    used_memory REAL,

                    created_at TEXT

                );
                """;

        try (Connection connection = DriverManager.getConnection(DATABASE_URL);
             Statement statement = connection.createStatement()) {

            statement.execute(sql);

            System.out.println("Table 'system_information' created successfully.");

        } catch (SQLException exception) {

            System.out.println("Failed to create table.");
            exception.printStackTrace();

        }

    }

}