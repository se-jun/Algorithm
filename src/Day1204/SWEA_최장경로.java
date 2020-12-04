package Day1204;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_최장경로 {
    static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer tokens = null;
    static StringBuilder output = new StringBuilder();
    static int Testcase, N, M, x, y, max, num;
    static boolean[][] arr;
    static boolean[] isvisited;

    public static void main(String[] args) throws Exception {

        Testcase = Integer.parseInt(input.readLine());

        for (int t = 1; t <= Testcase; t++) {

            tokens = new StringTokenizer(input.readLine());

            N = Integer.parseInt(tokens.nextToken());
            M = Integer.parseInt(tokens.nextToken());

            arr = new boolean[N + 1][N + 1];
            isvisited = new boolean[N + 1];


            for (int i = 0; i < M; i++) {

                tokens = new StringTokenizer(input.readLine());

                x = Integer.parseInt(tokens.nextToken());
                y = Integer.parseInt(tokens.nextToken());

                arr[x][y] = arr[y][x] = true;

            }
            num = 1;
            max = 0;
            for (int i = 1; i <= N; i++) {
                isvisited[i] = true;
                search(i);
                isvisited[i] = false;
            }

            output.append("#").append(t).append(" ").append(max).append("\n");

        }
        System.out.println(output);
    }

    static void search(int i) {
        if (max < num) {
            max = num;
        }
        for (int r = 1; r <= N; r++) {
            if (arr[i][r] == true && isvisited[r] == false) {
                num++;
                isvisited[r] = true;
                search(r);
                isvisited[r] = false;
                num--;
            }
        }
    }
}
