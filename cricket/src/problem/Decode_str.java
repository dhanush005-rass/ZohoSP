package problem;
import java.util.*;

class Decode_str {

    public static String decode(String str) {
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);

            if (ch == ']') {
                String sub = "";
                String k = "";

                // Pop characters to form the substring until '[' is found
                while (!stack.isEmpty() && stack.peek() != '[') {
                    sub = stack.pop() + sub;
                }

                // Pop the '['
                if (!stack.isEmpty() && stack.peek() == '[') {
                    stack.pop();
                }

                // Now get the digits (number) before '['
                while (!stack.isEmpty() && Character.isDigit(stack.peek())) {
                    k = stack.pop() + k;
                }

                // Repeat the substring
                String repeated = sub.repeat(Integer.parseInt(k));

                // Push the repeated characters back to the stack
                for (int j = 0; j < repeated.length(); j++) {
                    stack.push(repeated.charAt(j));
                }
            } else {
                stack.push(ch);
            }
        }

        // Final result
        StringBuilder res = new StringBuilder();
        while (!stack.isEmpty()) {
            res.append(stack.pop());
        }

        return res.reverse().toString();
    }

    public static void main(String[] args) {
        String input = "3[a2[c]]";
        String output = decode(input);
        System.out.println(output);  // accaccacc
    }
}
