package com.ssafy.mystudy;

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

        makeSet(n);
        
        for (int i = 1; i <= M; i++) {

            tokens = new StringTokenizer(input.readLine());

            a = Integer.parseInt(tokens.nextToken());
            b = Integer.parseInt(tokens.nextToken());

            Union(a, b);
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
        repres = new int[size + 1];
        for (int i = 1; i < repres.length; i++) {
            repres[i] = i;
        }
    }

    static int findSet(int a) {
        if (repres[a] == a) {
            return a;
        } else {
            return repres[a] = findSet(repres[a]);
        }
    }

    static void union(int a, int b) {
        a = findSet(a);
        b = findSet(b);

        if (a != b) {
            repres[b] = a;
        }
    }


