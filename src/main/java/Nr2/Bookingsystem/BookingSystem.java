package Nr2.Bookingsystem;

//Import libraries
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class BookingSystem {
    // Declaring private variables as List interfaces for storing Booking, Room, and User objects
    private List<Booking> bookings;
    private List<Room> rooms;
    private List<User> users;

    //Constructor where I initialize my variables as an ArrayList
    public BookingSystem() {
        bookings = new ArrayList<>();
        rooms = new ArrayList<>();
        users = new ArrayList<>();
    }

    //Method to load users into my Users ArrayList
    public void loadAllUsers() {
        users.add(new User("Marcus", "marcus123@gmail.com"));
        users.add(new User("Signe", "signe123@gmail.com"));
        users.add(new User("Tine", "tine123@gmail.com"));
    }

    //Method to create a new user (String nameInput and String emailInput as parameters)
    public User createNewUser(String nameInput, String emailInput) {
        User newUser = new User(nameInput, emailInput);
        users.add(newUser);
        return newUser;
    }

    //Method for loading Room objects into my Room ArrayList
    public void loadAllRooms() {
        addRoom(new Room("Study room1", 325, 6));
        addRoom(new Room("Study room2", 326, 4));
        addRoom(new Room("Study room3", 325, 2));
        addRoom(new Room("Study room4", 326, 2));
        addRoom(new Room("Classroom1", 303, 28));
        addRoom(new Room("Classroom2", 304, 29));
        addRoom(new Room("Classroom3", 305, 27));
        addRoom(new Room("Meeting room1", 310, 10));
        addRoom(new Room("Meeting room2", 311, 12));
        addRoom(new Room("Conference room", 400, 50));
        addRoom(new Room("Lounge", 450, 15));
        addRoom(new Room("Auditorium", 500, 100));
    }

    /*Method for checking if a room is available. If getRoom() == room and
    the time range (start , end) is conflicting with an existing booking (getStart() , getEnd())
    returns false, if not then true
     */
    public boolean isAvailable(Room room, LocalDateTime start, LocalDateTime end) {
        for (Booking booking : bookings) {
            if (booking.getRoom().equals(room) && (start.isBefore(booking.getEnd()) && end.isAfter(booking.getStart()))) {
                System.out.println("Room is not available: " + room.getName());
                return false;
            }
        }
        return true;
    }

    /* Method for finding an available room. I initialize a new ArrayList where it takes Room objects
   and then uses a for loop to go through the Room objects.
   is the if-statement true, I add the room to my new ArrayList.
     */
    public List<Room> findAvailable(int capacity, LocalDateTime start, LocalDateTime end) {
        List<Room> availableRooms = new ArrayList<>();
        for (Room room : rooms) {
            if (room.getCapacity() >= capacity && isAvailable(room, start, end)) {
                availableRooms.add(room);
            } else {
                System.out.println("Too small of a capacity for: " + room.getName());
            }
        }
        return availableRooms;
    }

    /* Method for booking a room. It takes a Room object, User object and the LocalDateTime objects as a parameter
   I use these parameters as arguments in my  if-statement with the isAvailble method
   if it goes through, booking has been made if not, returns null.
     */
    public Booking book(Room room, User user, LocalDateTime start, LocalDateTime end) {
        if (isAvailable(room, start, end)) {
            Booking booking = new Booking(room, user, start, end);
            bookings.add(booking);
            System.out.println("Booking added: " + room.getName());
            return booking;
        }
        System.out.println("Booking failed: " + room.getName());
        return null;
    }

    /*
    Method for getting the room booked by an individual user
     */
    public List<Booking> getBookedByUser(User user) {
        List<Booking> bookingsByUser = new ArrayList<>();
        for (Booking booking : bookings) {
            if (booking.getUser().equals(user)) {
                bookingsByUser.add(booking);
            }
        }
        return bookingsByUser;
    }

    //Methods for cancelling a booking and adding a room
    public void cancel(Booking booking) {
        bookings.remove(booking);
    }

    public void addRoom(Room room) {
        rooms.add(room);
    }

    //Getters
    public List<Room> getRooms() {
        return rooms;
    }

    public List<Booking> getBookings() {
        return bookings;
    }

    public List<User> getUsers() {
        return users;
    }

}