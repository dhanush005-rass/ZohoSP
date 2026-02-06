package problem;

class Strissuboot {

    // 1️⃣ Manual substring check
    public static boolean manualCheck(String str1, String str2) {
        if (str1 == null || str2 == null) {
            return false;
        }

        str1 = str1.toLowerCase();
        str2 = str2.toLowerCase();

        int n = str1.length();
        int m = str2.length();

        if (m > n) {
            return false; // str2 can't be inside str1
        }

        for (int i = 0; i <= n - m; i++) {
            int j;
            for (j = 0; j < m; j++) {
                if (str1.charAt(i + j) != str2.charAt(j)) {
                    break;
                }
            }
            if (j == m) {
                return true; // full match found
            }
        }
        return false;
    }

    // 2️⃣ Using built-in contains()
    public static boolean builtinCheck(String str1, String str2) {
        if (str1 == null || str2 == null) return false;
        return str1.toLowerCase().contains(str2.toLowerCase());
    }

    // Main function
    public static void main(String[] args) {
        String str1 = "Hello World";
        String str2 = "WORLD";

        // Test both functions
        System.out.println("Manual check: " + manualCheck(str1, str2));
        System.out.println("Built-in check: " + builtinCheck(str1, str2));
    }
}
