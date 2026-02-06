package Flight;
import java.util.*;

// Main class to manage the flight booking system
public class flightbooking {

    static Map<String, flight> flights;

    // Constructor to initialize flight options
    public flightbooking() {
        flights = new HashMap<>();
        flights.put("Indigo", new flight("Indigo"));
        flights.put("Spicejet", new flight("Spicejet"));
    }

    // Book tickets for a specific flight
    public static void booktickets(String flightname, String name, int age, int seats) {
        flight flight = flights.get(flightname);
        if (flight != null) {
            String bookingid = flight.booktickets(name, age, seats);
            if (bookingid != null) {
                System.out.println("Ticket Booked Successfully. Ticket ID: " + bookingid);
            }
        }
    }

    // Cancel tickets based on booking ID
    public static void canceltickets(String flightname, String bookingid) {
        flight flight = flights.get(flightname);
        if (flight != null) {
            flight.canceltickets(bookingid);
        }
    }

    // Display basic flight details
    public static void displaydetails(String flightname) {
        flight flight = flights.get(flightname);
        if (flight != null) {
            flight.displayDetails();
        }
    }

    // Print all details including passengers
    public static void printdetails(String flightname) {
        flight flight = flights.get(flightname);
        if (flight != null) {
            flight.printDetails();
        }
    }

    // Main program flow
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        new flightbooking(); // Initialize the flights
        boolean state = true;

        while (state) {
            System.out.println("\nFlight Booking System");
            System.out.println("1. Book Tickets");
            System.out.println("2. Cancel Tickets");
            System.out.println("3. Print Flight Details");
            System.out.println("4. Exit");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    System.out.println("Choose the Flight (Indigo/Spicejet):");
                    String flightName = scanner.nextLine();
                    if (flights.containsKey(flightName)) {
                        displaydetails(flightName);
                        System.out.println("Enter your Name       : ");
                        String name = scanner.nextLine();
                        System.out.println("Enter your Age        : ");
                        int age = scanner.nextInt();
                        System.out.println("Enter Number Of Seats : ");
                        int seats = scanner.nextInt();
                        booktickets(flightName, name, age, seats);
                    } else {
                        System.out.println("Flight not found. Please enter a valid flight name.");
                    }
                    break;

                case 2:
                    System.out.println("Choose the Flight (Indigo/Spicejet):");
                    String flight1 = scanner.nextLine();
                    if (flights.containsKey(flight1)) {
                        System.out.println("Enter Your Booking ID:");
                        String bookingid = scanner.nextLine();
                        canceltickets(flight1, bookingid);
                    } else {
                        System.out.println("Flight not found. Please enter a valid flight name.");
                    }
                    break;

                case 3:
                    System.out.println("Choose the Flight (Indigo/Spicejet):");
                    String flight2 = scanner.nextLine();
                    if (flights.containsKey(flight2)) {
                        printdetails(flight2);
                    } else {
                        System.out.println("Flight not found. Please enter a valid flight name.");
                    }
                    break;

                case 4:
                    state = false;
                    break;

                default:
                    System.out.println("Invalid Option.");
            }
        }
        scanner.close();
    }
}
