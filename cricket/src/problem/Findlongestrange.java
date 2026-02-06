//Given an array of positive numbers. Print the numbers which have longest continuous range.
package problem;
import java.util.*;
class Findlongestrange {
	
	public static void findlongest(int [] arr)
	{
		Set<Integer> ans=new TreeSet<>();
		for(int num:arr)
		{
			ans.add(num);
		}
		int maxlength=0;
		int currentlength=0;
		int currentstart=0;
		int startofmax=0;
		int prev=Integer.MIN_VALUE;
		
		for(int num:ans)
		{
			if(num==prev+1)
			{
				currentlength++;
			}
			else
			{
				currentlength=1;
				currentstart=num;
			}
			if(currentlength>maxlength)
			{
				maxlength=currentlength;
				startofmax=currentstart;
			}
			prev=num;
		}
		System.out.print("Longest continuous range: ");
        for (int i = 0; i < maxlength; i++) {
            System.out.print((startofmax + i) + " ");
        }
        System.out.println();
	}
	
	public static void main(String[] args) {
        int[] arr = {100, 4, 200, 1, 3, 2};
        findlongest(arr);  // Output: 1 2 3 4
    }
}
