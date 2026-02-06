package flight;
import java.util.*;

class flight {

	private static int id = 0;                          // ID generator
	private static Map<Integer, passenger> passengers;  // Stores booked passengers
	private static Queue<passenger> wl;                // Waiting list
	private static int[][] seats;                      // Seat grid
	private static int noseat = 100;                   // Total available seats
	private static Scanner scanner = new Scanner(System.in);

	// Constructor to initialize seat layout
	public flight() {
		passengers = new HashMap<>();
		wl = new LinkedList<>();
		seats = new int[4][25]; // 4 rows, 25 seats each = 100 seats
		int count = 1;

		// Fill seats with seat numbers 1 to 100
		for (int i = 0; i < seats.length; i++) {
			for (int j = 0; j < seats[i].length; j++) {
				seats[i][j] = count++;
			}
		}
	}

	// Print seat availability
	public static void printseat() {
	    System.out.println("\nAvailable Seats:");
	    for (int i = 0; i < seats.length; i++) {
	        for (int j = 0; j < seats[i].length; j++) {
	            if (seats[i][j] == 0) {
	                System.out.print("[ X ] "); // Booked seat
	            } else {
	                System.out.printf("[%3d] ", seats[i][j]); // Aligns all numbers to width 3
	            }
	        }
	        System.out.println();
	    }
	}

	// Book a ticket
	public static void bookticket(String name, int age) {
		if (noseat == 0) {
			// No seats available, add to waiting list
			id++;
			passenger passenger = new passenger(id, name, age, "WL");
			wl.add(passenger);
			System.out.println("No seats available. Added to waiting list. ID: " + id);
			return;
		}

		printseat();
		System.out.print("Enter Seat Number (1 to 100): ");
		String seat = scanner.next();

		int num;
		try {
			num = Integer.parseInt(seat);
		} catch (NumberFormatException e) {
			System.out.println("Invalid seat number.");
			return;
		}

		int i = -1, j = -1;
		boolean found = false;

		// Locate the seat in the 2D array
		for (int r = 0; r < seats.length; r++) {
			for (int c = 0; c < seats[r].length; c++) {
				if (seats[r][c] == num) {
					i = r;
					j = c;
					found = true;
					break;
				}
				if(seats[r][c]==0)
				{
					System.out.println("The Seat Is Already Booked");
					break;
				}
			}
			if (found) break;
		}

		if (!found) {
			System.out.println("Invalid seat number.");
			return;
		}

		// If seat is available
		if (seats[i][j] != 0) {
			id++;
			passenger passenger = new passenger(id, name, age, seat);
			seats[i][j] = 0; // mark seat as booked
			noseat--;
			passengers.put(id, passenger);
			System.out.println("Seat Booked Successfully. Passenger ID: " + id);
		} else {
			System.out.println("Seat already booked.");
		}
	}

	// Cancel a ticket and promote WL if any
	public static void cancelticket() {
		System.out.print("Enter Booking ID to Cancel: ");
		int cid = scanner.nextInt();

		if (passengers.containsKey(cid)) {
			passenger cpassenger = passengers.get(cid);
			String seatStr = cpassenger.returnseat();
			int num = Integer.parseInt(seatStr);
			boolean found = false;

			// Find the cancelled seat and mark it as available
			for (int i = 0; i < seats.length; i++) {
				for (int j = 0; j < seats[i].length; j++) {
					if (seats[i][j] == 0 && !found) {
						int originalSeat = (i * 25) + j + 1;
						if (originalSeat == num) {
							seats[i][j] = num;
							found = true;
							noseat++;
						}
					}
				}
			}

			passengers.remove(cid);
			System.out.println("Ticket Cancelled Successfully for ID: " + cid);

			// Promote waiting list passenger if available
			if (!wl.isEmpty()) {
				passenger wpassenger = wl.poll();
				wpassenger.seat = seatStr;
				int wid = wpassenger.getid();
				passengers.put(wid, wpassenger);
				noseat--;
				System.out.println("Waiting list passenger promoted to seat: " + seatStr + " (ID: " + wid + ")");
			}

		} else {
			System.out.println("Invalid ID. No such passenger found.");
		}
	}

	// Display all booked passengers
	public static void printpassengers() {
		System.out.println("\n--- Booked Passengers ---");
		if (passengers.isEmpty()) {
			System.out.println("No passengers booked.");
			return;
		}
		for (passenger passenger : passengers.values()) {
			System.out.println(passenger.toString());
		}
	}

	// Main method with menu
	public static void main(String[] args) {
		flight f = new flight();

		while (true) {
			System.out.println("\n========== Flight Ticket Booking System ==========");
			System.out.println("1. Book Ticket");
			System.out.println("2. Cancel Ticket");
			System.out.println("3. Print Booked Passengers");
			System.out.println("4. Print Seat Layout");
			System.out.println("5. Exit");
			System.out.print("Enter your choice: ");
			int choice = scanner.nextInt();

			switch (choice) {
				case 1:
					System.out.print("Enter Name: ");
					String name = scanner.next();
					System.out.print("Enter Age: ");
					int age = scanner.nextInt();
					bookticket(name, age);
					break;

				case 2:
					cancelticket();
					break;

				case 3:
					printpassengers();
					break;

				case 4:
					printseat();
					break;

				case 5:
					System.out.println("Thank you for using the Flight Booking System.");
					return;

				default:
					System.out.println("Invalid choice. Please try again.");
			}
		}
	}
}
