/*package moveball;
import java.util.*;

class Main {
    private static Scanner sc = new Scanner(System.in);
    static Ball ball = new Ball();

    public static void main(String[] args) {
        int row, col, balpos,tx,ty,bx,by;

        System.out.println("Enter The Grid size [r,c]: ");
        row = sc.nextInt();
        col = sc.nextInt();
        System.out.println("Enter The initial position of the ball : ");
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
            ball.printgrid();

            switch (choice) {
                case 0:
                    flag = false;
                    break;
                case 3:
                	System.out.println("Enter The Block Dimensions [top left x,top right y,Bottom right x, Bottom right y ] :");
                	tx=sc.nextInt();
                	ty=sc.nextInt();
                	bx=sc.nextInt();
                	by=sc.nextInt();
                	ball.addobstacle(tx,ty,bx,by);
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
                            System.out.println("Invalide input!");
                            break;
                    }
                    break;
                case 7:
                    ball.ballpos();
                    ball.printgrid();
                    break;
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
    }
}

package moveball;

class Ball {
    private int[][] mat;
    private int ballRow;
    private int ballCol;

    public void initialize(int r, int c, int pos) {
        mat = new int[r][c];
        ballRow = r - 1;
        ballCol = pos;

        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                mat[i][j] = 0;
            }
        }
        if (ballCol >= 0 && ballCol < c) {
            mat[ballRow][ballCol] = 1;
        }
    }

    public void ballpos() {
        System.out.println("Ball Position: [ " + ballRow + "," + ballCol + " ]");
    }
    
    public void addobstacle(int tx,int ty,int bx,int by)
    {
    	for (int i = tx; i <= bx; i++) {
    	    for (int j = ty; j <= by; j++) {
    	        mat[i][j] = 2;
    	    }
    	}
    }
    public void releaseballtopright() {
        mat[ballRow][ballCol] = 0;
        int dr = -1, dc = 1; 
        
        int r = mat.length, c = mat[0].length;
        int row = ballRow, col = ballCol;

        while (true) {
            row += dr;
            col += dc;

            
            if (row < 0) { row = 0; dr = 1; }
            if (row >= r) { row = r - 2; dr = -1; }

            
            if (col < 0) { col = 0; dc = 1; }
            if (col >= c) { col = c - 2; dc = -1; }

           
            if (row == r - 1) break;
        }

        ballRow = row;
        ballCol = col;
        mat[ballRow][ballCol] = 1;
    }

    public void releasetopleft() {
        mat[ballRow][ballCol] = 0;
        int dr = -1, dc = -1; // moving up-left
        int r = mat.length, c = mat[0].length;
        int row = ballRow, col = ballCol;

        while (true) {
            row += dr;
            col += dc;

            
            if (row < 0) { row = 0; dr = 1; }
            if (row >= r) { row = r - 2; dr = -1; }

            
            if (col < 0) { col = 0; dc = 1; }
            if (col >= c) { col = c - 2; dc = -1; }

            
            if (row == r - 1) break;
        }

        ballRow = row;
        ballCol = col;
        mat[ballRow][ballCol] = 1;
    }

    public void releaseballtop() {
        
        mat[ballRow][ballCol] = 0;
        ballRow = mat.length - 1;
        mat[ballRow][ballCol] = 1;
    }

    public void printgrid() {
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[i].length; j++) {
                System.out.print(mat[i][j] + " ");
            }
            System.out.println();
        }
    }
}

*/