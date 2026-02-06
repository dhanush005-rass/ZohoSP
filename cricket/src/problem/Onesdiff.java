package problem;
public class Onesdiff {
	public static int finddiff(int[]arr)
	{
		int maxcount=Integer.MIN_VALUE;
		int mincount=Integer.MAX_VALUE;
		int currentcount=0;
		for(int i=0;i<arr.length;i++)
		{
			if(arr[i]==1)
			{
				currentcount++;
			}
			else
			{
				currentcount=0;
			}
			maxcount=currentcount>maxcount?currentcount:maxcount;
			mincount=currentcount<mincount?currentcount:mincount;
		}
		return (maxcount-mincount);
	}
	public static void main(String[]args)
	{
		int[]arr= {0,1,0,1,1};
		int ans=finddiff(arr);
		System.out.println(ans);
	}
}
