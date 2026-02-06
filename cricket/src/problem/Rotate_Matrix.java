package problem;

class Rotate_Matrix {

    public static int[][] rotmat(int[][] mat, int deg) {
        int n = 360 / deg;
        for (int i = 0; i < n; i++) {
            mat = rotate_90(mat); // rotate the matrix multiple times
        }
        return mat;
    }

    public static int[][] rotate_90(int[][] mat) {
        int len = mat.length;
        int[][] ans = new int[len][len];
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {
                ans[j][len - 1 - i] = mat[i][j];  // rotate 90 degrees clockwise
            }
        }
        return ans;
    }

    // Optional: utility function to print matrix
    public static void printMatrix(int[][] mat) {
        for (int[] row : mat) {
            for (int val : row) {
                System.out.print(val + " ");
            }
            System.out.println();
        }
    }

    // Optional: test
    public static void main(String[] args) {
        int[][] mat = {
            {1, 2, 3},
            {4, 5, 6},
            {7, 8, 9}
        };

        int degree = 90; // Try 180, 270 as well
        int[][] rotated = rotmat(mat, degree);
        printMatrix(rotated);
    }
}
