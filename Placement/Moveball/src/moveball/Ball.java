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

    public void addobstacle(int tx, int ty, int bx, int by) {
        for (int i = tx; i <= bx; i++) {
            for (int j = ty; j <= by; j++) {
                mat[i][j] = 2; // mark obstacle
            }
        }
    }

    private boolean isObstacle(int r, int c) {
        return r >= 0 && r < mat.length && c >= 0 && c < mat[0].length && mat[r][c] == 2;
    }

    public void releaseballtopright() {
        mat[ballRow][ballCol] = 0;
        int dr = -1, dc = 1; // up-right
        int r = mat.length, c = mat[0].length;
        int row = ballRow, col = ballCol;

        while (true) {
            int nextRow = row + dr;
            int nextCol = col + dc;

            // Bounce on walls
            if (nextRow < 0 || nextRow >= r) dr = -dr;
            if (nextCol < 0 || nextCol >= c) dc = -dc;

            nextRow = row + dr;
            nextCol = col + dc;

            // Check for obstacle collision
            if (isObstacle(nextRow, nextCol)) {
                boolean hitVertical = isObstacle(row + dr, col);
                boolean hitHorizontal = isObstacle(row, col + dc);

                if (hitVertical && hitHorizontal) {
                    dr = -dr;
                    dc = -dc;
                } else if (hitVertical) {
                    dr = -dr;
                } else if (hitHorizontal) {
                    dc = -dc;
                } else {
                    dr = -dr;
                    dc = -dc;
                }

                nextRow = row + dr;
                nextCol = col + dc;
            }

            row = nextRow;
            col = nextCol;

            // Stop if reaches bottom row
            if (row == r - 1) break;
        }

        ballRow = row;
        ballCol = col;
        mat[ballRow][ballCol] = 1;
    }

    public void releasetopleft() {
        mat[ballRow][ballCol] = 0;
        int dr = -1, dc = -1; // up-left
        int r = mat.length, c = mat[0].length;
        int row = ballRow, col = ballCol;

        while (true) {
            int nextRow = row + dr;
            int nextCol = col + dc;

            // Bounce on walls
            if (nextRow < 0 || nextRow >= r) dr = -dr;
            if (nextCol < 0 || nextCol >= c) dc = -dc;

            nextRow = row + dr;
            nextCol = col + dc;

            // Corrected obstacle collision check
            if (isObstacle(nextRow, nextCol)) {
                boolean hitVertical = isObstacle(row + dr, col);
                boolean hitHorizontal = isObstacle(row, col + dc);

                if (hitVertical && hitHorizontal) {
                    dr = -dr;
                    dc = -dc;
                } else if (hitVertical) {
                    dr = -dr;
                } else if (hitHorizontal) {
                    dc = -dc;
                } else {
                    dr = -dr;
                    dc = -dc;
                }

                nextRow = row + dr;
                nextCol = col + dc;
            }

            row = nextRow;
            col = nextCol;

            if (row == r - 1) break;
        }

        ballRow = row;
        ballCol = col;
        mat[ballRow][ballCol] = 1;
    }

    public void releaseballtop() {
        mat[ballRow][ballCol] = 0;
        ballRow = mat.length - 1; // drop directly to bottom row
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