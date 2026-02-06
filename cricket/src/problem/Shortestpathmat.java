package problem;
import java.util.*;

class Shortestpathmat {

    // Scanner object for input
    static Scanner s = new Scanner(System.in);

    // A simple class to represent a cell in the matrix with coordinates and distance
    static class Cell {
        int x, y, dist;
        Cell(int x, int y, int dist) {
            this.x = x;      // Row index
            this.y = y;      // Column index
            this.dist = dist; // Distance from source cell
        }
    }

    public static void main(String[] args) {
        // Read matrix dimensions
        int n = s.nextInt(); // number of rows
        int m = s.nextInt(); // number of columns

        // Create a character matrix
        char[][] mat = new char[n][m];

        // Read the matrix elements one by one
        // Each element is a character: '0', '*', 's', or 'd'
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                mat[i][j] = s.next().charAt(0);
            }
        }

        // Find the shortest path and print the result
        int result = shortestPath(mat, n, m);
        System.out.println(result);
    }

    /**
     * Finds the shortest path from 's' (source) to 'd' (destination) in the matrix.
     * Allowed moves: up, down, left, right.
     * Can only move through cells marked with '*', 's', or 'd'.
     * Cannot pass through '0'.
     */
    public static int shortestPath(char[][] mat, int n, int m) {

        // Direction vectors for moving up, down, left, and right
        int[] dx = {-1, 1, 0, 0};  // Row changes
        int[] dy = {0, 0, -1, 1};  // Column changes

        // Keep track of visited cells to avoid revisiting
        boolean[][] visited = new boolean[n][m];

        // Queue for BFS traversal
        Queue<Cell> visq = new LinkedList<>();

        // Locate the source cell 's'
        int sx = -1, sy = -1;
        boolean found = false;
        for (int i = 0; i < n && !found; i++) {
            for (int j = 0; j < m; j++) {
                if (mat[i][j] == 's' || mat[i][j] == 'S') {
                    sx = i;
                    sy = j;
                    found = true;
                    break; // Stop searching once source is found
                }
            }
        }

        // If source doesn't exist, return -1
        if (sx == -1) return -1;

        // Mark the source as visited and add it to the queue
        visited[sx][sy] = true;
        visq.add(new Cell(sx, sy, 0)); // Distance of source from itself is 0

        // BFS traversal
        while (!visq.isEmpty()) {
            // Get the next cell from the queue
            Cell current = visq.poll();

            // If we reached the destination, return the distance
            if (mat[current.x][current.y] == 'd' || mat[current.x][current.y] == 'D') {
                return current.dist;
            }

            // Explore all 4 neighbors (up, down, left, right)
            for (int k = 0; k < 4; k++) {
                int ni = current.x + dx[k]; // new row
                int nj = current.y + dy[k]; // new column

                // Check if the new cell is within bounds, not blocked, and not visited
                if (ni >= 0 && ni < n && nj >= 0 && nj < m &&
                    mat[ni][nj] != '0' && !visited[ni][nj]) {

                    // Mark the cell as visited
                    visited[ni][nj] = true;

                    // Add the new cell to the queue with an incremented distance
                    visq.add(new Cell(ni, nj, current.dist + 1));
                }
            }
        }

        // If BFS completes without finding 'd', no path exists
        return -1;
    }
}
