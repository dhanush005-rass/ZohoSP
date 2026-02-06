package Reservation;
import java.util.*;

// Main class to run the reservation system
public class Main {

    // Method to book a ticket for a passenger
    public static void bookticket(passenger p) {
        ticketbooker booker = new ticketbooker();

        // If no waiting list slots are available, booking is not possible
        if (ticketbooker.available_wl == 0) {
            System.out.println("No Tickets Available");
            return;
        }

        // Try to book preferred berth if available
        if ((p.berthPreference.equals("L") && ticketbooker.available_l > 0) ||
            (p.berthPreference.equals("M") && ticketbooker.available_m > 0) ||
            (p.berthPreference.equals("U") && ticketbooker.available_u > 0)) {

            System.out.println("Preferred Berth Available");

            // Book lower berth
            if (p.berthPreference.equals("L")) {
                System.out.println("Lower Birth Given");
                booker.bookticket(p, ticketbooker.lower_bir_pos.get(0), "L");
                ticketbooker.lower_bir_pos.remove(0);
                ticketbooker.available_l--;
            }

            // Book middle berth
            else if (p.berthPreference.equals("M")) {
                System.out.println("Middle Birth Given");
                booker.bookticket(p, ticketbooker.middle_bir_pos.get(0), "M");
                ticketbooker.middle_bir_pos.remove(0);
                ticketbooker.available_m--;
            }

            // Book upper berth
            else if (p.berthPreference.equals("U")) {
                System.out.println("Upper Birth Given");
                booker.bookticket(p, ticketbooker.upper_bir_pos.get(0), "U");
                ticketbooker.upper_bir_pos.remove(0);
                ticketbooker.available_u--;
            }
        }

        // Allocate next available berth if preferred berth is not available
        else if (ticketbooker.available_l > 0) {
            System.out.println("Preferred Birth Not Available, Lower Birth Given");
            booker.bookticket(p, ticketbooker.lower_bir_pos.get(0), "L");
            ticketbooker.lower_bir_pos.remove(0);
            ticketbooker.available_l--;
        }
        else if (ticketbooker.available_m > 0) {
            System.out.println("Preferred Birth Not Available, Middle Birth Given");
            booker.bookticket(p, ticketbooker.middle_bir_pos.get(0), "M");
            ticketbooker.middle_bir_pos.remove(0);
            ticketbooker.available_m--;
        }
        else if (ticketbooker.available_u > 0) {
            System.out.println("Preferred Birth Not Available, Upper Birth Given");
            booker.bookticket(p, ticketbooker.upper_bir_pos.get(0), "U");
            ticketbooker.upper_bir_pos.remove(0);
            ticketbooker.available_u--;
        }

        // Allocate RAC if no berths are available
        else if (ticketbooker.available_rac > 0) {
            System.out.println("RAC Available");
            booker.addtorac(p, ticketbooker.rac_bir_pos.get(0), "RAC");
        }

        // Allocate waiting list if no RAC is available
        else if (ticketbooker.available_wl > 0) {
            System.out.println("Waiting List");
            booker.addtorwl(p, ticketbooker.wl_pos.get(0), "WL");
        }
    }

    // Method to cancel a ticket using passenger ID
    public static void cancelticket(int id) {
        ticketbooker booker = new ticketbooker();
        if (!booker.passengers.containsKey(id)) {
            System.out.println("Passenger Details Invalid");
        } else {
            booker.cancelticket(id);
        }
    }

    // Main menu loop
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        boolean loop = true;
        while (loop) {
            System.out.println("1.Book Tickets\n2.Cancel Tickets\n3.Available Tickets\n4.Booked Tickets\n5.Exit");
            int choice = s.nextInt();
            switch (choice) {
                case 1:
                    System.out.println("Enter Name , Age ,  Birth Preference(L,M,U)  ");
                    String name = s.next();
                    int age = s.nextInt();
                    String birthPreference = s.next();
                    passenger p = new passenger(name, age, birthPreference);
                    bookticket(p);
                    break;
                case 2:
                    System.out.println("Enter ID:");
                    int id = s.nextInt();
                    cancelticket(id);
                    break;
                case 3:
                    ticketbooker booker = new ticketbooker();
                    booker.printavailabletickets();
                    break;
                case 4:
                    booker = new ticketbooker();
                    booker.printpassengerdetails();
                    break;
                case 5:
                    loop = false;
                    break;
                default:
                    break;
            }
        }
        s.close();
    }
}
