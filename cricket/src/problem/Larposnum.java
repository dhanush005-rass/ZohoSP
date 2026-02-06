package problem;
import java.util.*;
public class Larposnum {
	
	public static int[] larpos(int []arr)
	{
		String ij="";
		String ji="";
		for (int i=0;i<arr.length;i++)
		{
			for (int j=i+1;j<arr.length;j++)
			{
				ij=Integer.toString(arr[i])+Integer.toString(arr[j]);
				ji=Integer.toString(arr[j])+Integer.toString(arr[i]);
				if(ji.compareTo(ij)>0)
				{
					int temp=arr[i];
					arr[i]=arr[j];
					arr[j]=temp;
				}
			}
		}
		return arr;
	}
	public static void main(String []args)
	{
		int []arr= {3,30,34,9};
		arr=larpos(arr);
		System.out.println(Arrays.toString(arr));
	}
}
