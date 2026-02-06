package Flight;
import java.util.*;

// Class representing a flight and its booking logic
public class flight {
    private String flightname;
    private int ticketprice;
    private int totseats;
    private Map<String, passenger> bookings;
    private int bookingcounter;

    // Constructor to initialize flight with default values
    public flight(String flightname) {
        this.flightname = flightname;
        this.ticketprice = 5000;
        this.totseats = 50;
        this.bookings = new HashMap<>();
        this.bookingcounter = 0;
    }

    // Method to book tickets
    public String booktickets(String passname, int age, int seats) {
        if (seats <= totseats) {
            bookingcounter++;
            String bookingid = "T" + bookingcounter;
            passenger passenger = new passenger(bookingid, passname, age, seats);
            bookings.put(bookingid, passenger);
            ticketprice += (200 * seats); // Ticket price increases per seat
            totseats -= seats;
            return bookingid;
        } else {
            System.out.println("Only " + totseats + " seats available.");
            return null;
        }
    }

    // Method to cancel ticket and free up seats
    public void canceltickets(String bookingid) {
        passenger passenger = bookings.get(bookingid);
        if (passenger != null) {
            int seats = passenger.getnoofseats();
            totseats += seats;
            ticketprice -= (200 * seats); // Adjust ticket price down
            bookings.remove(bookingid);
            System.out.println("Ticket canceled successfully.");
        } else {
            System.out.println("Booking ID not found.");
        }
    }

    // Display flight details without passenger list
    public void displayDetails() {
        System.out.println("\nFlight: " + flightname);
        System.out.println("Available Seats: " + totseats);
        System.out.println("Current Ticket Price: ₹" + ticketprice);
    }

    // Display all details including passengers
    public void printDetails() {
        System.out.println("\nFlight: " + flightname);
        System.out.println("Available Seats: " + totseats);
        System.out.println("Current Ticket Price: ₹" + ticketprice);
        System.out.println("Passengers:");
        for (passenger passenger : bookings.values()) {
            System.out.println(passenger);
        }
    }
}
