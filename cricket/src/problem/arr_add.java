package problem;
import java.util.*;

class arr_add {
    
    public static int[] addHugeNumbers(int[] num1, int[] num2) {
        int i = num1.length - 1;
        int j = num2.length - 1;
        ArrayList<Integer> result = new ArrayList<>();
        int carry = 0;

        while (i >= 0 || j >= 0 || carry > 0) {
            int digit1 = (i >= 0) ? num1[i] : 0;
            int digit2 = (j >= 0) ? num2[j] : 0;

            int sum = digit1 + digit2 + carry;
            result.add(sum % 10);       // Store last digit
            carry = sum / 10;           // Carry for next

            i--;
            j--;
        }

        // Since result is reversed, reverse it back to proper order
        Collections.reverse(result);

        // Convert ArrayList to int[]
        int[] sumArray = new int[result.size()];
        for (int k = 0; k < result.size(); k++) {
            sumArray[k] = result.get(k);
        }

        return sumArray;
    }

    public static void main(String[] args) {
        // Example huge numbers
        int[] num1 = {9, 9, 9, 9, 9};
        int[] num2 = {1};

        int[] sum = addHugeNumbers(num1, num2);

        System.out.print("Sum = ");
        for (int digit : sum) {
            System.out.print(digit);
        }
        System.out.println();
    }
}
