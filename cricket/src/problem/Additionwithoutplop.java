package problem;
class Additionwithoutplop {
	public static int add(int a, int b) {
        while (b != 0) {
            int carry = (a & b) << 1; // carry where both have 1s
            a = a ^ b;                // partial sum without carry
            b = carry;                // add the carry next
        }
        return a;
    }

    // Sum an entire array without arithmetic operators
    public static int sumArray(int[] arr) {
        int sum = 0;
        for (int i = 0; i < arr.length; i = add(i, 1)) { // i++ avoided
            sum = add(sum, arr[i]);
        }
        return sum;
    }

    public static void main(String[] args) {
        int[]arr= {1,2,3,4};
        System.out.println(add(13,9));
        System.out.println(sumArray(arr));
    }
}
