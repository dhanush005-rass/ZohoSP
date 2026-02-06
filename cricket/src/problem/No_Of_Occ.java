package problem;
import java.util.*;

class No_Of_Occ {
    public static void nooc(int[] arr) {
        Map<Integer, Integer> freq = new HashMap<>();

        // Count frequencies
        for (int num : arr) {
            freq.put(num, freq.getOrDefault(num, 0) + 1);
        }

        // Print results
        for (Map.Entry<Integer, Integer> entry : freq.entrySet()) {
            System.out.println("The Number: " + entry.getKey() + " occurs " + entry.getValue() + " times");
        }
    }

    // Optional main method to test
    public static void main(String[] args) {
        int[] arr = {2, 3, 2, 4, 3, 5, 2};
        nooc(arr);
    }
}
