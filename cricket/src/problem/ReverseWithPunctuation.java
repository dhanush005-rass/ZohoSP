package problem;

class ReverseWithPunctuation {

    public static String reversePreservePunctuation(String str) {
        char[] arr = str.toCharArray();
        int left = 0;
        int right = arr.length - 1;

        while (left < right) {
            // Skip non-letter and non-digit on left
            if (!Character.isLetterOrDigit(arr[left])) {
                left++;
            }
            // Skip non-letter and non-digit on right
            else if (!Character.isLetterOrDigit(arr[right])) {
                right--;
            }
            // Both are letters/digits, swap
            else {
                char temp = arr[left];
                arr[left] = arr[right];
                arr[right] = temp;
                left++;
                right--;
            }
        }

        return new String(arr);
    }

    public static void main(String[] args) {
        String input = "Ab,c,de!$ fg";
        String output = reversePreservePunctuation(input);
        System.out.println(output);  // Output: "gf,e,dc!$ bA"
    }
}
