package com.sixthsense;

import com.sixthsense.database.DatabaseManager;
import com.sixthsense.model.SystemSnapshot;
import com.sixthsense.system.SystemInfo;

public class Main {

    public static void main(String[] args) {

        // ==========================================
        // SixthSense SxS Application Startup
        // ==========================================
        System.out.println("================================");
        System.out.println("  SixthSense SxS Version 0.0");
        System.out.println("  Status: Running");
        System.out.println("  Programmer: Kaung");
        System.out.println("================================");

        // ------------------------------------------
        // Feature 2 : SQLite Database Initialization
        // - Create database folder (if missing)
        // - Connect to SQLite
        // - Create required tables
        // ------------------------------------------
        DatabaseManager databaseManager = new DatabaseManager();
        databaseManager.initializeDatabase();
        databaseManager.createTables();

        System.out.println();

        // ------------------------------------------
        // Feature 1 : Collect System Information
        // ------------------------------------------
        SystemInfo systemInfo = new SystemInfo();
        SystemSnapshot snapshot = systemInfo.getSystemSnapshot();

        // ------------------------------------------
        // Save current system snapshot into SQLite
        // ------------------------------------------
        databaseManager.insertSystemSnapshot(snapshot);

        // ------------------------------------------
        // Display saved system history
        // ------------------------------------------
        databaseManager.showSystemHistory();

        System.out.println();

        // ------------------------------------------
        // Display current system information
        // ------------------------------------------
        systemInfo.showSystemInfo(snapshot);

    }

}