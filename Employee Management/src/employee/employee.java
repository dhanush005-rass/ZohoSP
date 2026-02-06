package employee;

import java.util.Scanner;

// Class to represent a single Employee
public class employee {
    // Private fields for encapsulation
    private int id;
    private String name;
    private String phone;  // Changed to String to allow flexibility (starting with 0, etc.)
    private String gender;
    private int salary;
    private String role;

    // Scanner for editing input
    Scanner scanner = new Scanner(System.in);

    // Constructor to initialize employee details
    public employee(int id, String name, String phone, String gender, int salary, String role) {
        this.id = id;
        this.name = name;
        this.phone = phone;
        this.gender = gender;
        this.salary = salary;
        this.role = role;
    }

    // Method to edit specific information of an employee
    public void editinfo() {
        System.out.println("Enter the info you want to edit:\n1. Phone\n2. Salary\n3. Role");
        int choice = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        switch (choice) {
            case 1:
                System.out.print("Enter the new phone number: ");
                this.phone = scanner.nextLine();
                break;
            case 2:
                System.out.print("Enter the updated salary: ");
                this.salary = scanner.nextInt();
                break;
            case 3:
                System.out.print("Enter the new role: ");
                this.role = scanner.next();
                break;
            default:
                System.out.println("Invalid choice.");
        }
    }

    // Getter for ID (used to identify employees)
    public int returnid() {
        return id;
    }

    // String representation of employee (used when printing details)
    public String toString() {
        return "Employee ID: " + id +
               ", Name: " + name +
               ", Phone: " + phone +
               ", Gender: " + gender +
               ", Salary: " + salary +
               ", Role: " + role;
    }
}
