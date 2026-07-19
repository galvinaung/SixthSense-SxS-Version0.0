package com.sixthsense.monitor;


import com.sixthsense.event.EventLogger;

import java.net.InetAddress;


/*
 ==========================================
 Feature 3.4 : Network Monitoring

 Purpose:
 Detect network connection status.

 Events:

 NETWORK_CONNECTED
        |
        Internet available


 NETWORK_DISCONNECTED
        |
        Internet unavailable


 Future:
 This status will help decide whether
 another PC can receive notifications.

 ==========================================
*/


public class NetworkMonitor {


    private EventLogger eventLogger;



    /*
     ==========================================
     Constructor

     Receive EventLogger

     NetworkMonitor
            |
            v
     EventLogger
            |
            v
     SQLite event_logs

     ==========================================
    */

    public NetworkMonitor(EventLogger eventLogger) {

        this.eventLogger = eventLogger;

    }




    /*
     ==========================================
     Check current network status

     Test:
     Try reaching google.com

     If reachable:
        NETWORK_CONNECTED

     If failed:
        NETWORK_DISCONNECTED

     ==========================================
    */

    public void checkNetworkStatus() {


        try {


            InetAddress address =
                    InetAddress.getByName("google.com");


            boolean connected =
                    address.isReachable(3000);



            if (connected) {


                eventLogger.logEvent(

                        "NETWORK_CONNECTED",

                        "Internet connection detected"

                );


                System.out.println(
                        "Network Status : CONNECTED"
                );


            }
            else {


                eventLogger.logEvent(

                        "NETWORK_DISCONNECTED",

                        "Internet connection unavailable"

                );


                System.out.println(
                        "Network Status : DISCONNECTED"
                );


            }


        }
        catch (Exception exception) {


            eventLogger.logEvent(

                    "NETWORK_ERROR",

                    "Network check failed"

            );


            System.out.println(
                    "Network check error."
            );


        }


    }


}