package problem;

class Riglefdictword {
    public static boolean isexist(char[][] charmat, int x, int y, String str, int sind) {
        boolean[][] visited = new boolean[charmat.length][charmat[0].length];
        return search(charmat, x, y, str, sind, visited);
    }

    private static boolean search(char[][] charmat, int x, int y, String str, int sind, boolean[][] visited) {
        // Base case: found the whole word
        if (sind == str.length()) {
            return true;
        }

        // Out of bounds or mismatch or already visited
        if (x < 0 || y < 0 || x >= charmat.length || y >= charmat[0].length
                || charmat[x][y] != str.charAt(sind) || visited[x][y]) {
            return false;
        }

        // Mark visited
        visited[x][y] = true;

        // Only two directions: right and down
        int[] dx = {0, 1};
        int[] dy = {1, 0};

        for (int k = 0; k < dx.length; k++) {
            if (search(charmat, x + dx[k], y + dy[k], str, sind + 1, visited)) {
                return true;
            }
        }

        // Unmark visited for backtracking
        visited[x][y] = false;

        return false;
    }

    public static void main(String[] args) {
        char[][] grid = {
                {'A', 'P', 'P', 'L'},
                {'B', 'A', 'N', 'A'},
                {'C', 'O', 'C', 'O'},
                {'D', 'A', 'T', 'E'}
        };

        String[] dict = {"APPLE", "BANANA", "COCOA", "DATE", "PAN"};

        for (String word : dict) {
            boolean found = false;
            for (int i = 0; i < grid.length; i++) {
                for (int j = 0; j < grid[0].length; j++) {
                    if (search(grid, i, j, word, 0, new boolean[grid.length][grid[0].length])) {
                        System.out.println(word);
                        found = true;
                        break;
                    }
                }
                if (found) break;
            }
        }
    }
}
