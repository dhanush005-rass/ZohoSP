package problem;

import java.util.*;

class Valideparanthesis {

    public static boolean isvalidparan(String str) {
        // Stack to store opening brackets
        Stack<Character> paran = new Stack<>();

        for (int i = 0; i < str.length(); i++) {
            char current = str.charAt(i);

            // If current char is an opening bracket, push it to stack
            if (current == '(' || current == '[' || current == '{') {
                paran.push(current);
            }
            // If current char is a closing bracket
            else if (current == ')' || current == ']' || current == '}') {
                // If stack is empty, there's no matching opening bracket
                if (paran.isEmpty()) {
                    return false;
                }

                // Peek the top element of the stack
                char top = paran.peek();

                // Check for matching pair
                if ((current == ')' && top == '(') ||
                    (current == ']' && top == '[') ||
                    (current == '}' && top == '{')) {
                    paran.pop(); // Matching pair found, remove from stack
                } else {
                    return false; // Mismatch found
                }
            }
            // Ignore any non-bracket characters if needed (optional)
        }

        // If stack is empty, all brackets were matched
        return paran.isEmpty();
    }

    public static void main(String[] args) {
        // Test cases
        System.out.println(isvalidparan("()[]{}"));      // true
        System.out.println(isvalidparan("([{}])"));      // true
        System.out.println(isvalidparan("({[)]}"));      // false
        System.out.println(isvalidparan("((())"));       // false
        System.out.println(isvalidparan("{[(])}"));      // false
    }
}
