package com.sixthsense.monitor;


import com.sixthsense.event.EventLogger;


/*
 ==========================================
 Feature 3.3 : Power Monitoring

 Purpose:
 Detect computer power events.

 Events:

 POWER_ON
     |
     When SixthSense starts

 SHUTDOWN
     |
     When application closes


 Future:
 This event will be sent to another PC
 through network notification.

 ==========================================
*/


public class PowerMonitor {


    private EventLogger eventLogger;



    /*
     ==========================================
     Constructor

     Receive EventLogger object

     PowerMonitor does not save directly.
     It uses EventLogger.

     Flow:

     PowerMonitor
          |
          v
     EventLogger
          |
          v
     SQLite event_logs table

     ==========================================
    */

    public PowerMonitor(EventLogger eventLogger) {

        this.eventLogger = eventLogger;

    }




    /*
     ==========================================
     POWER_ON Detection

     Called when SixthSense application starts.

     ==========================================
    */

    public void detectPowerOn() {


        eventLogger.logEvent(

                "POWER_ON",

                "Computer started and SixthSense launched"

        );


    }





    /*
     ==========================================
     SHUTDOWN Detection

     Java Shutdown Hook

     This code runs automatically when:

     - Application closes normally
     - JVM stops

     ==========================================
    */

    public void registerShutdownHook() {


        Runtime.getRuntime().addShutdownHook(

                new Thread(() -> {


                    eventLogger.logEvent(

                            "SHUTDOWN",

                            "SixthSense application shutting down"

                    );


                })

        );


    }


}