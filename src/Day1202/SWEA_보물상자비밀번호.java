package Day1202;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class SWEA_보물상자비밀번호 {

    static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer tokens = null;
    static StringBuilder output = new StringBuilder();
    static TreeSet<String> set = new TreeSet<>();
    static int testcase, N, K;

    public static void main(String[] args) throws Exception {

        testcase = Integer.parseInt(input.readLine());

        for (int t = 1; t <= testcase; t++) {
            tokens = new StringTokenizer(input.readLine());

            N = Integer.parseInt(tokens.nextToken());
            K = Integer.parseInt(tokens.nextToken());

            int len = N / 4;
            String str = input.readLine();


            str += str.substring(0, len - 1);

            for (int i = 0; i < N; i++) {
                set.add(str.substring(i, i + len));
            }

            String[] arr = new String[set.size()];

            int arr_len = arr.length;

            for (int i = 0; i < arr_len; i++) {
                arr[i] = set.pollFirst();
            }

            int answer = Integer.parseInt(arr[arr_len - K], 16);

            output.append("#").append(t).append(" ").append(answer).append("\n");

        }
        System.out.println(output);
    }
}
