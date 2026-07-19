package com.sixthsense.system;

import java.lang.management.ManagementFactory;
import java.time.LocalDateTime;

import com.sun.management.OperatingSystemMXBean;
import com.sixthsense.model.SystemSnapshot;

public class SystemInfo {

    public SystemSnapshot getSystemSnapshot() {

        SystemSnapshot snapshot = new SystemSnapshot();

        snapshot.setOsName(System.getProperty("os.name"));
        snapshot.setOsVersion(System.getProperty("os.version"));
        snapshot.setJavaVersion(System.getProperty("java.version"));
        snapshot.setUsername(System.getProperty("user.name"));
        snapshot.setComputerName(System.getenv("COMPUTERNAME"));
        snapshot.setCpuArchitecture(System.getProperty("os.arch"));
        snapshot.setProcessors(Runtime.getRuntime().availableProcessors());

        OperatingSystemMXBean osBean =
                (OperatingSystemMXBean) ManagementFactory.getOperatingSystemMXBean();

        long totalMemory = osBean.getTotalMemorySize();
        long freeMemory = osBean.getFreeMemorySize();
        long usedMemory = totalMemory - freeMemory;

        snapshot.setTotalMemory(totalMemory / 1024.0 / 1024 / 1024);
        snapshot.setFreeMemory(freeMemory / 1024.0 / 1024 / 1024);
        snapshot.setUsedMemory(usedMemory / 1024.0 / 1024 / 1024);

        snapshot.setCreatedAt(LocalDateTime.now().toString());

        return snapshot;
    }

    public void showSystemInfo(SystemSnapshot snapshot) {

        System.out.println("===== System Information =====");

        System.out.println("Operating System : " + snapshot.getOsName());
        System.out.println("OS Version       : " + snapshot.getOsVersion());
        System.out.println("Java Version     : " + snapshot.getJavaVersion());
        System.out.println("Username         : " + snapshot.getUsername());
        System.out.println("Computer Name    : " + snapshot.getComputerName());
        System.out.println("CPU Architecture : " + snapshot.getCpuArchitecture());
        System.out.println("Processors       : " + snapshot.getProcessors());

        System.out.println();
        System.out.println("===== Memory Information =====");

        System.out.printf("Total Memory     : %.2f GB%n",
                snapshot.getTotalMemory());

        System.out.printf("Free Memory      : %.2f GB%n",
                snapshot.getFreeMemory());

        System.out.printf("Used Memory      : %.2f GB%n",
                snapshot.getUsedMemory());

    }

}