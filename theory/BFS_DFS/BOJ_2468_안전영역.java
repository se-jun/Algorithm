package BFS_DFS;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_2468_안전영역 {
    static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer tokens = null;
    static int N, high_max, high_min;
    static int[][] map;
    static int[][] map2;
    static int[] max;
    static int[][] dirs = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};
    static Queue<Integer[]> q = new LinkedList<>();


    public static void main(String[] args) throws Exception {

        N = Integer.parseInt(input.readLine());

        map = new int[N][N];

        max = new int[101];

        high_max = 0;

        high_min = 101;

        for (int i = 0; i < N; i++) {
            tokens = new StringTokenizer(input.readLine(), " ");
            for (int j = 0; j < N; j++) {
                int tmp = Integer.parseInt(tokens.nextToken());
                map[i][j] = tmp;
                if (high_max < tmp) {
                    high_max = tmp;
                }
                if (high_min > tmp) {
                    high_min = tmp;
                }
            }
        }
        for (int i = high_min - 1; i <= high_max; i++) {
            map2 = new int[N][N];

            for (int r = 0; r < N; r++) {
                for (int c = 0; c < N; c++) {
                    map2[r][c] = map[r][c];
                }
            }
            
            for (int r = 0; r < N; r++) {
                for (int c = 0; c < N; c++) {
                    if (map2[r][c] > i) {

                        map2[r][c] = 0;
                        Integer[] temp = {r, c};
                        q.add(temp);
                        bfs(r, c, i);
                        max[i]++;
                    }
                }
            }
        }

        Arrays.sort(max);

        System.out.println(max[max.length - 1]);

    }

    static void bfs(int x, int y, int high) {


        while (!q.isEmpty()) {
            Integer[] temp = new Integer[2];
            int size = q.size();
            temp = q.poll();
            while (--size >= 0) {
                for (int i = 0; i < dirs.length; i++) {
                    int nx = temp[0] + dirs[i][0];
                    int ny = temp[1] + dirs[i][1];

                    if (isIn(nx, ny) && map2[nx][ny] > high) {
                        map2[nx][ny] = 0;
                        q.add(new Integer[] {nx, ny});
                    }
                }
            }
        }
    }

    static boolean isIn(int x, int y) {
        return 0 <= x && x < N && 0 <= y && y < N;
    }
}
