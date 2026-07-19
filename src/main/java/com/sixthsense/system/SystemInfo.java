package com.sixthsense.system;

import java.lang.management.ManagementFactory;
import com.sun.management.OperatingSystemMXBean;

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

        OperatingSystemMXBean osBean =
                (OperatingSystemMXBean) ManagementFactory.getOperatingSystemMXBean();

        long totalMemory = osBean.getTotalMemorySize();
        long freeMemory = osBean.getFreeMemorySize();
        long usedMemory = totalMemory - freeMemory;

        System.out.println();
        System.out.println("===== Memory Information =====");

        System.out.printf("Total Memory     : %.2f GB%n",
                totalMemory / 1024.0 / 1024 / 1024);

        System.out.printf("Free Memory      : %.2f GB%n",
                freeMemory / 1024.0 / 1024 / 1024);

        System.out.printf("Used Memory      : %.2f GB%n",
                usedMemory / 1024.0 / 1024 / 1024);

    }

}