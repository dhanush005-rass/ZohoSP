package problem;
//Write a program to check if the given words are present in matrix given below.
//Search a string in a given 2D matrix.
public class Eight_dir_Wrd_ser {

    // Recursive function to check if the word exists starting from (x, y)
    // wrind: current index in the word we're trying to match
    public static boolean isFound(char[][] mat, String word, int x, int y, int wrind) {
        int rows = mat.length;          // Total rows in the matrix
        int cols = mat[0].length;       // Total columns in the matrix

        // ✅ BASE CASE: If we’ve matched the entire word, return true
        if (wrind == word.length()) {
            return true;
        }

        // ✅ BOUNDARY AND MISMATCH CHECKS
        // If (x,y) is out of matrix bounds or character at mat[x][y] doesn't match the word character at wrind
        if (x < 0 || y < 0 || x >= rows || y >= cols || mat[x][y] != word.charAt(wrind)) {
            return false;
        }

        // ✅ MARK CELL AS VISITED
        // Temporarily store the current character
        char temp = mat[x][y];
        // Mark it visited (so we don't reuse it in the same path)
        mat[x][y] = '#';

        // ✅ DEFINE 8 DIRECTIONS TO SEARCH
        // These arrays represent the change in x and y to move in each of the 8 directions
        int[] dx = {-1, -1, -1, 0, 0, 1, 1, 1}; // Row directions (up, up-left, up-right, etc.)
        int[] dy = {-1,  0,  1, -1, 1, -1, 0, 1}; // Col directions

        // ✅ TRY ALL 8 POSSIBLE DIRECTIONS
        boolean found = false; // Track whether word was found
        for (int i = 0; i < dx.length; i++) {
            // Move in direction (dx[i], dy[i]) and try to match the next character
            if (isFound(mat, word, x + dx[i], y + dy[i], wrind + 1)) {
                found = true;
                break; // Stop searching other directions if found
            }
        }

        // ✅ BACKTRACK: Restore the original character before returning
        mat[x][y] = temp;

        // Return whether we found the word in any direction from this cell
        return found;
    }

    // Starter function that searches for the word starting from any cell in the matrix
    public static boolean isWordPresent(char[][] mat, String word) {
        // Loop through every cell in the matrix
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[i].length; j++) {
                // Optimization: Only start DFS if first character matches
                if (mat[i][j] == word.charAt(0)) {
                    // Start recursive search from cell (i, j)
                    if (isFound(mat, word, i, j, 0)) {
                        return true; // Word found
                    }
                }
            }
        }
        return false; // Word not found in any path
    }

    // Main method to test the logic
    public static void main(String[] args) {
        // Define the character matrix (grid)
        char[][] mat = {
            {'a', 'x', 'm', 'y'},
            {'b', 'g', 'd', 'f'},
            {'x', 'e', 'e', 't'},
            {'r', 'a', 'k', 's'}
        };

        // Words to search in the matrix
        String[] words = {"geeks", "seed", "seek", "mask", "axe", "gfd"};

        // Check each word and print whether it is present
        for (String word : words) {
            if (isWordPresent(mat, word)) {
                System.out.println(word + " is present in the matrix.");
            } else {
                System.out.println(word + " is NOT present in the matrix.");
            }
        }
    }
}
