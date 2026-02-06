package Flight;

// Class representing a passenger's booking
public class passenger {
    private String bookingid;
    private String passname;
    private int age;
    private int seats;

    // Constructor for passenger
    public passenger(String bookingid, String passname, int age, int seats) {
        this.bookingid = bookingid;
        this.passname = passname;
        this.age = age;
        this.seats = seats;
    }

    // Getter for booking ID
    public String getbookingid() {
        return bookingid;
    }

    // Getter for number of seats
    public int getnoofseats() {
        return seats;
    }

    // String representation for printing passenger details
    public String toString() {
        return "Passenger{ Name: " + passname + ", Age: " + age + ", Booking ID: " + bookingid + ", Seats: " + seats + " }";
    }
}
