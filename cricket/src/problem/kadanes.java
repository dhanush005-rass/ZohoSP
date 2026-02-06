package problem;


	
	class KadanesAlgorithm {

	    public static int kadanes_algo(int[] arr) {
	        int max = Integer.MIN_VALUE, sum = 0;
	        int start = 0, ansStart = 0, ansEnd = 0;

	        for (int i = 0; i < arr.length; i++) {
	            if (sum == 0) {
	                start = i;
	            }

	            sum += arr[i];

	            if (sum > max) {
	                max = sum;
	                ansStart = start;
	                ansEnd = i;
	            }

	            if (sum < 0) {
	                sum = 0;
	            }
	        }

	        System.out.println("The Starting And Ending Index Is : (" + ansStart + ", " + ansEnd + ")");
	        return max;  // Always return actual max, even if negative
	    }

	    public static void main(String[] args) {
	        int[] arr = {-2, -3, 4, -1, -2, 1, 5, -3};
	        System.out.println("Maximum Subarray Sum is: " + kadanes_algo(arr));
	    }
	}



