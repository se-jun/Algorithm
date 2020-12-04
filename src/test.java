import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class test {
    static int[] src = {1, 2, 3, 4};

    public static void main(String[] args) {

        make_permutation(0, new int[3], new boolean[src.length]);
//        make_Combination(0, 0, new int[3]);
    }

    public static void make_permutation(int start, int[] temp, boolean[] visited) {
        if (start == 3) {
            System.out.println(Arrays.toString(temp));
            return;
        }
        for (int i = 0; i < src.length; i++) {
            if (!visited[i]) {
                visited[i] = true;
                temp[start] = src[i];
                make_permutation(start + 1, temp, visited);
                visited[i] = false;
            }
        }
    }

    public static void make_Combination(int start, int cnt, int[] temp) {
        if (cnt == 3) {
            System.out.println(Arrays.toString(temp));
            return;
        }
        for (int i = start; i < src.length; i++) {
            temp[cnt] = src[i];
            make_Combination(i + 1, cnt+1, temp);
        }
    }

    public void make_PowerSet() {
        for (int i = 0; i < (1 << src.length); i++) {
            List<Integer> list = new ArrayList<>();
            for (int j = 0; j < src.length; j++) {
                if ((i & (1 << j)) > 0) {
                    list.add(j);
                }
            }
            System.out.println(list);
        }
    }
}
