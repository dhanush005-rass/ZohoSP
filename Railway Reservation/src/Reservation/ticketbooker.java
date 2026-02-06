package Reservation;
import java.util.*;

// Class to handle all ticket booking logic
public class ticketbooker {

    // Available ticket counts
    static int available_l = 13;
    static int available_m = 13;
    static int available_u = 13;
    static int available_rac = 10;
    static int available_wl = 8;

    // Lists and queues for tracking ticket status
    static Queue<Integer> waitingList = new LinkedList<>();
    static Queue<Integer> racList = new LinkedList<>();
    static List<Integer> bookedTicketList = new ArrayList<>();

    // Berth positions
    static List<Integer> lower_bir_pos = new ArrayList<>(Arrays.asList(1,2,3,4,5,6,7,8,9,10,11,12,13));
    static List<Integer> middle_bir_pos = new ArrayList<>(Arrays.asList(1,2,3,4,5,6,7,8,9,10,11,12,13));
    static List<Integer> upper_bir_pos = new ArrayList<>(Arrays.asList(1,2,3,4,5,6,7,8,9,10,11,12,13));
    static List<Integer> rac_bir_pos = new ArrayList<>(Arrays.asList(1,2,3,4,5,6,7,8,9,10));
    static List<Integer> wl_pos = new ArrayList<>(Arrays.asList(1,2,3,4,5,6,7,8));

    // Stores all passenger objects mapped by ID
    static Map<Integer, passenger> passengers = new HashMap<>();

    // Method to book a confirmed ticket
    public void bookticket(passenger p, int berth_no, String allocated_berth) {
        p.number = berth_no;
        p.type = allocated_berth;
        passengers.put(p.passengerId, p);
        bookedTicketList.add(p.passengerId);
        System.out.println("--------------------------Booked Successfully");
    }

    // Method to add passenger to RAC
    public void addtorac(passenger p, int rac_no, String allocated_berth) {
        p.number = rac_no;
        p.type = allocated_berth;
        passengers.put(p.passengerId, p);
        racList.add(p.passengerId);
        rac_bir_pos.remove(0);
        available_rac--;
    }

    // Method to add passenger to waiting list
    public void addtorwl(passenger p, int wl_no, String type) {
        p.number = wl_no;
        p.type = type;
        passengers.put(p.passengerId, p);
        waitingList.add(p.passengerId);
        wl_pos.remove(0);
        available_wl--;
    }

    // Cancel a ticket and manage RAC and WL promotion
    public void cancelticket(int id) {
        passenger p = passengers.get(id);
        if (p == null) return;

        passengers.remove(id);
        bookedTicketList.remove(Integer.valueOf(id));
        int positionBooked = p.number;
        System.out.println("---------------Cancelled Successfully");

        // Free up the cancelled berth
        if (p.type.equals("L")) {
            available_l++;
            lower_bir_pos.add(positionBooked);
        } else if (p.type.equals("M")) {
            available_m++;
            middle_bir_pos.add(positionBooked);
        } else if (p.type.equals("U")) {
            available_u++;
            upper_bir_pos.add(positionBooked);
        }

        // Upgrade RAC to confirmed berth
        if (racList.size() > 0) {
            passenger passrac = passengers.get(racList.poll());
            int racpos = passrac.number;
            rac_bir_pos.add(racpos);
            available_rac++;

            // Upgrade WL to RAC
            if (waitingList.size() > 0) {
                passenger passwl = passengers.get(waitingList.poll());
                int wlpos = passwl.number;
                wl_pos.add(wlpos);
                available_wl++;

                passwl.number = rac_bir_pos.get(0);
                passwl.type = "RAC";
                racList.add(passwl.passengerId);
                rac_bir_pos.remove(0);
                available_rac--;
            }

            // Rebook the upgraded RAC passenger
            Main.bookticket(passrac);
        }
    }

    // Print current ticket availability
    public void printavailabletickets() {
        System.out.println("Available Lower Berths: " + available_l);
        System.out.println("Available Middle Berths: " + available_m);
        System.out.println("Available Upper Berths: " + available_u);
        System.out.println("Available RAC Tickets: " + available_rac);
        System.out.println("Available Waiting List: " + available_wl);
    }

    // Print details of all booked passengers
    public void printpassengerdetails() {
        for (passenger p : passengers.values()) {
            System.out.println("Passenger ID: " + p.passengerId +
                               ", Name: " + p.name +
                               ", Age: " + p.age +
                               ", Berth: " + p.type +
                               ", Number: " + p.number);
        }
    }
}
