package Day1204;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.StringTokenizer;

public class SWEA_숫자만들기 {
    static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer tokens = null;
    static StringBuilder output = new StringBuilder();
    static int Testcase, max, min, N, sum;
    static char[] sign;
    static int[] nums;
    static HashSet<String> set = new HashSet<>();

    public static void main(String[] args) throws Exception {

        Testcase = Integer.parseInt(input.readLine());

        for (int t = 1; t <= Testcase; t++) {
            N = Integer.parseInt(input.readLine());

            tokens = new StringTokenizer(input.readLine());

            int plus, minus, mul, div;

            plus = Integer.parseInt(tokens.nextToken());
            minus = Integer.parseInt(tokens.nextToken());
            mul = Integer.parseInt(tokens.nextToken());
            div = Integer.parseInt(tokens.nextToken());

            sum = plus + minus + mul + div;

            sign = new char[sum];

            int idx = 0;

            while (true) {
                if (plus + minus + mul + div == 0) {
                    break;
                }
                if (plus != 0) {
                    plus--;
                    sign[idx] = '+';
                } else if (minus != 0) {
                    minus--;
                    sign[idx] = '-';
                } else if (mul != 0) {
                    mul--;
                    sign[idx] = '*';
                } else if (div != 0) {
                    div--;
                    sign[idx] = '/';
                }
                idx++;
            }

            tokens = new StringTokenizer(input.readLine());
            
            nums = new int[N];
            
            for(int i = 0; i<N; i++) {
                nums[i] = Integer.parseInt(tokens.nextToken());
            }
            max = Integer.MIN_VALUE;
            min = Integer.MAX_VALUE;
            
            permutation(0, new char[sum], new boolean[sum]);

            output.append("#").append(t).append(" ").append(max - min).append("\n");

        }
        System.out.println(output);
    }

    static void permutation(int start, char[] tmp, boolean[] isvisited) {
        if (start == sum) {
            calculate(tmp);
//            System.out.println(Arrays.toString(tmp));
            return;
        }
        char prev = '0';
        for (int i = 0; i < sum; i++) {
            char num = sign[i];

            if (!isvisited[i]) {
                if (prev != num) {
                    prev = num;
                    isvisited[i] = true;
                    tmp[start] = sign[i];
                    permutation(start + 1, tmp, isvisited);
                    isvisited[i] = false;
                }
            }
        }
    }

    static void calculate(char[] tmp) {
        int val = nums[0];
        int sign_idx = 0;
        int num_idx = 1;
        
        while(true) {
            if(num_idx == N) {
                break;
            }
            if(tmp[sign_idx] == '+') {
                val += nums[num_idx];
            }else if(tmp[sign_idx] == '-'){
                val -= nums[num_idx];
            }else if(tmp[sign_idx] == '*'){
                val *= nums[num_idx];
            }else if(tmp[sign_idx] == '/'){
                val =  (int)(val/nums[num_idx]);
            }
            num_idx++;
            sign_idx++;
        }

        if (max < val) {
            max = val;
        }
        if (min > val) {
            min = val;
        }
//        System.out.println(max + " " + min);
    }
}
