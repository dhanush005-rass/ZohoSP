package student;
import java.util.*;

class Main {

    // Used to generate unique student IDs
    static int idgen = 0;

    // Stores all students mapped by their ID
    static Map<Integer, student> students = new HashMap<>();

    // For user input
    static Scanner scanner = new Scanner(System.in);

    // Adds a new student
    public void addstudent(String name, int mat, int sci, int eng) {
        idgen++;
        student student = new student(idgen, name, mat, sci, eng);
        students.put(idgen, student);
        System.out.println("Student Added Successfully. Student ID: " + idgen);
    }

    // Removes a student by ID
    public void removestudent() {
        System.out.print("Enter Student ID: ");
        int id = scanner.nextInt();
        if (students.containsKey(id)) {
            students.remove(id);
            System.out.println("Student Removed Successfully.");
        } else {
            System.out.println("Student Not Found. Enter a Valid ID.");
        }
    }

    // Displays all student details
    public static void displaystudents() {
        if (students.isEmpty()) {
            System.out.println("No Students Found.");
            return;
        }

        for (student student : students.values()) {
            System.out.println(student.toString());
            System.out.println("__________________________________________________________________________________________");
        }
    }

    // Displays a specific student's details
    public static void displaystudent() {
        System.out.print("Enter Student ID: ");
        int id = scanner.nextInt();
        if (students.containsKey(id)) {
            student student = students.get(id);
            System.out.println(student.toString());
        } else {
            System.out.println("Student Not Found. Enter a Valid ID.");
        }
    }

    // Displays a specific student's average marks
    public static void displaystudentavg() {
        System.out.print("Enter Student ID: ");
        int id = scanner.nextInt();
        if (students.containsKey(id)) {
            student student = students.get(id);
            System.out.println("The Average Mark of the Student is: " + student.returnavg());
        } else {
            System.out.println("Student Not Found. Enter a Valid ID.");
        }
    }

    // Displays the class average
    public static void displayclassavg() {
        if (students.isEmpty()) {
            System.out.println("No Students to Calculate Class Average.");
            return;
        }

        float totalAvg = 0;
        for (student student : students.values()) {
            totalAvg += student.returnavg();
        }

        float classAvg = totalAvg / students.size();
        System.out.println("The Average of the Class is: " + classAvg);
    }

    // Main menu
    public static void main(String[] args) {
        Main mainApp = new Main(); // Create object to call non-static methods

        while (true) {
            System.out.println("\n========== STUDENT MANAGEMENT SYSTEM ==========");
            System.out.println("1. Add Student");
            System.out.println("2. Remove Student");
            System.out.println("3. Display All Students");
            System.out.println("4. Display Specific Student");
            System.out.println("5. Display Student Average");
            System.out.println("6. Display Class Average");
            System.out.println("7. Exit");
            System.out.print("Enter Your Choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter Student Name: ");
                    String name = scanner.next();
                    System.out.print("Enter Maths Marks: ");
                    int math = scanner.nextInt();
                    System.out.print("Enter Science Marks: ");
                    int sci = scanner.nextInt();
                    System.out.print("Enter English Marks: ");
                    int eng = scanner.nextInt();
                    mainApp.addstudent(name, math, sci, eng);
                    break;

                case 2:
                    mainApp.removestudent();
                    break;

                case 3:
                    displaystudents();
                    break;

                case 4:
                    displaystudent();
                    break;

                case 5:
                    displaystudentavg();
                    break;

                case 6:
                    displayclassavg();
                    break;

                case 7:
                    System.out.println("Exiting Program. Goodbye!");
                    return;

                default:
                    System.out.println("Invalid Choice. Please Try Again.");
            }
        }
    }
}
