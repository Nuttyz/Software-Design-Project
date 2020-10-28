/*
 * Copyright (c) 2020. Chaiyong Ragkhitwetsagul
 * All rights reserved.
 */

package com.example.SD2.edu.gemini.app.ocs.model;

import jparsec.ephem.Functions;
import jparsec.observer.LocationElement;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * This is a class that represents the virtual telescope in the Gemini system.
 */
@SuppressWarnings("ALL")
@Entity
public class VirtualTelescope {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private String name;
    private String location;
    private Date installedDate;
//    private BaseSciencePlan plan = null;
//    private LocationElement starLocation = new LocationElement();

    public static String NORTH = "Gemini North";
    public static String SOUTH = "Gemini South";

    public enum COMMAND {
        START, UP, DOWN, LEFT, RIGHT, FOCUS, TAKE_PHOTO, STOP
    }

    /**
     * A constructor
     */
    public VirtualTelescope() {
        this.name = NORTH;
        this.location = "Mauna Kea, Hawaii";
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        try {
            this.installedDate = format.parse( "2000-01-01" );
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    /**
     * A constructor with given parameters
     * @param name - the name of the virtual telescope
     * @param location - the location of the actual telescope that this virtual telescope represents
     * @param installedDate - the date the virtual telescope is installed
     */
    private VirtualTelescope(String name, String location, String installedDate) {
        this.name = name;
        this.location = location;
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        try {
            this.installedDate = format.parse( installedDate);
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    private static VirtualTelescope vt = null;

    /**
     * A static method to get an instance of VirtualTelescope class.
     * This is implemented as a singleton class so only one active VirtualTelescope object exists.
     * @return an instance of a virtual telescope class
     */
    public static VirtualTelescope getInstance()
    {
        if (vt == null)
            vt = new VirtualTelescope();
        return vt;
    }

    /**
     * Assign a science plan to the virtual telscope
     * @param plan - a science plan, which can be a subclass of {@link BaseSciencePlan} class.
     */
//    public void setSciencePlan(BaseSciencePlan plan) {
//        this.plan = plan;
//    }

    /**
     * Get the currently assigned science plan
     * @return the science plan
     */


    /**
     * Exception class when no science plan is assigned to the virtual telescope when executing it.
     */
    public class NoSciencePlanException extends Exception {
        public NoSciencePlanException(String message) {
            super(message);
        }
    }

    /**
     * Execute the given science plan
     * @return true if successfully executed the science plan, false if failed to execute the plan
     */
    public boolean executeSciencePlan() throws NoSciencePlanException {
        double threshold = 90;
        // a fake code to generate successful results with 90% probability
        double d = Math.random() * 100;
        if (d <= threshold) {
            return true;
        } else {
            return false;
        }
    }

//    public boolean executeCommand(COMMAND c) {
////        double lat = starLocation.getLatitude();
////        double lon = starLocation.getLongitude();
//        double step = 10;
//        switch (c) {
//            case START:
//                System.out.println("Starting the virtual telescope ...");
////                System.out.println("Current star location: " + printStarLocation(starLocation.get()));
//                break;
//            case STOP:
//                System.out.println("Stopping the virtual telescope ...");
//                break;
//            case UP:
//                if (lat + step <= 90) {
//                    starLocation.setLatitude(lat + step);
//                }
//                System.out.println("Current star location: " + printStarLocation(starLocation.get()));
//                break;
//            case DOWN:
//                if (lat - step >= -90) {
//                    starLocation.setLatitude(lat - step);
//                }
//                System.out.println("Current star location: " + printStarLocation(starLocation.get()));
//                break;
//            case LEFT:
//                if (lon + step <= 180) {
//                    starLocation.setLongitude(lon + step);
//                }
//                System.out.println("Current star location: " + printStarLocation(starLocation.get()));
//                break;
//            case RIGHT:
//                if (lon - step >= -180) {
//                    starLocation.setLongitude(lon - step);
//                }
//                System.out.println("Current star location: " + printStarLocation(starLocation.get()));
//                break;
//            case FOCUS:
//                System.out.println("Auto focusing ...");
//                break;
//            case TAKE_PHOTO:
//                System.out.println("Taking a photo ...");
//                break;
//            default:
//                System.out.println("Invalid command");
//                break;
//        }
//        return true;
//    }

    private double degreeToRadian(double degree) {
        return (degree * Math.PI)/180;
    }

    private String printStarLocation(double[] loc) {
        return "Longitude: " + loc[0] + ", latitude: " + loc[1] + ", radius: " + loc[2];
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Date getInstalledDate() {
        return installedDate;
    }

    public void setInstalledDate(Date installedDate) {
        this.installedDate = installedDate;
    }

    /**
     * Print out name, location and installed date.
     * @return A string representation of the class
     */
    public String toString() {
        return this.name + ", " + this.location + "\nInstalled on: " + this.installedDate.toString();
    }
}
