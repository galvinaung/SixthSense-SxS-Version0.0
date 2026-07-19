package com.sixthsense;


import com.sixthsense.database.DatabaseManager;
import com.sixthsense.event.EventLogger;
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
        // - Create database folder
        // - Connect SQLite database
        // - Create application tables
        // ------------------------------------------
        DatabaseManager databaseManager = new DatabaseManager();

        databaseManager.initializeDatabase();

        databaseManager.createTables();

        databaseManager.createEventLogTable();



        // ------------------------------------------
        // Feature 3 : Event Logging
        // Record application startup event
        // ------------------------------------------
        EventLogger eventLogger = new EventLogger(databaseManager);


        eventLogger.logEvent(
                "APPLICATION_STARTED",
                "SixthSense SxS application started"
        );



        System.out.println();



        // ------------------------------------------
        // Feature 1 : Collect System Information
        // ------------------------------------------
        SystemInfo systemInfo = new SystemInfo();

        SystemSnapshot snapshot = systemInfo.getSystemSnapshot();



        // ------------------------------------------
        // Feature 2 : Save System Information
        // Store snapshot into SQLite database
        // ------------------------------------------
        databaseManager.insertSystemSnapshot(snapshot);



        // ------------------------------------------
        // Feature 2 : Display Saved History
        // ------------------------------------------
        databaseManager.showSystemHistory();

        // ------------------------------------------
        // Feature 3 : Display Event History
        // ------------------------------------------
        databaseManager.showEventHistory();



        System.out.println();



        // ------------------------------------------
        // Feature 1 : Display Current System Info
        // ------------------------------------------
        systemInfo.showSystemInfo(snapshot);


    }

}