package taxi;

/**
 * Represents a single taxi booking with details like pickup/drop time,
 * location, fare, and customer info.
 */
public class Booking {
    int bookingid;    // Unique ID for the booking (per taxi)
    int customerid;   // Customer who made the booking
    int pickuptime;   // Time when taxi should pick up
    int droptime;     // Estimated drop time
    int amount;       // Fare for the trip
    char pickup;      // Pickup location (A-F)
    char drop;        // Drop location (A-F)

    /**
     * Constructor to initialize all booking details.
     */
    public Booking(int bookingid, int customerid, int pickuptime, int droptime,
                   int amount, char pickup, char drop) {
        this.bookingid = bookingid;
        this.customerid = customerid;
        this.pickuptime = pickuptime;
        this.droptime = droptime;
        this.amount = amount;
        this.pickup = pickup;
        this.drop = drop;
    }
}
