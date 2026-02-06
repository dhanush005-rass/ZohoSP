package problem;

import java.util.*;

class MaxXorSubsetN2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int[] A = new int[N];
        for (int i = 0; i < N; i++) {
            A[i] = sc.nextInt();
        }

        int maxXor = 0;

        // Case 1: pick single element
        for (int i = 0; i < N; i++) {
            maxXor = Math.max(maxXor, A[i]);
        }

        // Case 2: pick two elements
        for (int i = 0; i < N; i++) {
            for (int j = i + 1; j < N; j++) {
                maxXor = Math.max(maxXor, A[i] ^ A[j]);
            }
        }

        System.out.println(maxXor);
        sc.close();
    }
}
