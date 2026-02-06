package flight;

// Class to represent a passenger
class passenger {
	
	private int id;           // Passenger ID
	private String name;      // Passenger name
	private int age;          // Passenger age
	String seat;              // Booked seat or WL (waiting list)

	// Constructor to initialize passenger details
	public passenger (int id, String name, int age, String seat) {
		this.id = id;
		this.name = name;
		this.age = age;
		this.seat = seat;
	}

	// Returns the seat string (e.g., "12" or "WL")
	public String returnseat() {
		return seat;
	}

	// Returns passenger ID
	public int getid() {
		return id;
	}

	// String representation of the passenger for display
	public String toString() {
		return "Passenger ID: " + id + ", Name: " + name + ", Age: " + age + ", Seat: " + seat;
	}
}
