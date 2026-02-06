package XO;
import java.util.*;
class Main {
	private static Scanner s;
	public static void main(String [] args)
	{
		char [][] board=new char[3][3];
		for(int row=0;row<board.length;row++)
		{
			for(int col=0;col<board[row].length;col++)
			{
				board [row][col]=' ';
			}
		}
		char player='x';
		boolean gameover=false;
		s = new Scanner(System.in);
		
		while(!gameover)
		{
			System.out.println();
			printboard(board);
			System.out.println();System.out.println("Player "+player +" enter : ");
			int row=s.nextInt();
			int col=s.nextInt();
			if(board[row][col]==' ')
			{
				board[row][col]=player;
				gameover=haswon(board,player);
				if(gameover)
				{
					System.out.println("player "+player+" has won ");
				}
				else
				{
					player=(player=='x')?'o':'x';
				}
			}
			else
			{
				System.out.println("Invalide move Try Again ");
			}
			System.out.println();
			printboard(board);
		}
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
