package problem;

class Longwdwoa {
    
    public static String longwd(String sent) {
        String sub = "";
        String longstr = "";
        int str = 0;
        
        for (int i = 0; i < sent.length(); i++) {
            if (sent.charAt(i) == ' ') {
                sub = sent.substring(str, i);
                str = i + 1;
                if (sub.length() > longstr.length()) {
                    longstr = sub;
                }
            }
        }
        
        // Check the last word (since loop ends before last word gets compared)
        sub = sent.substring(str);
        if (sub.length() > longstr.length()) {
            longstr = sub;
        }
        
        return longstr;
    }
    
    public static void main(String[] args) {
        String sentence = "I love programming in Java";
        System.out.println("Longest word: " + longwd(sentence));
    }
}
