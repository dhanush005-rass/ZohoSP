package problem;

class Knapsack {
    public static float knasac(int bagcap, int[] wei, int[] pro) {
        float[] proweirat = new float[wei.length];

        // Calculate profit/weight ratio
        for (int i = 0; i < wei.length; i++) {
            proweirat[i] = (float) pro[i] / wei[i];
        }

        // Sort items by ratio in DESCENDING order
        for (int i = 0; i < wei.length; i++) {
            for (int j = i + 1; j < wei.length; j++) {
                if (proweirat[i] < proweirat[j]) {   // ✅ changed to descending
                    float tempf = proweirat[i];
                    proweirat[i] = proweirat[j];
                    proweirat[j] = tempf;

                    int tempi = wei[i];
                    wei[i] = wei[j];
                    wei[j] = tempi;

                    tempi = pro[i];
                    pro[i] = pro[j];
                    pro[j] = tempi;
                }
            }
        }

        float profit = 0;

        // Take items until capacity is full
        for (int i = 0; i < wei.length && bagcap > 0; i++) {
            if (wei[i] <= bagcap) {
                // take whole item
                profit += pro[i];
                bagcap -= wei[i];
            } else {
                // take fraction of item
                profit += proweirat[i] * bagcap;
                bagcap = 0;
            }
        }
        return profit;
    }

    public static void main(String[] args) {
        int[] weights = {10, 20, 30};
        int[] profits = {60, 100, 120};
        int capacity = 50;

        float maxProfit = knasac(capacity, weights, profits);
        System.out.println("Maximum Profit = " + maxProfit);
    }
}



