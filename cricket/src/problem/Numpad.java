package problem;
public class Numpad {

    public static String[] numpd = {
        " ", "", "abc", "def", "ghi",
        "jkl", "mno", "pqrs", "tuv", "wxyz"
    };

    public static String numpd(String str) {
        StringBuilder sb = new StringBuilder();
        String[] num = str.split("-");

        for (String s : num) {
            if (s.equals("#")) continue;   // skip #

            int digit = s.charAt(0) - '0'; // correct digit
            int press = s.length() - 1;    // number of presses

            sb.append(numpd[digit].charAt(press));
        }
        return sb.toString();
    }

    public static void main(String[] args) {
    	System.out.println(numpd("#-9999-666-44-666-#"));
        System.out.println(numpd("#-5-2-888-2-0-222-666-3-33-#")); 
    }
}
