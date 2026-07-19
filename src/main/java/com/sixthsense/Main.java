package com.sixthsense;


import com.sixthsense.agent.SixthSenseAgent;



public class Main {


    public static void main(String[] args) {


        System.out.println("================================");
        System.out.println("  SixthSense SxS Version 0.0");
        System.out.println("  Programmer: Kaung");
        System.out.println("================================");



        SixthSenseAgent agent =
                new SixthSenseAgent();


        agent.start();


    }

}