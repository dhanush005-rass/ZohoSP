package problem;

class Zigzagtraversal {
    public static void zigzag(int[][] mat) {
        int rows = mat.length;
        int cols = mat[0].length;

        // Loop through all diagonals
        for (int d = 0; d < rows + cols - 1; d++) {
            if (d % 2 == 0) {
                // Even diagonal: go upwards
                int r = Math.min(d, rows - 1);
                int c = d - r;
                while (r >= 0 && c < cols) {
                    System.out.print(mat[r][c] + " ");
                    r--;
                    c++;
                }
            } else {
                // Odd diagonal: go downwards
                int c = Math.min(d, cols - 1);
                int r = d - c;
                while (c >= 0 && r < rows) {
                    System.out.print(mat[r][c] + " ");
                    r++;
                    c--;
                }
            }
        }
    }

    public static void main(String[] args) {
        int[][] mat = {
            {1, 2, 3},
            {4, 5, 6},
            {7, 8, 9}
        };

        zigzag(mat);
    }
}
