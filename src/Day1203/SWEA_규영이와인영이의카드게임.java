package Day1203;

import java.util.ArrayList;
import java.util.Scanner;

public class SWEA_규영이와인영이의카드게임 {
    static int[] v;
    static ArrayList<Integer> a;
    static ArrayList<Integer> b;
    static int cnt;
    static int[] r;
    static int a_vic;
    static int b_vic;

    public static void dfs(int x, int depth) {
        v[x] = 1;
        r[depth - 1] = x;

        if (depth == 9) {
            int a_score = 0;
            int b_score = 0;
            for (int i = 0; i <= 8; i++) {
                int a_card = a.get(i);
                int b_card = b.get(r[i] - 1);

                if (a_card > b_card)
                    a_score += a_card + b_card;
                else
                    b_score += a_card + b_card;
            }
            if (a_score > b_score)
                a_vic++;
            else if (b_score > a_score)
                b_vic++;
        }

        for (int i = 1; i < 10; i++) {
            if (v[i] == 0) {
                dfs(i, depth + 1);
                v[i] = 0;
            }
        }
        v[x] = 0;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int tc = sc.nextInt();

        for (int t = 1; t <= tc; t++) {
            int[] input = new int[19];
            a = new ArrayList();
            b = new ArrayList();
            v = new int[10];
            r = new int[10];
            cnt = 0;
            a_vic = 0;
            b_vic = 0;

            for (int i = 0; i < 9; i++) {
                int tmp = sc.nextInt();
                input[tmp] = 1;
            }


            for (int i = 1; i < 19; i++) {
                if (input[i] == 0)
                    b.add(i);
                else
                    a.add(i);
            }

            for (int i = 1; i < 10; i++) {
                dfs(i, 1);
            }
            System.out.println("#" + t + " " + a_vic + " " + b_vic);
        }
    }
}
