package com.sixthsense.agent;


import com.sixthsense.database.DatabaseManager;
import com.sixthsense.event.EventLogger;
import com.sixthsense.device.DeviceManager;
import com.sixthsense.monitor.PowerMonitor;
import com.sixthsense.monitor.NetworkMonitor;
import com.sixthsense.monitor.UserSessionMonitor;



public class SixthSenseAgent {


    // ==========================================
    // Core Components
    //
    // Agent controls all SixthSense modules
    // ==========================================

    private DatabaseManager databaseManager;

    private EventLogger eventLogger;

    private DeviceManager deviceManager;


    private PowerMonitor powerMonitor;

    private NetworkMonitor networkMonitor;

    private UserSessionMonitor userSessionMonitor;



    // ==========================================
    // Constructor
    //
    // Prepare monitoring modules
    // ==========================================

    public SixthSenseAgent(){


        databaseManager = new DatabaseManager();


        eventLogger =
                new EventLogger(databaseManager);



        deviceManager =
                new DeviceManager();



        powerMonitor =
                new PowerMonitor(eventLogger);



        networkMonitor =
                new NetworkMonitor(eventLogger);



        userSessionMonitor =
                new UserSessionMonitor(eventLogger);


    }





    // ==========================================
    // Start SixthSense Agent
    //
    // Initialize all services
    // ==========================================

    public void start(){



        System.out.println();
        System.out.println("===== SixthSense Agent Started =====");



        // Database initialization

        databaseManager.initializeDatabase();

        databaseManager.createTables();

        databaseManager.createEventLogTable();




        // Device identity

        deviceManager.showDeviceInfo();




        // Power monitoring

        powerMonitor.detectPowerOn();

        powerMonitor.registerShutdownHook();




        // Initial network check

        networkMonitor.checkNetworkStatus();




        // Initial user session check

        userSessionMonitor.checkCurrentUser();




        // Agent startup event

        eventLogger.logEvent(
                "AGENT_STARTED",
                "SixthSense background agent started"
        );



        // Start continuous monitoring

        runMonitoringLoop();


    }






    // ==========================================
    // Background Monitoring Loop
    //
    // Keeps SixthSense running
    //
    // Future:
    // - Security monitoring
    // - File monitoring
    // - USB monitoring
    // ==========================================

    private void runMonitoringLoop(){


        System.out.println();

        System.out.println(
                "===== Monitoring Mode Active ====="
        );



        while(true){


            try {


                // Check network state

                networkMonitor.checkNetworkStatus();



                // Check logged-in user

                userSessionMonitor.checkCurrentUser();



                // Wait 30 seconds

                Thread.sleep(30000);



            } catch (InterruptedException exception){



                System.out.println(
                        "Monitoring stopped."
                );


                break;


            }


        }


    }



}