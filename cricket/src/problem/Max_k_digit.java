package problem;
import java.util.*;
//70.	Given an array of numbers and a number k. 
//Print the maximum possible k digit number which can be formed using given numbers.
class Max_k_digit {

    // Approach 1: Sorting (Order doesn't matter)
    public static int Kdigit(int[] arr, int k) {
        Arrays.sort(arr);  // ascending
        StringBuilder sb = new StringBuilder();
        for (int i = arr.length - 1; i >= arr.length - k; i--) {
            sb.append(arr[i]);
        }
        return Integer.parseInt(sb.toString());
    }

    // Approach 2: Greedy (Preserve order, stack-based)
    public static void kdigitwos(int[] arr, int k) {
        Stack<Integer> res = new Stack<>();
        int toRemove = arr.length - k;

        for (int num : arr) {
            while (!res.isEmpty() && num > res.peek() && toRemove > 0) {
                res.pop();
                toRemove--;
            }
            res.push(num);
        }

        // Extract first k digits from the stack
        // Stack might have more than k elements, take only the top k
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            result.add(res.get(i));
        }

        // Build the number
        StringBuilder sb = new StringBuilder();
        for (int digit : result) {
            sb.append(digit);
        }
 
        System.out.println("Greedy Max " + k + "-digit number (preserving order): " + sb.toString());
    }

    public static void main(String[] args) {
        int[] arr = {3, 5, 2, 9, 1};
        int k = 3;

        System.out.println("Sort-based Max " + k + "-digit number: " + Kdigit(arr.clone(), k));
        kdigitwos(arr, k);
    }
}
