package Maze;
import java.util.*;
class Mazesp {

	public static int mazerunner(char[][] maze, int kx, int ky, int tx, int ty) {
	       
        if (kx == tx && ky == ty) return 0;

        
        int[] dx = {-1, -1, -1, 0, 0, 1, 1, 1}; 
        int[] dy = {-1,  0,  1, -1, 1, -1, 0, 1};
        boolean[][] visited = new boolean[maze.length][maze[0].length];
        Queue<int[]> queue = new LinkedList<>();

        
        queue.add(new int[]{kx, ky, 0});
        visited[kx][ky] = true;

        while (!queue.isEmpty()) {
            int[] curr = queue.poll();
            int x = curr[0], y = curr[1], dist = curr[2];

            
            for (int k = 0; k < 8; k++) {
                int ni = x + dx[k];
                int nj = y + dy[k];

                
                if (ni >= 0 && ni < maze.length && nj >= 0 && nj < maze[0].length && !visited[ni][nj]) {
                    if (ni == tx && nj == ty) {
                        return dist + 1; 
                    }

                    visited[ni][nj] = true;
                    queue.add(new int[]{ni, nj, dist + 1});
                }
            }
        }
        return -1; 
    }
	public static void printmaze(char[][]maze,int ax,int ay,int dx,int dy)
	{
		for(int i=0;i<maze.length;i++)
		{
			for(int j=0;j<maze[i].length;j++)
			{
				maze[i][j]='0';
			}
		}
		maze[ax][ay]='A';
		maze[dx][dy]='D';
		for(int i=0;i<maze.length;i++)
		{
			for(int j=0;j<maze[i].length;j++)
			{
				System.out.print(maze[i][j]+" ");
			}
			System.out.println();
		}
	}
    public static void main(String[] args) {
        char[][] maze = new char[7][7];
        printmaze(maze,0,3,4,5);
        System.out.println();
        System.out.println(mazerunner(maze,0,3,4,5));
    }

}
