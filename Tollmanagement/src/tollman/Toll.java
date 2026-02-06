package tollman;

import java.util.*;

class Toll {
    int tollId;
    Map<String, Integer> vehicleCharges; // e.g., {"Car": 50, "Bike": 20, "Truck": 100}
    Map<String, Integer> vehicleCollections; // VehicleNumber -> AmountPaid

    public Toll(int tollId, Map<String, Integer> vehicleCharges) {
        this.tollId = tollId;
        this.vehicleCharges = vehicleCharges;
        this.vehicleCollections = new HashMap<>();
    }

    public int calculateToll(String vehicleType, boolean isVIP) {
        int amount = vehicleCharges.getOrDefault(vehicleType, 0);
        if (isVIP) {
            amount = (int) (amount * 0.5); // VIPs pay half
        }
        return amount;
    }

    public void recordVehicle(Vehicle vehicle, int amount) {
        vehicleCollections.put(vehicle.vehicleNumber,
                vehicleCollections.getOrDefault(vehicle.vehicleNumber, 0) + amount);
    }

    public void displayDetails() {
        System.out.println("Toll ID: " + tollId);
        System.out.println("Charges: " + vehicleCharges);
        System.out.println("Collections: " + vehicleCollections);
        System.out.println("---------------------------");
    }
}
