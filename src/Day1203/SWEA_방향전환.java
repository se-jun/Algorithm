package Day1203;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_방향전환 {
    static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer tokens = null;
    static StringBuilder output = new StringBuilder();
    static int Testcase, N;
    static int[][] map;

    public static void main(String[] args) throws Exception {

        Testcase = Integer.parseInt(input.readLine());

        map = new int[201][201];

        for (int i = 0; i <= 200; i++) {
            for (int j = i; j <= 200; j++) {
                if (i == j) {
                    map[i][j] = i * 2;
                } else if ((i + j) % 2 == 1) {
                    map[i][j] = map[i][j - 1] + 1;
                } else {
                    map[i][j] = map[i][j - 1] + 3;
                }
            }
        }
        for (int i = 1; i <= 200; i++) {
            for (int j = 0; j < i; j++) {
                map[i][j] = map[j][i];
            }
        }

        for (int t = 1; t <= Testcase; t++) {
            int move = 0;

            tokens = new StringTokenizer(input.readLine());

            int x = Integer.parseInt(tokens.nextToken());
            int y = Integer.parseInt(tokens.nextToken());
            int nx = Integer.parseInt(tokens.nextToken());
            int ny = Integer.parseInt(tokens.nextToken());

            move = map[Math.abs(nx - x)][Math.abs(ny - y)];

            output.append("#").append(t).append(" ").append(move).append("\n");

        }
        System.out.println(output);
    }
}
