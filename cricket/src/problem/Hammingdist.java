package problem;

class Hammingdist {

    // Fast bitwise version
    public static int hammingDistance(int num1, int num2) {
        int xor = num1 ^ num2;        // differing bits
        return Integer.bitCount(xor); // count set bits
    }

    // Array-based version (fixed 16 bits)
    public static int binaryHamming(int num1, int num2) {
        int[] anum1 = new int[16];
        int[] anum2 = new int[16];
        int n = 16;

        for (int i = n - 1; i >= 0; i--) {
            anum1[i] = num1 % 2;
            num1 /= 2;
            anum2[i] = num2 % 2;
            num2 /= 2;
        }

        int dist = 0;
        for (int i = 0; i < n; i++) {
            if (anum1[i] != anum2[i]) {
                dist++;
            }
        }
        return dist;
    }

    public static void main(String[] args) {
        int num1 = 3; // binary: 00011001
        int num2 = 14; // binary: 00011110

        System.out.println("Fast bitwise Hamming distance: " + hammingDistance(num1, num2));
        System.out.println("Array-based Hamming distance: " + binaryHamming(num1, num2));
    }
}
