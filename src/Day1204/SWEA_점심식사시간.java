package Day1204;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_점심식사시간 {
    static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer tokens = null;
    static StringBuilder output = new StringBuilder();
    static int Testcase, N;
    static int[][] map;

    public static void main(String[] args) throws Exception {

        Testcase = Integer.parseInt(input.readLine());

        for (int t = 1; t <= Testcase; t++) {

            N = Integer.parseInt(input.readLine());

            map = new int[N][N];
            
            for(int i = 0; i<N; i++) {
                
            }
            tokens = new StringTokenizer(input.readLine());


            output.append("#").append(t).append(" ").append(1).append("\n");

        }
        System.out.println(output);
    }
}
