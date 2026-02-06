package taxi;
import java.util.*;

/**
 * Main class to handle taxi booking operations like initializing taxis,
 * booking a taxi, and displaying taxi details.
 */
public class taxibooking {

    // Unique customer ID counter (auto-incremented with each booking)
    static int customerid = 1;

    // List to store all available taxi instances
    static List<taxi> taxies = new ArrayList<>();

    // Scanner for user input
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Enter The Number of Taxies: ");
        int num = sc.nextInt();

        // Initialize taxis with unique IDs
        initializetaxi(num);

        // Menu-driven interface
        while (true) {
            System.out.println("\nChoose An Option\n1. Book Taxi\n2. Taxi Details\n3. Exit");
            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    booktaxi();
                    break;
                case 2:
                    displaytaxi();
                    break;
                case 3:
                    return;
                default:
                    System.out.println("Enter A Valid Choice");
            }
        }
    }

    /**
     * Initializes the specified number of taxis.
     * Each taxi gets a unique ID (0-based index).
     */
    public static void initializetaxi(int num) {
        for (int i = 0; i < num; i++) {
            taxies.add(new taxi(i));
        }
    }

    /**
     * Handles taxi booking:
     * - Finds an available taxi nearest to the pickup point
     * - Books it if found
     * - Calculates drop time and fare
     */
    public static void booktaxi() {
        System.out.println("Enter The Pickup point (A-F): ");
        char pickup = sc.next().toUpperCase().charAt(0);

        System.out.println("Enter The Drop point (A-F): ");
        char drop = sc.next().toUpperCase().charAt(0);

        System.out.println("Enter The Pickup Time: ");
        int time = sc.nextInt();

        taxi selectedtaxi = null;
        int minimumdistance = Integer.MAX_VALUE;

        // Find the nearest available taxi
        for (taxi taxi : taxies) {
            if (taxi.isavailable(time)) {
                int distance = Math.abs(taxi.currentpos - pickup);

                // Choose taxi based on nearest distance and lowest earnings
                if (distance < minimumdistance ||
                    (distance == minimumdistance && 
                     (selectedtaxi == null || taxi.totalearnings < selectedtaxi.totalearnings))) {
                    selectedtaxi = taxi;
                    minimumdistance = distance;
                }
            }
        }

        // No taxi available
        if (selectedtaxi == null) {
            System.out.println("No Taxi Available at the Time");
            return;
        }

        // Calculate drop time and fare
        int droptime = time + Math.abs(pickup - drop);
        int amount = selectedtaxi.calculateearnings(pickup, drop);
        int bookingid = selectedtaxi.bookings.size() + 1;

        // Create and add booking
        Booking booking = new Booking(bookingid, customerid++, time, droptime, amount, pickup, drop);
        selectedtaxi.addbooking(booking);

        System.out.println("Taxi " + selectedtaxi.id + " is Allotted");
    }

    /**
     * Displays all taxi details including booking history and earnings.
     */
    public static void displaytaxi() {
        for (taxi taxi : taxies) {
            System.out.println("\nTaxi-" + taxi.id + " Total Earnings: Rs." + taxi.totalearnings);
            System.out.printf("%-10s %-12s %-6s %-6s %-12s %-10s %-6s%n",
                    "BookingID", "CustomerID", "From", "To", "PickupTime", "DropTime", "Amount");

            for (Booking booking : taxi.bookings) {
                System.out.printf("%-10d %-12d %-6c %-6c %-12d %-10d %-6d%n",
                        booking.bookingid, booking.customerid, booking.pickup, booking.drop,
                        booking.pickuptime, booking.droptime, booking.amount);
            }
        }
    }
}
