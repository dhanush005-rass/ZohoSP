package problem;

class PassPermutation {

    public static int passwd(String s, String ans) {
        if (s.length() == 0) {
        	System.out.println(ans);
            if (Character.isDigit(ans.charAt(0))) {
                return 1; // valid permutation
            }
            return 0;
        }

        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            String remaining = s.substring(0, i) + s.substring(i + 1);
            count += passwd(remaining, ans + s.charAt(i));
        }
        return count;
    }

    public static void main(String[] args) {
        String password = "shopup";
        int result = passwd(password, "");
        System.out.println("Number of permutations starting with a digit: " + result);
    }
}
