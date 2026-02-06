package problem;

class InversPuzzle {

    // Function to count inversions in the array
    public static int findInv(int[] arr) {
        int inv = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 0) continue; // skip the blank space
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] != 0 && arr[i] > arr[j]) {
                    inv++;
                }
            }
        }
        return inv;
    }

    // Function to check if puzzle is solvable
    public static boolean solvable(int[][] mat) {
        int n = mat.length; // size of puzzle (e.g., 4 for 4x4)

        // Flatten the matrix into a 1D array
        int[] arr = new int[n * n];
        int idx = 0;
        int blankRow = -1; // row of blank from bottom

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                arr[idx++] = mat[i][j];
                if (mat[i][j] == 0) {
                    blankRow = n - i; // row counting from bottom
                }
            }
        }

        int inv = findInv(arr);

        if (n % 2 == 1) {
            // If grid width is odd, then number of inversions must be even
            return (inv % 2 == 0);
        } else {
            // If grid width is even:
            // blankRow is counted from bottom
            if ((blankRow % 2 == 0) && (inv % 2 == 1)) return true;
            if ((blankRow % 2 == 1) && (inv % 2 == 0)) return true;
            return false;
        }
    }

    // For quick testing
    public static void main(String[] args) {
        int[][] puzzle = {
            {2, 1, 3, 4},
            {5, 6, 7, 8},
            {9, 10, 11, 12},
            {13, 14, 15, 0} // 0 represents the blank space
        };

        System.out.println(solvable(puzzle) ? "Solvable" : "Not Solvable");
    }
}
