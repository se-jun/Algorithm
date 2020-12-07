package BFS_DFS;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_7576_토마토 {

    static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer tokens;
    static int[][] tomato;
    static int[][] check;
    static int[][] dirs = {{0, 1}, {1, 0}, {-1, 0}, {0, -1}};
    static int M, N, answer = 0;
    static Queue<Integer[]> q = new LinkedList<>();


    public static void main(String[] args) throws Exception {

        tokens = new StringTokenizer(input.readLine());

        M = Integer.parseInt(tokens.nextToken());
        N = Integer.parseInt(tokens.nextToken());

        tomato = new int[N][M];
        check = new int[N][M];

        for (int i = 0; i < N; i++) {
            tokens = new StringTokenizer(input.readLine());
            for (int j = 0; j < M; j++) {
                tomato[i][j] = Integer.parseInt(tokens.nextToken());    
                if (tomato[i][j] == 1) {
                    check[i][j] = 0;
                    Integer[] temp = new Integer[2];
                    temp[0] = i;
                    temp[1] = j;
                    q.add(temp);
                } else {
                    check[i][j] = -1;
                }
            }
        }
        bfs();

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                answer = (answer > check[i][j] ? answer : check[i][j]);
            }
        }
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (tomato[i][j] == 0 && check[i][j] == -1)
                    answer = -1;
            }
        }
        System.out.println(answer);
    }

    static void bfs() {
        while (!q.isEmpty()) {
            Integer[] temp = new Integer[2];
            temp = q.peek();
            for (int i = 0; i < 4; i++) {
                int closex = temp[0] + dirs[i][0];
                int closey = temp[1] + dirs[i][1];
                if (isIn(closex, closey)) {
                    if (tomato[closex][closey] == 0 && check[closex][closey] == -1) {
                        Integer[] tmp = new Integer[2];
                        tmp[0] = closex;
                        tmp[1] = closey;
                        q.add(tmp);
                        check[closex][closey] = check[temp[0]][temp[1]] + 1;
                    }
                }
            }
            q.remove();
        }
    }

    static boolean isIn(int r, int c) {
        return 0 <= r && r < N && 0 <= c && c < M;
    }
}
