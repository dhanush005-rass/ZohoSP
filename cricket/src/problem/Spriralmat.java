package problem;

class Spiralmat {
    public static void spitra(int[][] mat) {
        int rowstart = 0, colstart = 0;
        int rowend = mat.length - 1, colend = mat[0].length - 1;

        while (rowstart <= rowend && colstart <= colend) {

            // Top row
            for (int i = colstart; i <= colend; i++) {
                System.out.print(mat[rowstart][i] + " ");
            }
            rowstart++;

            // Right column
            for (int i = rowstart; i <= rowend; i++) {
                System.out.print(mat[i][colend] + " ");
            }
            colend--;

            // Bottom row
            if (rowstart <= rowend) {
                for (int i = colend; i >= colstart; i--) {
                    System.out.print(mat[rowend][i] + " ");
                }
                rowend--;
            }

            // Left column
            if (colstart <= colend) {
                for (int i = rowend; i >= rowstart; i--) {
                    System.out.print(mat[i][colstart] + " ");
                }
                colstart++;
            }
        }
    }
    public static void zigzagDiagonal(int[][] mat) {
        int rows = mat.length;
        int cols = mat[0].length;

        for (int sum = 0; sum <= rows + cols - 2; sum++) {
            if (sum % 2 == 0) {
                // Traverse upwards
                int r = Math.min(sum, rows - 1);
                int c = sum - r;
                while (r >= 0 && c < cols) {
                    System.out.print(mat[r][c] + " ");
                    r--;
                    c++;
                }
            } else {
                // Traverse downwards
                int c = Math.min(sum, cols - 1);
                int r = sum - c;
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
            {1, 2, 3, 4},
            {5, 6, 7, 8},
            {9, 10, 11, 12},
            {13, 14, 15, 16}
        };
        spitra(mat);
        System.out.println();
        zigzagDiagonal(mat);
    }
}
