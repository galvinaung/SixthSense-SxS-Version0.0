package com.sixthsense.monitor;

import com.sixthsense.event.EventLogger;

public class UserSessionMonitor {


    private final EventLogger eventLogger;


    // Constructor
    public UserSessionMonitor(EventLogger eventLogger) {

        this.eventLogger = eventLogger;

    }


    // Check current logged-in user
    public void checkCurrentUser() {


        String username = System.getProperty("user.name");


        eventLogger.logEvent(
                "LOGIN_SUCCESS",
                "Current user session detected: " + username
        );


        System.out.println(
                "User session detected: " + username
        );

    }


}