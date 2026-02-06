package moveball;
import java.util.*;

class Main {
    private static Scanner sc = new Scanner(System.in);
    static Ball ball = new Ball();

    public static void main(String[] args) {
        int row, col, balpos, tx, ty, bx, by;

        System.out.println("Enter The Grid size [rows cols]: ");
        row = sc.nextInt();
        col = sc.nextInt();
        System.out.println("Enter The initial column of the ball: ");
        balpos = sc.nextInt();

        ball.initialize(row, col, balpos);

        boolean flag = true;
        int choice;
        while (flag) {
            System.out.println("\n2. Release ball");
            System.out.println("3. Add obstacle");
            System.out.println("7. Print grid");
            System.out.println("0. Terminate");
            System.out.print("Enter The Operation to Perform: ");
            choice = sc.nextInt();
            ball.ballpos();

            switch (choice) {
                case 0:
                    flag = false;
                    break;
                case 3:
                    System.out.println("Enter The Block Dimensions [top-left x top-left y bottom-right x bottom-right y]: ");
                    tx = sc.nextInt();
                    ty = sc.nextInt();
                    bx = sc.nextInt();
                    by = sc.nextInt();
                    ball.addobstacle(tx, ty, bx, by);
                    break;
                case 2:
                    System.out.print("Enter The Release Direction [1-top left, 2-top, 3-top right]: ");
                    int choice1 = sc.nextInt();
                    switch (choice1) {
                        case 1:
                            ball.releasetopleft();
                            System.out.println("Completed");
                            break;
                        case 2:
                            ball.releaseballtop();
                            System.out.println("Completed");
                            break;
                        case 3:
                            ball.releaseballtopright();
                            System.out.println("Completed");
                            break;
                        default:
                            System.out.println("Invalid input!");
                            break;
                    }
                    break;
                case 7:
                    ball.printgrid();
                    break;
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
    }
}
