package problem;
import java.util.*;
class LiveDeadcell {

	private static Scanner s = new Scanner(System.in);

    public static void main(String[] args) {
        int m, n;
        m = s.nextInt();
        n = s.nextInt();

        int[][] board = new int[m][n];

        // Reading the board
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = s.nextInt();
            }
        }

        int[][] nextState = getNextState(board, m, n);

        // Printing the next state row-wise
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(nextState[i][j] + " ");
            }
            System.out.println();
        }
    }
    
    public static int[][]getNextState(int[][]board,int m,int n)
    {
    	int[][]ans=new int[m][n];
    	int[] dx = {-1, -1, -1, 0, 0, 1, 1, 1};
        int[] dy = {-1, 0, 1, -1, 1, -1, 0, 1};
    	for(int i=0;i<board.length;i++)
    	{
    		for(int j=0;j<board[i].length;j++)
    		{
    			int liveneibhours=0;
    			
    			for(int k=0;k<dx.length;k++)
    			{
    				int ni=i+dx[k];
    				int nj=j+dy[k];
    				if(ni>=0 && ni<m && nj>=0 && nj<n && board[ni][nj]==1)
    				{
    					liveneibhours++;
    				}
    			}
    			// Apply Conway's rules
                if (board[i][j] == 1) {
                    if (liveneibhours < 2 || liveneibhours > 3)
                        ans[i][j] = 0; // Dies
                    else
                        ans[i][j] = 1; // Lives
                } else {
                    if (liveneibhours == 3)
                        ans[i][j] = 1; // Becomes alive
                    else
                    	ans[i][j] = 0; // Remains dead
                }
    		}
    	}
    	return ans;
    }
}
