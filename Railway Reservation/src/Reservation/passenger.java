package Reservation;

// Class to represent each passenger
public class passenger {
    static int id = 1; // Static ID to generate unique passenger IDs
    String name;
    int age;
    String berthPreference; // Preferred berth: L, M, or U
    int passengerId; // Unique passenger ID
    String type; // Allocated berth type (L, M, U, RAC, WL)
    int number; // Allocated berth/RAC/WL number

    // Constructor to create a new passenger
    public passenger(String name, int age, String berthPreference) {
        this.name = name;
        this.age = age;
        this.berthPreference = berthPreference;
        this.passengerId = id++; // Assign and increment ID
        this.type = "";
        this.number = -1;
    }
}
