package com.ssafy.day13;

import java.util.Arrays;
import java.util.Comparator;

public class sort {
    public static void main(String[] args) {
         sort1();
//        sort2();

    }

    static void sort1() {
        String[] src = {"Hello", "Java", "is", "Very Good"};
        System.out.println("기본 : " + Arrays.toString(src));

        Arrays.sort(src, new Comparator<String>() {

            @Override
            public int compare(String o1, String o2) {
                int len1 = o1.length();
                int len2 = o2.length();
                
                return Integer.compare(len1, len2);
            }
            
        });
        
//        Arrays.sort(src, new MyStringComparator());
        System.out.println("정렬 이후 : " + Arrays.toString(src));

    }

    static void sort2() {
        Archer[] src = {new Archer(1, "홍길동"), new Archer(2, "장길산"), new Archer(2, "임꺽정")};
        System.out.println("기본 : " + Arrays.toString(src));
        Arrays.sort(src);
        System.out.println("정렬후 : " + Arrays.deepToString(src));
    }

    static class MyStringComparator implements Comparator<String> {

        @Override
        public int compare(String o1, String o2) {
            
            int len1 = o1.length();
            int len2 = o2.length();
            
            return Integer.compare(len1, len2);
        }
    }
}
