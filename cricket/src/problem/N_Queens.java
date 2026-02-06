package problem;
import java.util.*;  // Import utility classes like Arrays

class N_Queens {

    // Function to check if placing a queen at (row, col) is safe
    public static boolean isSafe(int[] board, int row, int col) {
        // Loop through all previous rows (0 to row-1)
        for (int i = 0; i < row; i++) {
            // Condition 1: If another queen is already in the same column
            if (board[i] == col) {
                return false;
            }
            // Condition 2: If another queen is on the same diagonal
            // Diagonal condition: difference between columns == difference between rows
            if (Math.abs(board[i] - col) == Math.abs(i - row)) {
                return false;
            }
        }
        // If no conflicts found, it is safe
        return true;
    }

    // Recursive function to place queens row by row
    public static boolean placeQueens(int[] board, int row, int n) {
        // Base case: if all queens are placed (row == n), solution found
        if (row == n) {
            return true;
        }

        // Try placing a queen in each column of this row
        // Columns are numbered from 1 to n
        for (int col = 1; col <= n; col++) {
            // Check if placing a queen at (row, col) is safe
            if (isSafe(board, row, col)) {
                // Place queen: record column position in board[row]
                board[row] = col;

                // Recurse to place queen in the next row
                if (placeQueens(board, row + 1, n)) {
                    return true;  // If solution found, return true
                }

                // Backtrack: remove queen (reset to 0) and try next column
                board[row] = 0;
            }
        }

        // If no column works in this row, return false (backtrack to previous row)
        return false;
    }

    // Function to solve N-Queens problem
    public static int[] solveNQueens(int n) {
        // board[i] stores the column position (1..n) of queen in row i
        int[] board = new int[n];

        // Start placing queens from row 0
        placeQueens(board, 0, n);

        // Return the board configuration
        return board;
    }

    // Main method: entry point of the program
    public static void main(String[] args) {
        int n = 4;  // Example: size of chessboard (4x4)

        // Solve the N-Queens problem
        int[] result = solveNQueens(n);

        // Print the result in required format
        System.out.println(Arrays.toString(result));
    }
}
/*package problem;
import java.util.*;

class N_Queens {

    public static boolean isSafe(boolean[][] placed, int row, int col, int n) {
        // check column
        for (int i = 0; i < row; i++) {
            if (placed[i][col]) return false;
        }
        // check upper left diagonal
        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
            if (placed[i][j]) return false;
        }
        // check upper right diagonal
        for (int i = row - 1, j = col + 1; i >= 0 && j < n; i--, j++) {
            if (placed[i][j]) return false;
        }
        return true;
    }

    public static boolean placeQueens(boolean[][] placed, int row, int n, List<int[]> positions) {
        if (row == n) {
            return true; // all queens placed
        }

        for (int col = 0; col < n; col++) {
            if (isSafe(placed, row, col, n)) {
                placed[row][col] = true;
                positions.add(new int[]{row, col});

                if (placeQueens(placed, row + 1, n, positions)) {
                    return true;
                }

                // backtrack
                placed[row][col] = false;
                positions.remove(positions.size() - 1);
            }
        }
        return false;
    }

    public static int[][] solveNQueens(int n) {
        boolean[][] placed = new boolean[n][n];
        List<int[]> positions = new ArrayList<>();

        placeQueens(placed, 0, n, positions);

        int[][] chessboard = new int[n][n];
        for (int[] pos : positions) {
            chessboard[pos[0]][pos[1]] = 1; // mark queen
        }

        return chessboard;
    }

    public static void main(String[] args) {
        int n = 4; // Example
        int[][] result = solveNQueens(n);

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(result[i][j] + " ");
            }
            System.out.println();
        }
    }
}
*/