package problem;

import java.util.*;

class Rev_spc_it {

    // List of special characters to be skipped
    private static final Set<Character> spec = new HashSet<>(Arrays.asList(
        '!', '@', '#', '$', '%', '&', '*', '^', '?', ':', ';', ','
    ));

    // Function to reverse the string without moving special characters
    public static String reverse_wo_sc(String str) {
        int lef = 0;
        int rig = str.length() - 1;

        char[] st = str.toCharArray();  // Convert to character array for easy swapping

        while (lef < rig) {
            // If left is special character, move forward
            if (spec.contains(st[lef])) {
                lef++;
            }
            // If right is special character, move backward
            else if (spec.contains(st[rig])) {
                rig--;
            }
            // Both are normal characters — swap them
            else {
                char temp = st[lef];
                st[lef] = st[rig];
                st[rig] = temp;
                lef++;
                rig--;
            }
        }

        return new String(st);  // Convert char array back to String
    }

    // Main method to test
    public static void main(String[] args) {
        String input = "a,b$c";
        String result = reverse_wo_sc(input);
        System.out.println(result);  // Output should be: c,b$a
    }
}
