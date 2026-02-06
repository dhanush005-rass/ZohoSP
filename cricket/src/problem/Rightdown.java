package problem;

class Rightdown {

    public static boolean downrig(int[][] mat) {
        int rows = mat.length;
        int cols = mat[0].length;
        boolean[][] visited = new boolean[rows][cols];

        return dfs(mat, 0, 0, visited);
    }

    private static boolean dfs(int[][] mat, int i, int j, boolean[][] visited) {
        int rows = mat.length;
        int cols = mat[0].length;

        // Out of bounds or blocked cell
        if (i < 0 || j < 0 || i >= rows || j >= cols || mat[i][j] == 0 || visited[i][j]) {
            return false;
        }

        // Reached bottom-right
        if (i == rows - 1 && j == cols - 1) {
            return true;
        }

        visited[i][j] = true;

        // Move right or down
        return dfs(mat, i, j + 1, visited) || dfs(mat, i + 1, j, visited);
    }

    public static void main(String[] args) {
        int[][] mat = {
            {1, 1, 0},
            {1, 1, 1},
            {0, 1, 1}
        };

        System.out.println(downrig(mat)); // true
    }
}
