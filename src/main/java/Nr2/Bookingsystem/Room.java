package Nr2.Bookingsystem;

public class Room {
    //Initialising private variables
    private String name;
    private int roomNumber;
    private int capacity;

    //Constructor
    public Room(String name, int roomNumber, int capacity) {
        this.name = name;
        this.roomNumber = roomNumber;
        this.capacity = capacity;
    }

    //Getters
    public String getName() {
        return name;
    }

    public int getRoomNumber() {
        return roomNumber;
    }

    public int getCapacity() {
        return capacity;
    }
}
