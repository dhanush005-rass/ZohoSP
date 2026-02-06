package problem;

class Twistedprime {

    // ✅ Check if a number is prime
    public static boolean isPrime(int num) {
        if (num <= 1) return false;  // 0 and 1 are not prime

        for (int i = 2; i * i <= num; i++) {
            if (num % i == 0) return false;  // divisible → not prime
        }

        return true;  // passed all checks → prime
    }

    // ✅ Check if both number and its reverse are prime
    public static boolean isTwistedPrime(int num) {
        if (!isPrime(num)) return false;  // original not prime

        // Reverse the number
        int rev = Integer.parseInt(new StringBuilder(String.valueOf(num)).reverse().toString());

        return isPrime(rev);  // true only if reverse is also prime
    }

    // 🔍 Test
    public static void main(String[] args) {
        int num = 13;
        if (isTwistedPrime(num)) {
            System.out.println(num + " is a twisted prime.");
        } else {
            System.out.println(num + " is NOT a twisted prime.");
        }
    }
}
