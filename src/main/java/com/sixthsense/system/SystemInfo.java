package com.sixthsense.system;

public class SystemInfo {

    public void showSystemInfo() {

        System.out.println("===== System Information =====");

        System.out.println("Operating System : " + System.getProperty("os.name"));
        System.out.println("OS Version       : " + System.getProperty("os.version"));
        System.out.println("Java Version     : " + System.getProperty("java.version"));
        System.out.println("Username         : " + System.getProperty("user.name"));
        System.out.println("Computer Name    : " + System.getenv("COMPUTERNAME"));
        System.out.println("CPU Architecture : " + System.getProperty("os.arch"));
        System.out.println("Processors       : " + Runtime.getRuntime().availableProcessors());

    }

}