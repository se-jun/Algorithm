package BFS_DFS;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class BOJ_2667_단지번호붙이기 {
    static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    static Queue<Integer[]> q = new LinkedList<>();
    static int N, cnt, num;
    static char[] temp;
    static int[] arr;
    static int[][] map;
    static int[][] dirs = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};

    public static void main(String[] args) throws Exception {

        cnt = 0;

        N = Integer.parseInt(input.readLine());

        map = new int[N][N];

        arr = new int[N * N];

        for (int i = 0; i < N; i++) {
            temp = input.readLine().toCharArray();
            for (int j = 0; j < N; j++) {
                map[i][j] = temp[j] - '0';
            }
        }
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (map[i][j] == 1) {
                    num = 0;
                    map[i][j] = 0;
                    Integer[] temp = {i, j};
                    q.add(temp);
                    bfs(i, j);
                    arr[cnt] = num;
                    cnt++;
                }
            }
        }
        Arrays.sort(arr, 0, cnt);

        System.out.println(cnt);
        for (int i = 0; i < cnt; i++) {
            System.out.println(arr[i] + 1);
        }

    }

    static void bfs(int x, int y) {
        while (!q.isEmpty()) {
            Integer[] temp = new Integer[2];
            temp = q.poll();
            for (int i = 0; i < dirs.length; i++) {
                int nx = temp[0] + dirs[i][0];
                int ny = temp[1] + dirs[i][1];

                if (isIn(nx, ny) && map[nx][ny] == 1) {
                    map[nx][ny] = 0;
                    num++;
                    q.add(new Integer[] {nx, ny});
                }
            }
        }
    }


    static boolean isIn(int x, int y) {
        return 0 <= x && x < N && 0 <= y && y < N;
    }
}
