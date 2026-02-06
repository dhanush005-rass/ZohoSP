package problem;
import java.util.*;

class vovrev {

    public static void reverse_vowels(String str) {
        Set<Character> vowels = new HashSet<>(
            Arrays.asList('a','e','i','o','u','A','E','I','O','U')
        );

        char[] chars = str.toCharArray();
        int left = 0, right = chars.length - 1;

        while (left < right) {
            // Move left pointer until it points to a vowel
            while (left < right && !vowels.contains(chars[left])) {
                left++;
            }
            // Move right pointer until it points to a vowel
            while (left < right && !vowels.contains(chars[right])) {
                right--;
            }

            // Swap vowels
            char temp = chars[left];
            chars[left] = chars[right];
            chars[right] = temp;

            left++;
            right--;
        }

        System.out.println("Reversed vowels: " + new String(chars));
    }

    public static void main(String[] args) {
        reverse_vowels("hello");      // Output: holle
        reverse_vowels("leetcode");   // Output: leotcede
        reverse_vowels("AEIOU");      // Output: UOIEA
    }
}
