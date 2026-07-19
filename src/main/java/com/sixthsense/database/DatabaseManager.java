package com.sixthsense.database;

import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.sixthsense.model.SystemSnapshot;

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

    public void insertSystemSnapshot(SystemSnapshot snapshot) {

        String sql = """
                INSERT INTO system_information (
                    computer_name,
                    username,
                    os_name,
                    os_version,
                    java_version,
                    cpu_architecture,
                    processors,
                    total_memory,
                    free_memory,
                    used_memory,
                    created_at
                )
                VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);
                """;

        try (Connection connection = DriverManager.getConnection(DATABASE_URL);
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setString(1, snapshot.getComputerName());
            statement.setString(2, snapshot.getUsername());
            statement.setString(3, snapshot.getOsName());
            statement.setString(4, snapshot.getOsVersion());
            statement.setString(5, snapshot.getJavaVersion());
            statement.setString(6, snapshot.getCpuArchitecture());
            statement.setInt(7, snapshot.getProcessors());
            statement.setDouble(8, snapshot.getTotalMemory());
            statement.setDouble(9, snapshot.getFreeMemory());
            statement.setDouble(10, snapshot.getUsedMemory());
            statement.setString(11, snapshot.getCreatedAt());

            statement.executeUpdate();

            System.out.println("System information saved successfully.");

        } catch (SQLException exception) {

            System.out.println("Failed to save system information.");
            exception.printStackTrace();

        }

    }

    public void showSystemHistory() {

        String sql = """
                SELECT *
                FROM system_information
                ORDER BY id;
                """;

        try (Connection connection = DriverManager.getConnection(DATABASE_URL);
             PreparedStatement statement = connection.prepareStatement(sql);
             ResultSet resultSet = statement.executeQuery()) {

            System.out.println();
            System.out.println("===== Saved System History =====");

            while (resultSet.next()) {

                System.out.println("ID              : " + resultSet.getInt("id"));
                System.out.println("Computer Name   : " + resultSet.getString("computer_name"));
                System.out.println("Username        : " + resultSet.getString("username"));
                System.out.println("Operating System: " + resultSet.getString("os_name"));
                System.out.println("Java Version    : " + resultSet.getString("java_version"));
                System.out.println("Created At      : " + resultSet.getString("created_at"));

                System.out.println("----------------------------------------");
            }

        } catch (SQLException exception) {

            System.out.println("Failed to read system history.");
            exception.printStackTrace();

        }

    }

}