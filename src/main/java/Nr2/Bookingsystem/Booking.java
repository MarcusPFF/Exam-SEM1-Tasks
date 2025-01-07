package Nr2.Bookingsystem;

import java.time.LocalDateTime;

public class Booking {
    //Initialising private variables
    private Room room;
    private User user;
    private LocalDateTime start;
    private LocalDateTime end;

    //Constructor
    public Booking(Room room, User user, LocalDateTime start, LocalDateTime end) {
        this.room = room;
        this.user = user;
        this.start = start;
        this.end = end;
    }

    //Getters
    public Room getRoom() {
        return room;
    }

    public User getUser() {
        return user;
    }

    public LocalDateTime getStart() {
        return start;
    }

    public LocalDateTime getEnd() {
        return end;
    }


    //toString
    @Override
    public String toString() {
        return "Booking{" +
                "room=" + room +
                ", user=" + user +
                ", start=" + start +
                ", end=" + end +
                '}';
    }
}
