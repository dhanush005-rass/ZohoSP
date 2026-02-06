package problem;
import java.util.*;
public class Palipair {
	public static boolean ispali(String s) {
        String rev = new StringBuilder(s).reverse().toString();
        return rev.equals(s);
    }
	
    public static List<List<Integer>> palindromePairs(String[] words) {
        List<List<Integer>> ans = new ArrayList<>();

        for (int i = 0; i < words.length; i++) {
            for (int j = i + 1; j < words.length; j++) {
                String s1 = words[i] + words[j];
                String s2 = words[j] + words[i];

                if (ispali(s1)) ans.add(Arrays.asList(i, j));
                if (ispali(s2)) ans.add(Arrays.asList(j, i));
            }
        }
        return ans;
    }
    
    public static void main(String []args)
    {
    	String [] words = {"abcd","dcba","lls","s","sssll"};
    	List<List<Integer>> ans=palindromePairs(words);
    	System.out.println(ans.toString());
    }
}
