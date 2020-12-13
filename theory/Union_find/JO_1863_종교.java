package Union_find;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class JO_1863_종교 {

    static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer tokens;
    static int N, M, a, b;
    static int[] arr;
    static int cnt;

    public static void main(String[] args) throws Exception {

        tokens = new StringTokenizer(input.readLine());

        N = Integer.parseInt(tokens.nextToken());
        M = Integer.parseInt(tokens.nextToken());

        makeSet(N);

        for (int i = 1; i <= M; i++) {

            tokens = new StringTokenizer(input.readLine());

            a = Integer.parseInt(tokens.nextToken());
            b = Integer.parseInt(tokens.nextToken());

            union(a, b);
        }
        cnt = 0;

        for (int i = 1; i < arr.length; i++) {
            if (i == arr[i]) {
                cnt++;
            }
        }
        System.out.println(cnt);
    }

    static void makeSet(int size) {
        arr = new int[size + 1];
        for (int i = 1; i < arr.length; i++) {
            arr[i] = i;
        }
    }

    static int findSet(int a) {
        if (arr[a] == a) {
            return a;
        } else {
            return arr[a] = findSet(arr[a]);
        }
    }

    static void union(int a, int b) {
        a = findSet(a);
        b = findSet(b);

        if (a != b) {
            arr[b] = a;
        }
    }
}

