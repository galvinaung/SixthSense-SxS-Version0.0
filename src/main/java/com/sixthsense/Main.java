package com.sixthsense;


import com.sixthsense.database.DatabaseManager;
import com.sixthsense.event.EventLogger;
import com.sixthsense.model.SystemSnapshot;
import com.sixthsense.system.SystemInfo;

import com.sixthsense.monitor.UserSessionMonitor;
import com.sixthsense.monitor.PowerMonitor;
import com.sixthsense.monitor.NetworkMonitor;

import com.sixthsense.device.DeviceManager;



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
        //
        // - Create database folder
        // - Connect SQLite database
        // - Create application tables
        // ------------------------------------------

        DatabaseManager databaseManager =
                new DatabaseManager();


        databaseManager.initializeDatabase();


        databaseManager.createTables();


        databaseManager.createEventLogTable();



        // ------------------------------------------
        // Feature 4.1 : Device Identity
        //
        // Purpose:
        // - Create unique SixthSense device ID
        // - Identify this computer
        //
        // Future:
        // - Device pairing
        // - Multiple PC communication
        // ------------------------------------------

        DeviceManager deviceManager =
                new DeviceManager();


        deviceManager.showDeviceInfo();




        // ------------------------------------------
        // Feature 3 : Event Logging System
        //
        // Central event recorder
        // Used by:
        // - Application events
        // - Power events
        // - Network events
        // - Login events
        // ------------------------------------------

        EventLogger eventLogger =
                new EventLogger(databaseManager);




        // ------------------------------------------
        // Feature 3.3 : Power Monitoring
        //
        // Detect:
        // - POWER_ON
        // - SHUTDOWN
        // ------------------------------------------

        PowerMonitor powerMonitor =
                new PowerMonitor(eventLogger);


        powerMonitor.detectPowerOn();


        powerMonitor.registerShutdownHook();





        // ------------------------------------------
        // Feature 3.4 : Network Monitoring
        //
        // Detect:
        // - NETWORK_CONNECTED
        // - NETWORK_DISCONNECTED
        // ------------------------------------------

        NetworkMonitor networkMonitor =
                new NetworkMonitor(eventLogger);


        networkMonitor.checkNetworkStatus();





        // ------------------------------------------
        // Feature 3.2 : User Session Monitoring
        //
        // Detect:
        // - LOGIN_SUCCESS
        // ------------------------------------------

        UserSessionMonitor sessionMonitor =
                new UserSessionMonitor(eventLogger);


        sessionMonitor.checkCurrentUser();





        // ------------------------------------------
        // Feature 3 : Application Startup Event
        // ------------------------------------------

        eventLogger.logEvent(
                "APPLICATION_STARTED",
                "SixthSense SxS application started"
        );





        System.out.println();





        // ------------------------------------------
        // Feature 1 : Collect System Information
        // ------------------------------------------

        SystemInfo systemInfo =
                new SystemInfo();


        SystemSnapshot snapshot =
                systemInfo.getSystemSnapshot();





        // ------------------------------------------
        // Feature 2 : Save System Information
        //
        // Store snapshot into SQLite
        // ------------------------------------------

        databaseManager.insertSystemSnapshot(snapshot);





        // ------------------------------------------
        // Feature 2 : Display System History
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