package Nr2.Bookingsystem;

//Import libraries

import java.time.LocalDateTime;
import java.util.List;
import java.util.Scanner;

public class RunBookingSystem {
    //Method for running the application. Everything in here happens in a while running = true loop.
    public void runApplication() {
        boolean running = true;
        BookingSystem bs = new BookingSystem();
        bs.loadAllRooms();
        bs.loadAllUsers();

        Scanner scanner = new Scanner(System.in);
        while (running) {
            //Prints out options in the console
            System.out.println("------Choose an option------");
            System.out.println("1. Book a room");
            System.out.println("2. Find available rooms");
            System.out.println("3. Cancel a booking");
            System.out.println("4. Create a one-time user");
            System.out.println("5. List of all users");
            System.out.println("6. Exit");

            //Scans for user input
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    //Booking a room
                    //Checks if the room exists
                    System.out.println("Enter room name:");
                    String roomName = scanner.nextLine();
                    Room roomToBook = null;
                    for (Room room : bs.getRooms()) {
                        if (room.getName().equalsIgnoreCase(roomName)) {
                            roomToBook = room;
                            break;
                        }
                    }
                    if (roomToBook == null) {
                        System.out.println("Room not found.");
                        break;
                    }
                    //Checks if the user exists
                    System.out.println("Enter user email:");
                    String userEmail = scanner.nextLine();
                    User user = null;
                    for (User u : bs.getUsers()) {
                        if (u.getEmail().equalsIgnoreCase(userEmail)) {
                            user = u;
                            break;
                        }
                    }
                    if (user == null) {
                        System.out.println("User not found.");
                        break;
                    }

                    //Initializing the localDateTime at this very moment and ends in 2 hours.
                    LocalDateTime start = LocalDateTime.now().withSecond(0).withNano(0);
                    LocalDateTime end = start.plusHours(2);

                    //if all the other requirements are fulfilled, the user can book the room.
                    Booking booking = bs.book(roomToBook, user, start, end);
                    if (booking != null) {
                        System.out.println("Booking successful!");
                    } else {
                        System.out.println("Booking failed!");
                    }
                    break;

                case 2:
                    try {
                        //Finding an available room. First the user types the desired capacity.
                        System.out.println("Enter minimum capacity:");
                        int capacity = scanner.nextInt();
                        scanner.nextLine();

                        //Check if user input is within a valid range
                        if (capacity >= 1 && capacity <= 1000) {

                            //Initializing the localDateTime at this very moment and ends in 2 hours.
                            start = LocalDateTime.now().withSecond(0).withNano(0);
                            end = start.plusHours(2);

                            //findAvailable method is being run with (capacity, start, end) as arguments.
                            List<Room> availableRooms = bs.findAvailable(capacity, start, end);
                            if (!availableRooms.isEmpty()) {
                                System.out.println("Available rooms with this time slot (" + start + " - " + end + "):");
                                for (Room room : availableRooms) {
                                    System.out.println(room.getName());
                                }
                            } else {
                                System.out.println("Not available rooms found");
                            }
                        } else {
                            // If capacity is within valid range, show this message.
                            System.out.println("Capacity must be between 1 and 1000.");
                        }
                        break;
                    } catch (Exception e) {
                        System.out.println("Must be a number");
                        scanner.nextLine();
                        break;
                    }


                case 3:
                    //This options cancels the current booking for the desired user.
                    System.out.println("Enter room name to cancel booking:");
                    String roomNameToCancel = scanner.nextLine();
                    Room roomToCancel = null;
                    for (Room room : bs.getRooms()) {
                        if (room.getName().equalsIgnoreCase(roomNameToCancel)) {
                            roomToCancel = room;
                            break;
                        }
                    }
                    if (roomToCancel == null) {
                        System.out.println("Room not found.");
                        break;
                    }

                    System.out.println("Enter user email:");
                    String userEmailToCancel = scanner.nextLine();
                    User userToCancel = null;
                    for (User u : bs.getUsers()) {
                        if (u.getEmail().equalsIgnoreCase(userEmailToCancel)) {
                            userToCancel = u;
                            break;
                        }
                    }
                    if (userToCancel == null) {
                        System.out.println("User not found.");
                        break;
                    }

                    Booking bookingToCancel = null;
                    for (Booking b : bs.getBookings()) {
                        if (b.getRoom().equals(roomToCancel) && b.getUser().equals(userToCancel)) {
                            bookingToCancel = b;
                            break;
                        }
                    }
                    if (bookingToCancel != null) {
                        bs.cancel(bookingToCancel);
                        System.out.println("Booking canceled.");
                    } else {
                        System.out.println("Booking not found.");
                    }
                    break;

                case 4:
                    //This option creates a new user.
                    System.out.println("Enter your name");
                    String nameInput = scanner.nextLine();
                    System.out.println("Enter your email");
                    String emailInput = scanner.nextLine();

                    bs.createNewUser(nameInput, emailInput);
                    System.out.println("User successful created!");
                    break;

                case 5:
                    //This option shows a list of all users and their bookings
                    System.out.println("List of all users");
                    for (User u : bs.getUsers()) {
                        System.out.println(u.toString());
                    }
                    break;

                case 6:
                    //This option stops the while (running) loop and makes it false
                    System.out.println("Exiting...");
                    running = false;
                    break;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}