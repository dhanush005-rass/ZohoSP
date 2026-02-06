package place;
import java.util.*;
class Tictactotimtam {
		private static Scanner s=new Scanner(System.in);	
		public static void main(String []args)
		{
			System.out.println("Enter the Number of Iterations");
			int lim=s.nextInt();
			for(int i=0;i<lim;i++)
			{
				System.out.println("Enter The Player Sequence");
				String str=s.next();
				char win=tictacto(str);
				if(win=='x')
				{
					System.out.println("TIM WON");
				}
				if(win=='o')
				{
					System.out.println("TOM WON");
				}
				if(win=='d')
				{
					System.out.println("DRAW");
				}
				if(win=='i')
				{
					System.out.println("INCOMPLETE");
				}
			}
		}
		public static char tictacto(String sequence)
		{
			int len=0;
			char [][] board=new char[3][3];
			for(int row=0;row<board.length;row++)
			{
				for(int col=0;col<board[row].length;col++)
				{
					board [row][col]=sequence.charAt(len++);
				}
			}
			s = new Scanner(System.in);
			boolean hasx,haso;
			hasx=haswon(board,'x');
			haso=haswon(board,'o');
			
			if(hasx)
			{
				return 'x';
			}
			if(haso)
			{
				return 'o';
			}
			for(int row=0;row<board.length;row++)
			{
				for(int col=0;col<board[row].length;col++)
				{
					if(board[row][col]=='e')
					{
						return 'i';
					}
				}
			}
			if(!hasx&&!haso)
			{
				return 'd';
			}
			return 'i';
		}
		public static boolean haswon(char[][]board , char player)
		{
			for(int row=0;row<board.length;row++)
			{
				if(board[row][0]==player && board[row][1]==player && board[row][2]==player)
				{
					return true;
				}
			}
			for(int col=0;col<board.length;col++)
			{
				if(board[0][col]==player && board[1][col]==player && board[2][col]==player)
				{
					return true;
				}
			}
			if(board[0][0] == player && board[1][1] == player && board[2][2] == player)
			{
				return true;
			}
			if(board[0][2] == player && board[1][1] == player && board[2][0] == player)
			{
				return true;
			}
			return false;
		}
		public static void printboard(char[][]board)
		{
			for(int row=0;row<board.length;row++)
			{
				for(int col=0;col<board[row].length;col++)
				{
					System.out.print(board[row][col]+" | ");
				}
				System.out.println();
			}
		}

	

}
