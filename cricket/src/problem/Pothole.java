package problem;

public class Pothole {
	public static int minMachinesToFix(String road) {
        int machines = 0;
        int i = 0;

        while (i < road.length()) {
            if (road.charAt(i) == '.') {
                i++;
            } else {
                // Pothole found, fix 3-unit segment from here
                machines++;
                i += 3;
            }
        }

        return machines;
    }

    public static void main(String[] args) {
        System.out.println(minMachinesToFix(".X."));         // 1
        System.out.println(minMachinesToFix(".X...X"));      // 2
        System.out.println(minMachinesToFix("XXX.XXXX"));    // 3
        System.out.println(minMachinesToFix(".X.XX.XX.X"));  // 3
    }
}
