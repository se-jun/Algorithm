package BFS_DFS;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_4963_섬의개수 {
    static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer tokens = null;
    static int W, H;
    static int[][] map;
    static int[][] dirs = {{-1, -1}, {0, -1}, {1, -1}, {-1, 0}, {1, 0}, {-1, 1}, {0, 1}, {1, 1}};
    static Queue<Integer[]> q = new LinkedList<>();
    static int cnt;

    public static void main(String[] args) throws Exception {

        
        while (true) {

            tokens = new StringTokenizer(input.readLine());
            
            W = Integer.parseInt(tokens.nextToken());
            H = Integer.parseInt(tokens.nextToken());
            
            if(W == 0 && H == 0)    break;

            map = new int[H][W];
            cnt = 0;

            for (int i = 0; i < H; i++) {
                tokens = new StringTokenizer(input.readLine());
                for (int j = 0; j < W; j++) {
                    map[i][j] = Integer.parseInt(tokens.nextToken());
                }
            }
            for(int i = 0; i<H; i++) {
                for(int j = 0; j<W; j++) {
                    if(map[i][j] == 1) {
                        bfs(i, j);
                        map[i][j] = 0;
                        cnt++;
                    }
                }
            }
            
            System.out.println(cnt);
        }
    }

    static void bfs(int x, int y) {
        q.add(new Integer[] {x, y});
        
        while(!q.isEmpty()) {
            Integer[] temp = q.remove();
            for(int i = 0; i<dirs.length; i++) {
                int nx = temp[0] + dirs[i][0];
                int ny = temp[1] + dirs[i][1];
                
                if(isIn(nx, ny) && map[nx][ny] == 1) {
                    map[nx][ny] = 0;
                    q.add(new Integer[] {nx, ny});
                }
            }
        }
        
    }

    static boolean isIn(int x, int y) {
        return 0 <= x && x < H && 0 <= y && y < W;
    }
}
