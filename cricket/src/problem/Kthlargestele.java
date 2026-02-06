package problem;
import java.util.*;

class Kthlargestele {

    public static int findklar(int[] arr, int k) {
        if (k <= 0 || k > arr.length) {
            throw new IllegalArgumentException("Invalid value of k: " + k);
        }
        Arrays.sort(arr);
        return arr[arr.length - k];
    }

    public static void main(String[] args) {
        int[] arr = {3 ,2 ,1 ,5 ,6 ,4};
        int k=2;
        try {
            int result = findklar(arr, k);
            System.out.println(k + "-th largest element is: " + result);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

     
    }
}
