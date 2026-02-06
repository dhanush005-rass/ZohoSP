package problem;

class Pangram {

    public static boolean pan(String str) {
        str = str.toUpperCase(); // handle lowercase letters

        for (char ch = 'A'; ch <= 'Z'; ch++) {
            boolean found = false;
            for (int i = 0; i < str.length(); i++) {
                if (ch == str.charAt(i)) {
                    found = true;
                    break; // found this character, no need to continue inner loop
                }
            }
            if (!found) {
                return false; // missing at least one letter
            }
        }
        return true; // all letters found
    }

    public static void main(String[] args) {
        String s1 = "THE QUICK BROWN FOX JUMPS OVER THE LAZY DOG";
        String s2 = "HELLO WORLD";

        System.out.println(pan(s1)); // true
        System.out.println(pan(s2)); // false
    }
}
