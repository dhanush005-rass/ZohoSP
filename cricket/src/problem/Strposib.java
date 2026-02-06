package problem;
public class Strposib {

    public static boolean ispos(String str) {
        String[] spt = str.split(" ");
        String fir = spt[0];
        String sec = spt[1];

        int i = 0; // pointer for fir
        int j = 0; // pointer for sec

        while (i < fir.length() && j < sec.length()) {
            if (fir.charAt(i) == sec.charAt(j)) {
                i++; // move in first string only when matched
            }
            j++; // always move in second string
        }

        // if we matched all characters of fir
        return i == fir.length();
    }

    public static void main(String[] args) {
        System.out.println(ispos("jhon jhonna")); // true
        System.out.println(ispos("ira ira"));    // true
        System.out.println(ispos("kayla iayla")); // false
        System.out.println(ispos("joy jyo"));
    }
}
