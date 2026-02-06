package problem;
import java.util.*;
class Redugliofstr {
	static final long MOD = 1000000007;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt(); // length of string
        String S = sc.next(); // binary string
        long CASH = sc.nextLong(); // total coins
        long A = sc.nextLong(); // swap cost
        long B = sc.nextLong(); // flip cost

        char[] arr = S.toCharArray();

        // Greedy from left (most significant bit) to right
        for (int i = 0; i < N && CASH > 0; i++) {
            if (arr[i] == '1') {
                // Option 1: Flip directly
                if (B <= A) {
                    if (CASH >= B) {
                        arr[i] = '0';
                        CASH -= B;
                    }
                } else {
                    // Option 2: Swap with nearest '0' on right
                    int j = -1;
                    for (int k = N - 1; k > i; k--) {
                        if (arr[k] == '0') {
                            j = k;
                            break;
                        }
                    }
                    if (j != -1 && CASH >= A) {
                        // Swap to push zero left
                        char tmp = arr[i];
                        arr[i] = arr[j];
                        arr[j] = tmp;
                        CASH -= A;
                        i--; // recheck same index (it may still be '1')
                    } else {
                        // fallback: flip if possible
                        if (CASH >= B) {
                            arr[i] = '0';
                            CASH -= B;
                        }
                    }
                }
            }
        }

        // Convert minimized string back to decimal
        long result = 0;
        for (int i = 0; i < N; i++) {
            result = (result * 2 + (arr[i] - '0')) % MOD;
        }

        System.out.println(result);
        sc.close();
    }
}
