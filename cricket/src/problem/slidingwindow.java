package problem;
import java.util.*;
//Given an array of numbers and a window of size k. Print the maximum of numbers 
//inside the window for each step as the window moves from the beginning of the array.
class SlidingWindow {

    public static int findMax(int[] arr, int start, int end) {
        int max = Integer.MIN_VALUE;
        for (int i = start; i <= end; i++) {
            max = Math.max(max, arr[i]);
        }
        return max;
    }

    public static void slidingWindow(int[] arr, int k) {
        ArrayList<Integer> result = new ArrayList<>();

        for (int i = 0; i <= arr.length - k; i++) {
            int max = findMax(arr, i, i + k - 1);
            result.add(max);
        }

        // Print result
        for (int num : result) {
            System.out.print(num + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] arr = {1, 3, -1, -3, 5, 3, 6, 7};
        int k = 3;
        slidingWindow(arr, k);  // Output: 3 3 5 5 6 7
    }
}
