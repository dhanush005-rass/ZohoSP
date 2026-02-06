package problem;
import java.util.*;

class Sort_using_peak_ele {

    public static String supv(int[] arr) {
        ArrayList<Integer> result = new ArrayList<>();
        ArrayList<Integer> peak = new ArrayList<>();
        int len = arr.length;

        // Find indices of peak elements (excluding boundaries)
        for (int i = 1; i < len - 1; i++) {
            if (arr[i] > arr[i - 1] && arr[i] > arr[i + 1]) {
                peak.add(i); // store index, not value
            }
        }

        // Always add the last index as boundary
        peak.add(len - 1);

        int start = 0;
        for (int end : peak) {
            int[] part = Arrays.copyOfRange(arr, start, end + 1); // +1 because copyOfRange is exclusive at end
            Arrays.sort(part);
            for (int num : part) {
                result.add(num);
            }
            start = end + 1;
        }

        return result.toString();
    }

    // Main method to test
    public static void main(String[] args) {
        int[] arr = {5, 2, 8, 6, 3, 10, 4, 1};
        System.out.println("Sorted segments: " + supv(arr));
    }
}
