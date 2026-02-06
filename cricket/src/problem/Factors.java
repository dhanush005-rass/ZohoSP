package problem;
import java.util.*;

public class Factors {

    public static int[] factors(int num) {
    	if(num==0)
    	{
    		System.out.println("No Factors");
    		int[]arr= {};
    		return arr;
    	}
    	if(num<0)
    	{
    		num*=-1;
    	}
    	
        List<Integer> factor = new ArrayList<>();
        for (int i = 1; i <= num; i++) {
            if (num % i == 0) {
                factor.add(i);
            }
        }
        // Convert List<Integer> to int[]
        int[] result = new int[factor.size()];
        for (int i = 0; i < factor.size(); i++) {
            result[i] = factor.get(i);
        }
        return result;
    }

    public static void main(String[] args) {
    	int num=12;
    	int[] factorsArr = factors(num);
        System.out.print("Factors of " + num + ": ");
        for (int f : factorsArr) {
            System.out.print(f + " ");
        }
    }
}
