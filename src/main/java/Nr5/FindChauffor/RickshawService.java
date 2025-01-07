package Nr5.FindChauffor;

//Import libraries

import java.util.ArrayList;
import java.util.List;

public class RickshawService {
    //Declaring private instances
    private TextUI ui;
    private String[][] districts;
    private List<Driver> drivers;
    private int districtNumber;

    //Constructor
    public RickshawService() {
        //Initializiation of the instances
        this.drivers = new ArrayList<>();
        this.ui = new TextUI();
        this.districts = new String[][]{
                // District 1
                {"Christiania", "Operaen", "Havnebad Islands Brygge"},
                // District 2
                {"Tivoli", "Rådhuspladsen", "Christiansborg"},
                // District 3
                {"Amalienborg", "Strøget", "Nyhavn"}
        };
    }

    //Method for running the RickShawService
    public void runRickshawService() {
        loadDrivers();
        System.out.println("" + "\n" +
                "      Welcome To Your Personal Rickshaw Service" + "\n"
                + "");
        boolean running = true;
        while (running) {
            int promptChoices = ui.promptNumeric("Pick between the following: " + "\n" +
                    "1. Show Drivers" + "\n" +
                    "2. Book Driver" + "\n" +
                    "3. Create New Driver" + "\n" +
                    "4. Exit Program", 1, 4);
            switch (promptChoices) {
                case 1:
                    showDrivers();
                    break;
                case 2:
                    showDestinationOptions();
                    pickDestinationOption();
                    bookDriver(getDistrictNumber());
                    break;
                case 3:
                    createNewDriver();
                    break;
                case 4:
                    System.out.println("Exiting...");
                    running = false;
                    break;
                default:
                    System.out.println("Invalid choice. Please try again");
                    break;
            }
        }
    }

    //Method for showing drivers
    public void showDrivers() {
        for (Driver driver : drivers) {
            System.out.println(driver.toString());
        }
    }

    //Method for loading drivers
    public void loadDrivers() {
        createDriver("Machmud", new int[]{0, 1, 2});
        createDriver("Eren", new int[]{3, 4, 5});
        createDriver("Ahmad", new int[]{6, 7, 8});
    }

    //Method for creating a new driver
    public void createNewDriver() {
        String inputName = ui.promptText("Whats the drivers name?");
        int promptChoiceForNewDriversCoverage = ui.promptNumeric("What is " + inputName + "'s coverage?" + "\n" +
                "1. For district 1" + "\n" +
                "2. For district 2" + "\n" +
                "3. For district 3");
        switch (promptChoiceForNewDriversCoverage) {
            case 1:
                int[] inputCoverage1 = {0, 1, 2};
                createDriver(inputName, inputCoverage1);
                System.out.println(inputName + " added as a driver");
                break;
            case 2:
                int[] inputCoverage2 = {3, 4, 5};
                createDriver(inputName, inputCoverage2);
                System.out.println(inputName + " added as a driver");
                break;
            case 3:
                int[] inputCoverage3 = {6, 7, 8};
                createDriver(inputName, inputCoverage3);
                System.out.println(inputName + " added as a driver");
                break;
        }
    }

    //Method for creating a new driver object
    public void createDriver(String name, int[] districtCoverage) {
        Driver driver = new Driver(name, districtCoverage);
        drivers.add(driver);

    }

    //Method for showing the destination options
    public void showDestinationOptions() {
        int counter = 1;
        for (int i = 0; i < districts.length; i++) {
            System.out.println("District " + (i + 1) + ":");
            for (int j = 0; j < districts[i].length; j++) {
                System.out.println("  " + counter + ". " + districts[i][j]);
                counter++;
            }
        }
    }

    //Method for letting the user choose a destination
    public void pickDestinationOption() {
        int promptDestinationChoice = ui.promptNumeric("Choose the destination option: ", 1, 9);
        switch (promptDestinationChoice) {
            case 1:
                System.out.println("Destination option Christiania selected");
                setDistrictNumber(1);
                break;
            case 2:
                System.out.println("Destination option Operaen selected");
                setDistrictNumber(1);
                break;
            case 3:
                System.out.println("Destination option Havnebad Islands Brygge selected");
                setDistrictNumber(1);
                break;
            case 4:
                System.out.println("Destination option Tivoli selected");
                setDistrictNumber(2);
                break;
            case 5:
                System.out.println("Destination option Rådhuspladsen selected");
                setDistrictNumber(2);
                break;
            case 6:
                System.out.println("Destination option Christiansborg selected");
                setDistrictNumber(2);
                break;
            case 7:
                System.out.println("Destination option Amalienborg selected");
                setDistrictNumber(3);
                break;
            case 8:
                System.out.println("Destination option Strøget selected");
                setDistrictNumber(3);
                break;
            case 9:
                System.out.println("Destination option Nyhavn selected");
                setDistrictNumber(3);
                break;
            default:
                System.out.println("Invalid option. Please try again.");
                break;
        }
    }

    //Method for booking a driver. This uses the method "findDriver" to find an available driver
    //With the correct district coverage (getDistrictNumber)
    public void bookDriver(int districtNumber) {
        Driver availableDriver = findDriver(getDistrictNumber());
        if (availableDriver != null) {
            availableDriver.setBooked(true);
            System.out.println("Driver " + availableDriver.getName() + " has been booked for District " + districtNumber);
        } else {
            System.out.println("No available drivers for District: " + districtNumber);
        }

    }

    //Method for finding out if a driver is available or not.
    private Driver findDriver(int districtNumber) {
        //Simple math to choose the correct district - Example if the district number is 1:
        //int start is set to 0 times 3 and int end is set to 0+2
        //Therefore it cycles through {0,1,2} aka the first district.
        int start = (districtNumber - 1) * 3;
        int end = start + 2;
        for (Driver driver : drivers) {
            for (int district : driver.getDistrictCoverage()) {
                if (district >= start && district <= end && !driver.isBooked()) {
                    driver.setBooked(true);
                    return driver;
                }
            }
        }
        return null;
    }

    //Getter and setter
    public int getDistrictNumber() {
        return districtNumber;
    }

    public void setDistrictNumber(int districtNumber) {
        this.districtNumber = districtNumber;
    }
}
