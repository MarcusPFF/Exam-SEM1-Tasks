package Nr5.FindChauffor;

import java.util.*;

public class Driver {
    //Declaring private instances
    private String name;
    private boolean isBooked;
    private int[] districtCoverage;

    //Constructor
    public Driver(String name, int[] districtCoverage) {
        //Initialising instances
        this.name = name;
        this.isBooked = false;
        this.districtCoverage = districtCoverage;
    }

    //Getter and setter
    public boolean isBooked() {
        return isBooked;
    }

    public void setBooked(boolean booked) {
        isBooked = booked;
    }

    public String getName() {
        return name;
    }

    public int[] getDistrictCoverage() {
        return districtCoverage;
    }

    @Override
    public String toString(){
        return "Driver Name: " + name + ", Destination Coverage: " + Arrays.toString(districtCoverage) + ", Booked: " + isBooked;
    }
}
