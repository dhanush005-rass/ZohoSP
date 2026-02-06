package problem;

class cricket {
	public static void runs(String timeline)
	{
		int player1=0,player2=0,extras=0;
		boolean isp1os=true;
		
		for(int i=0;i<timeline.length();i++)
		{
			char ch=timeline.charAt(i);
			if(ch=='w' ||ch== 'W')
			{
				extras++;
			}
			else if(ch=='n'||ch=='N')
			{
				extras++;
				if(i+1<timeline.length())
				{
					char next=timeline.charAt(i+1);
					if(Character.isDigit(next))
					{
						int num=Character.getNumericValue(next);
						if(isp1os)
						{
							player1+=num;
						}
						else 
						{
							player2+=num;
						}
						if(num%2!=0)
						{
							isp1os=!isp1os;
						}i++;
					}
				}
			}
			else if(ch=='.')
			{
				continue;
			}
			else
			{
				int num=Character.getNumericValue(ch);
				if(isp1os)
				{
					player1+=num;
				}
				else 
				{
					player2+=num;
				}
				if(num%2!=0)
				{
					isp1os=!isp1os;
				}
			}
		}
		System.out.println("Player 1 Score: " + player1);
        System.out.println("Player 2 Score: " + player2);
        System.out.println("Extras: " + extras);
	}
	
	public static void main(String[]x)
	{
		runs("1.2W3N4.");
	}
}
