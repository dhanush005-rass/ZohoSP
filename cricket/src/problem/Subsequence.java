package problem;

class Subsequence {
    public static boolean sub(String s1, String s2) {
        int i = 0, j = 0;
        while (i < s1.length() && j < s2.length()) {
            if (s1.charAt(i) == s2.charAt(j)) {
                j++; // match found, move s2 pointer
            }
            i++; // always move s1 pointer
        }
        return j == s2.length(); // all of s2 matched
    }

    public static void main(String[] args) {
        String s1 = "AXY";
        String s2 = "ADXCPY";
        String s3 = "sque";

        System.out.println(s2 + " is subsequence: " + sub(s2,s1)); // true
        System.out.println(s3 + " is subsequence: " + sub(s1, s3)); // false
    }
}
