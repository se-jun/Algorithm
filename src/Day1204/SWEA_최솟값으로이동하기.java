package Day1204;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class SWEA_최솟값으로이동하기 {
    static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer tokens = null;
    static StringBuilder output = new StringBuilder();
    static int Testcase, N, W, H, min;
    static int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}, {1, 1}};
    static int[][] pos;
    static boolean[][] isvisited;

    public static void main(String[] args) throws Exception {

        Testcase = Integer.parseInt(input.readLine());

        for (int t = 1; t <= Testcase; t++) {
            min = 0;
            tokens = new StringTokenizer(input.readLine());

            W = Integer.parseInt(tokens.nextToken());
            H = Integer.parseInt(tokens.nextToken());
            N = Integer.parseInt(tokens.nextToken());

            pos = new int[N][2];

            for (int i = 0; i < N; i++) {
                tokens = new StringTokenizer(input.readLine());
                pos[i][0] = Integer.parseInt(tokens.nextToken());
                pos[i][1] = Integer.parseInt(tokens.nextToken());
            }
            for (int i = 0; i < N - 1; i++) {
                search(i);
            }

            output.append("#").append(t).append(" ").append(min).append("\n");

        }
        System.out.println(output);
    }

    static void search(int idx) {
        int x = pos[idx][0];
        int y = pos[idx][1];

        int nx = pos[idx + 1][0];
        int ny = pos[idx + 1][1];

        if ((nx > x && ny < y) || (nx < x && ny > y)) {
            min += Math.abs(nx - x) + Math.abs(ny - y);
        } else {
            min += (Math.min(Math.abs(nx - x), Math.abs(ny - y))
                    + Math.abs(Math.abs(nx - x) - Math.abs(ny - y)));
        }
    }
}
