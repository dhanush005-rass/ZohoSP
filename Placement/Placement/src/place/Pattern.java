package place;

class Pattern {

    public static void pattern(int n) {
        int num = 1;

        // Print diagonals starting from bottom row
        for (int i = n - 1; i >= 0; i--) {
            int row = i;
            int col = 0;

            for (int j = 0; j < n - i; j++) {
                int tempRow = row;
                int tempCol = col;
                int steps = j;
                int value = 0;

                // Find the value at this position
                int k = n - 1;
                int current = 1;
                for (int d = 0; d < n; d++) {
                    int r = k;
                    int c = d;
                    for (int m = 0; m <= Math.min(k, n - d - 1); m++) {
                        if (r == tempRow && c == tempCol) {
                            value = current;
                        }
                        r--;
                        c++;
                        current++;
                    }
                }

                System.out.print(value + " ");
                row++;
                col++;
            }

            System.out.println();
        }
    }

    public static void main(String[] args) {
        pattern(5);
    }
}
