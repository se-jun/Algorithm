package _0806;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Random;

public class SortTest2 {
    public static void main(String[] args) {
        int[][] arr = new int[4][4];
        Random rand = new Random();

        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                arr[i][j] = rand.nextInt(50);
            }
        }

        for(int [] row: arr) {
            System.out.println(Arrays.toString(row));
        }
        System.out.println();

        Arrays.sort(arr, (int[] o1, int[] o2) -> {
            int sum1 = 0;
            int sum2 = 0;
            for (int i = 0; i < o1.length; i++) {
                sum1 += o1[i];
            }
            for (int i = 0; i < o2.length; i++) {
                sum2 += o2[i];
            }
            if (sum1 == sum2) {
                if (o1[0] == o2[0]) {
                    return Integer.compare(o1[o1.length - 1], o2[o2.length - 1]);
                } else {
                    return Integer.compare(o1[0], o2[0]) * -1;
                }
            } else {

                return Integer.compare(sum1, sum2);
            }

        });
        for(int [] row: arr) {
            System.out.println(Arrays.toString(row));
        }


    }

}
