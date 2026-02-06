package problem;

class Movezerolast {
	
	public static int[] zl(int[] arr) {
	    int pos = 0;

	    // Move non-zero elements forward
	    for (int i = 0; i < arr.length; i++) {
	        if (arr[i] != 0) {
	            arr[pos++] = arr[i];
	        }
	    }

	    // Fill the rest with zeros
	    while (pos < arr.length) {
	        arr[pos++] = 0;
	    }

	    return arr;
	}
	
	public static void main(String[] args) {
        int[] test = {0, 1, 0, 3, 12};
        int[] result = zl(test);

        // Print result
        for (int num : result) {
            System.out.print(num + " ");
        }
        // Output: 1 3 12 0 0
    }
}
