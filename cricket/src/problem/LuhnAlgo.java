package problem;

public class LuhnAlgo {

    // Helper: sum of digits
    public static int digitSum(int num) {
        int sum = 0;
        while (num > 0) {
            sum += num % 10;
            num /= 10;
        }
        return sum;
    }

    // Luhn validation
    public static String validate(String accno) {
        int sum = 0;
        int pos = 0;  // position from the right

        for (int i = accno.length() - 1; i >= 0; i--) {
            int num = accno.charAt(i) - '0';
            if (pos % 2 == 1) {  // double every 2nd digit from right
                num *= 2;
            }
            sum += digitSum(num);
            pos++;
        }

        return (sum % 10 == 0) ? "VALID" : "NOT VALID";
    }

    // Main method for testing
    public static void main(String[] args) {
        // Some known test numbers
        System.out.println("\n--- Test Cases ---");
        System.out.println("4539578763621486 -> " + validate("4539578763621486")); // VALID (Visa test number)
        System.out.println("6011111111111117 -> " + validate("6011111111111117")); // VALID (Discover test number)
        System.out.println("1234567812345670 -> " + validate("1234567812345670")); // VALID
        System.out.println("1234567812345678 -> " + validate("1234567812345678")); // NOT VALID
    }
}
