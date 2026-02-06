package mailman;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Mainmanaghement manager = new Mainmanaghement();
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\n=== Mail Management System ===");
            System.out.println("1. Add Mail");
            System.out.println("2. Remove Mail");
            System.out.println("3. Add Tag");
            System.out.println("4. Show Stats");
            System.out.println("5. Search Mail");
            System.out.println("6. Exit");
            System.out.print("Choose an option: ");
            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter Sender: ");
                    String sender = sc.nextLine();
                    System.out.print("Enter Receiver: ");
                    String receiver = sc.nextLine();
                    System.out.print("Enter Subject: ");
                    String subject = sc.nextLine();
                    System.out.print("Enter Content: ");
                    String content = sc.nextLine();
                    manager.addmail(sender, receiver, subject, content);
                    break;

                case 2:
                    System.out.print("Enter Sender to Remove: ");
                    String senderToRemove = sc.nextLine();
                    manager.removemail(senderToRemove);
                    break;

                case 3:
                    System.out.print("Enter Sender to Add Tag: ");
                    String senderForTag = sc.nextLine();
                    System.out.print("Enter Tag: ");
                    String tag = sc.nextLine();
                    manager.addtag(senderForTag, tag);
                    break;

                case 4:
                    manager.stats();
                    break;

                case 5:
                    System.out.print("Enter Search Query: ");
                    String query = sc.nextLine();
                    manager.search(query);
                    break;

                case 6:
                    System.out.println("Exiting... Goodbye!");
                    sc.close();
                    return;

                default:
                    System.out.println("Invalid Option! Try again.");
            }
        }
    }
}
