package problem;
import java.util.*;

class Mostcommonword {
    public static String msw(String str) {
        str = str.toLowerCase();
        String[] words = str.split("\\s+"); // split by whitespace
        Map<String, Integer> freq = new HashMap<>();

        for (String word : words) {
            freq.put(word, freq.getOrDefault(word, 0) + 1);
        }

        String mostCommon = "";
        int maxCount = 0;

        for (Map.Entry<String, Integer> entry : freq.entrySet()) {
            if (entry.getValue() > maxCount) {
                mostCommon = entry.getKey();
                maxCount = entry.getValue();
            }
        }

        return mostCommon;
    }

    public static void main(String[] args) {
        String text = "apple banana apple orange banana apple";
        System.out.println("Most common word: " + msw(text));
    }
}
