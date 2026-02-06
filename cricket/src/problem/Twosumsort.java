//Given sorted array check if two numbers sum in it is a given
package problem;

import java.util.Arrays;

public class Twosumsort{

    public static boolean hasTwoSum(int[] arr, int target) {
        int left = 0;
        int right = arr.length - 1;
        Arrays.sort(arr);
        while (left < right) {
            int sum = arr[left] + arr[right];

            if (sum == target) {
                System.out.println("Pair found: " + arr[left] + " + " + arr[right] + " = " + target);
                return true;
            } else if (sum < target) {
                left++;
            } else {
                right--;
            }
        }

        System.out.println("No pair found with the given sum.");
        return false;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 5, 6, 8, 9, 11};  // Sorted array
        int target = 10;

        hasTwoSum(arr, target);
    }
}
