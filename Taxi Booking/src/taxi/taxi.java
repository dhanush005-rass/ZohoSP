package taxi;
import java.util.*;

/**
 * Represents a single taxi with an ID, current position, earnings, and list of bookings.
 */
public class taxi {
    int id;  // Unique taxi ID
    char currentpos = 'A';  // Initial position
    int totalearnings = 0;  // Total earnings of the taxi
    List<Booking> bookings = new ArrayList<>();  // List of completed bookings

    /**
     * Constructor to create a taxi with the given ID.
     */
    public taxi(int id) {
        this.id = id;
    }

    /**
     * Checks if the taxi is available at the requested pickup time.
     * A taxi is available if its last drop time is <= requested time.
     */
    public boolean isavailable(int requesttime) {
        if (bookings.isEmpty()) {
            return true;
        }
        Booking lastbooking = bookings.get(bookings.size() - 1);
        return (lastbooking.droptime <= requesttime);
    }

    /**
     * Calculates earnings for a ride from 'from' to 'to'.
     * Fare = ₹100 base + ₹15 per km (1 unit between two letters = 1 km)
     */
    public int calculateearnings(char from, char to) {
        int distance = Math.abs(from - to);
        return 100 + (distance * 15);
    }

    /**
     * Adds a booking to this taxi's history and updates position and earnings.
     */
    public void addbooking(Booking booking) {
        bookings.add(booking);
        this.currentpos = booking.drop;
        this.totalearnings += booking.amount;
    }
}
