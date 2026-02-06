package problem;

class Ketpadpermuntation {
	public static String[] keypad= {"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
	public static void possiblecombi(String s,String ans)
	{
		if(s.length()==0)
		{
			System.out.println(ans);
			return;
		}
		String key=keypad[s.charAt(0)-'0'];
		for(int i=0;i<key.length();i++)
		{
			possiblecombi(s.substring(1),ans+key.charAt(i));
		}
	}
	public static void main(String[]args)
	{
		possiblecombi("846","");
	}
}
