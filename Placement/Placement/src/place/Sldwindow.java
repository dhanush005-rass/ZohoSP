package place;
import java.util.*;
class Sldwindow {
	public static int findmax(int[] arr, int start, int end) {
        int max = Integer.MIN_VALUE;
        for (int i = start; i <= end; i++) {
            max = arr[i]>max?arr[i]:max;
        }
        return max;
    }

    public static void slidingWindow(int[] arr, int k) {
        List<Integer> result = new ArrayList<>();    
        for (int i = 0; i <= arr.length - k; i++) {
           int max=0;
           for(int j=i;j<=(i+k-1);j++)
           {
        	   max=findmax(arr,i,i+k-1);
           }  
           result.add(max);
        }
        for (int num : result) {
            System.out.print(num + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] arr = {1, 3, -1, -3, 5, 3, 6, 7};  
        int k = 3;
        slidingWindow(arr, k);  
    }

}
