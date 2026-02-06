package problem;
//Given an odd length word which should be printed from the middle of the word.
class PrintFromMiddle {

    public static void printFromMiddle(String str) {
        if (str == null || str.length() % 2 == 0) {
            System.out.println("Input must be a non-null string with odd length.");
            return;
        }

        int len = str.length();
        int mid = len / 2;
        int left = mid - 1;
        int right = mid + 1;

        System.out.print(str.charAt(mid));  // Print middle character first

        while (left >= 0 && right < len) {
            System.out.print(str.charAt(left--));
            System.out.print(str.charAt(right++));
        }

        System.out.println();  // Move to next line after printing
    }

    public static void main(String[] args) {
        printFromMiddle("SKILL");      // Output: IKLS
        printFromMiddle("PYTHON");     // Should print error (even length)
        printFromMiddle("ABCDEFH");    // Output: DCEFAB
    }
}
