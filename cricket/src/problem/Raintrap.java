package problem;

public class Raintrap {
    
    public static int rainwtuni(int[] arr) {
        int n = arr.length;
        if (n == 0) return 0;
        
        int[] left = new int[n];
        int[] right = new int[n];
        
        // Fill left array
        left[0] = arr[0];
        for (int i = 1; i < n; i++) {
            left[i] = Math.max(left[i - 1], arr[i]);
        }
        
        // Fill right array
        right[n - 1] = arr[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            right[i] = Math.max(right[i + 1], arr[i]);
        }
        
        // Calculate trapped water
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += Math.min(left[i], right[i]) - arr[i];
        }
        
        return sum;
    }
    public static void main(String[] args) {
        int[] arr = {3, 0, 2, 0, 4};
        System.out.println(rainwtuni(arr)); // Output: 7
        /*
         *     #
         * #   #
         * # # #
         * # # #*/
    }
    
}
