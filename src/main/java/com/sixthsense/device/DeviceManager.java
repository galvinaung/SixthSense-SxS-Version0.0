package com.sixthsense.device;

import java.util.UUID;

public class DeviceManager {


    // ==========================================
    // Feature 4.1
    // Device Identity Generator
    //
    // Purpose:
    // Create unique ID for each computer
    // SixthSense uses this ID to recognize devices
    // ==========================================

    private String deviceId;


    public DeviceManager() {

        // Generate unique device ID
        deviceId = UUID.randomUUID().toString();

    }



    // ==========================================
    // Return Device ID
    // Other classes can use this
    // ==========================================

    public String getDeviceId() {

        return deviceId;

    }



    // ==========================================
    // Display device identity information
    // ==========================================

    public void showDeviceInfo() {


        System.out.println();
        System.out.println("===== Device Information =====");

        System.out.println("Device ID : " + deviceId);
        System.out.println("Computer  : "
                + System.getenv("COMPUTERNAME"));

        System.out.println("==============================");

    }

}