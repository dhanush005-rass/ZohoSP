package problem;

class Mulresofarrno {
    public static int[] mularr(int[] arr) {
        int[] res = new int[arr.length];
        
        for (int i = 0; i < arr.length; i++) {
            int mul = 1; // start with 1, not 0
            
            for (int j = 0; j < arr.length; j++) {
                if (j != i) { // skip current element
                    mul *= arr[j];
                }
            }
            res[i] = mul;
        }
        
        return res;
    }

    // Test
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4};
        int[] res = mularr(arr);
        
        for (int val : res) {
            System.out.print(val + " ");
        }
    }
}
