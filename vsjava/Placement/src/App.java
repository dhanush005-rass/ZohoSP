import java.util.*;

public class App {
    public static int[] remcosirep(int[] arr) {
        if (arr.length == 0) return new int[0]; // edge case

        List<Integer> list = new ArrayList<>();
        list.add(arr[0]); // always add the first element

        for (int i = 1; i < arr.length; i++) {
            if (arr[i] != arr[i - 1]) { // only add if different from previous
                list.add(arr[i]);
            }
        }

        int[] result = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            result[i] = list.get(i);
        }
        return result;
    }

    public static void main(String[] args) {
        int[] arr = {1, 1, 2, 2, 2, 3, 1, 1, 4};
        int[] result = remcosirep(arr);

        System.out.println("Original: " + Arrays.toString(arr));
        System.out.println("Without consecutive duplicates: " + Arrays.toString(result));
    }
}
