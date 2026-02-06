package place;
import java.util.*;

class KnightTarget {

    public static int knight(int[][] chess, int kx, int ky, int tx, int ty) {
       
        if (kx == tx && ky == ty) return 0;

        
        int[] dx = {-2, -2, -1, -1, 1, 1, 2, 2};
        int[] dy = {-1, 1, -2, 2, -2, 2, -1, 1};

        boolean[][] visited = new boolean[chess.length][chess[0].length];
        Queue<int[]> queue = new LinkedList<>();

        
        queue.add(new int[]{kx, ky, 0});
        visited[kx][ky] = true;

        while (!queue.isEmpty()) {
            int[] curr = queue.poll();
            int x = curr[0], y = curr[1], dist = curr[2];

            
            for (int k = 0; k < 8; k++) {
                int ni = x + dx[k];
                int nj = y + dy[k];

                
                if (ni >= 0 && ni < chess.length && nj >= 0 && nj < chess[0].length && !visited[ni][nj]) {
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

    public static void main(String[] args) {
        int[][] chess = new int[6][6];
        System.out.println(knight(chess, 1,4,0,4));
    }
}
