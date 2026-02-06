package problem;
import java.util.*;

class Removeduplicate {
    public static int[] remdupi(int[] arr) {
        // LinkedHashSet removes duplicates and preserves order
        Set<Integer> set = new LinkedHashSet<>();
        for (int num : arr) {
            set.add(num);
        }

        // Convert Set<Integer> to int[]
        int[] result = new int[set.size()];
        int i = 0;
        for (int num : set) {
            result[i++] = num;
        }
        return result;
    }

    public static void main(String[] args) {
        int[] arr = {1 ,2 ,2 ,4 ,4 ,5 ,6 ,7 ,7};
        int[] unique = remdupi(arr);

        System.out.print("Array without duplicates: ");
        for (int num : unique) {
            System.out.print(num + " ");
        }
    }
}
