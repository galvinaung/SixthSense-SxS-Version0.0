package com.sixthsense.event;

import java.time.LocalDateTime;

import com.sixthsense.database.DatabaseManager;

public class EventLogger {

    private DatabaseManager databaseManager;


    // ==========================================
    // Event Logger Initialization
    // - Connect logger with database system
    // ==========================================
    public EventLogger(DatabaseManager databaseManager) {

        this.databaseManager = databaseManager;

    }


    // ==========================================
    // Feature 3
    // Save application events
    // ==========================================
    public void logEvent(String eventType, String description) {

        String createdAt = LocalDateTime.now().toString();

        databaseManager.insertEvent(
                eventType,
                description,
                createdAt
        );

    }

}