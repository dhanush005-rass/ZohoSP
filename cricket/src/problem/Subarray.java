package problem;
class Subarray {
    public static int subarrayMinSum(int[] arr) {
        int n = arr.length;
        int totalSum = 0;

        for (int i = 0; i < n; i++) {
            int minVal = Integer.MAX_VALUE;
            for (int j = i; j < n; j++) {
                // Update min as subarray expands
                if (arr[j] < minVal) {
                    minVal = arr[j];
                }
                totalSum += minVal;
            }
        }

        return totalSum;
    }

    public static void main(String[] args) {
        
        int[] arr = {1,2,3,4};
        System.out.println(subarrayMinSum(arr));
    }
}