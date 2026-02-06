package place;

class New {

    public static void longstr(String str) {
        int maxLen = 0;
        int currLen = 0;
        int maxStart = 0;
        int currStart = 0;

        for (int i = 0; ; i++) {
            char ch = (i < str.length()) ? str.charAt(i) : ' '; // Sentinel at end

            if (ch != ' ') {
                if (currLen == 0) {
                    currStart = i;
                }
                currLen++;
            } else {
                if (currLen > maxLen) {
                    maxLen = currLen;
                    maxStart = currStart;
                }
                currLen = 0; // Reset for next word
            }

            if (i >= str.length()) break;
        }

        // Print longest word
        for (int i = maxStart; i < maxStart + maxLen; i++) {
            System.out.print(str.charAt(i));
        }
    }

    public static void main(String[] args) {
        longstr("i came by car");
    }
}
