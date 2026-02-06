package employee;

import java.util.*;

// Main class that manages employee records
public class Main {
    // Map to store employees with ID as key
    private static Map<Integer, employee> employees;

    // ID generator to assign unique IDs to employees
    private static int idgen;

    // Constructor initializes the employee map and id generator
    public Main() {
        employees = new HashMap<>();
        idgen = 0;
    }

    // Method to add a new employee
    public static void addemployee(String name, String phone, String gender, int salary, String role) {
        idgen++; // Increment ID for new employee
        employee emp = new employee(idgen, name, phone, gender, salary, role);
        employees.put(idgen, emp);
        System.out.println("Employee added successfully with ID: " + idgen);
    }

    // Method to delete employee using ID
    public static void deleteemployee(int id) {
        if (employees.containsKey(id)) {
            employees.remove(id);
            System.out.println("Employee removed successfully.");
        } else {
            System.out.println("Employee not found. Enter a valid ID.");
        }
    }

    // Method to update employee's editable info
    public static void updateemployee(int id) {
        employee emp = employees.get(id);
        if (emp != null) {
            emp.editinfo(); // Call method in employee class
        } else {
            System.out.println("Employee not found. Enter a valid ID.");
        }
    }

    // Method to display details of one employee
    public static void employeedetails(int id) {
        employee emp = employees.get(id);
        if (emp != null) {
            System.out.println(emp.toString());
        } else {
            System.out.println("Employee not found. Enter a valid ID.");
        }
    }

    // Method to display all employee records
    public static void retriveall() {
        if (employees.isEmpty()) {
            System.out.println("No employees to display.");
            return;
        }
        for (employee emp : employees.values()) {
            System.out.println(emp.toString());
        }
    }

    // Method to remove all employee records
    public static void removeall() {
        employees.clear(); // Efficient and safe
        System.out.println("All employee records cleared.");
    }

    // Main method with menu-driven interaction
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        new Main(); // Initialize static fields via constructor

        while (true) {
            // Menu display
            System.out.println("\n======= Employee Management System =======");
            System.out.println("1. Add New Employee");
            System.out.println("2. Delete Employee");
            System.out.println("3. Update Employee Info");
            System.out.println("4. View Employee Details by ID");
            System.out.println("5. View All Employees");
            System.out.println("6. Remove All Employees");
            System.out.println("7. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Clear newline

            switch (choice) {
                case 1:
                    // Input employee details
                    System.out.print("Enter Name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter Phone Number: ");
                    String phone = scanner.nextLine();
                    System.out.print("Enter Gender: ");
                    String gender = scanner.nextLine();
                    System.out.print("Enter Salary: ");
                    int salary = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Enter Role: ");
                    String role = scanner.nextLine();

                    addemployee(name, phone, gender, salary, role);
                    break;

                case 2:
                    System.out.print("Enter Employee ID to Delete: ");
                    int deleteId = scanner.nextInt();
                    deleteemployee(deleteId);
                    break;

                case 3:
                    System.out.print("Enter Employee ID to Update: ");
                    int updateId = scanner.nextInt();
                    updateemployee(updateId);
                    break;

                case 4:
                    System.out.print("Enter Employee ID to View: ");
                    int viewId = scanner.nextInt();
                    employeedetails(viewId);
                    break;

                case 5:
                    retriveall();
                    break;

                case 6:
                    System.out.print("Are you sure you want to remove all employees? (yes/no): ");
                    String confirm = scanner.next();
                    if (confirm.equalsIgnoreCase("yes")) {
                        removeall();
                    } else {
                        System.out.println("Operation cancelled.");
                    }
                    break;

                case 7:
                    System.out.println("Exiting the system. Goodbye!");
                    scanner.close();
                    System.exit(0);
                    break;

                default:
                    System.out.println("Invalid choice. Please select from the menu.");
                    break;
            }
        }
    }
}
