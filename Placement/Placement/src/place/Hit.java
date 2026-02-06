package place;


class Hit {
    public static String hit(String code, String attempt) {
        if (code.length() != attempt.length()) {
            return "";
        }

        int h = 0, n = 0;
        int[] codeCount = new int[10];
        int[] attemptCount = new int[10];

        
        for (int i = 0; i < code.length(); i++) {
            if (code.charAt(i) == attempt.charAt(i)) {
                h++;
            } else {
                codeCount[code.charAt(i) - '0']++;
                attemptCount[attempt.charAt(i) - '0']++;
            }
        }

        
        for (int i = 0; i < 10; i++) {
            n += Math.min(codeCount[i], attemptCount[i]);
        }

        return h + "H" + n + "N";
    }

    public static void main(String[] args) {
        System.out.println(hit("1807", "7810")); 
        System.out.println(hit("11203", "01111")); 
    }
}
