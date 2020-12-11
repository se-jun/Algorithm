package _0806;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class KruskalTest {

    static class Edge implements Comparable<Edge> {
        int from, to, weight;

        Edge() {};

        public Edge(int from, int to, int weight) {
            super();
            this.from = from;
            this.to = to;
            this.weight = weight;
        }

        @Override
        public int compareTo(Edge o) {
            return Integer.compare(this.weight, o.weight);
        }
    }

    static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer tokens = null;
    static int V, E;
    static Edge[] edgeList;
    static int[] parents;
    static int cnt, sum;


    public static void main(String[] args) throws Exception {

        tokens = new StringTokenizer(input.readLine());

        V = Integer.parseInt(tokens.nextToken());
        E = Integer.parseInt(tokens.nextToken());

        edgeList = new Edge[E];
        parents = new int[V];

        cnt = 0;
        sum = 0;

        int from, to, weight;

        for (int i = 0; i < E; i++) {
            tokens = new StringTokenizer(input.readLine());
            from = Integer.parseInt(tokens.nextToken());
            to = Integer.parseInt(tokens.nextToken());
            weight = Integer.parseInt(tokens.nextToken());
            edgeList[i] = new Edge(from, to, weight);
        }

        Arrays.sort(edgeList);
        
        makeSet();

        for (Edge edge : edgeList) {
            if (union(edge.from, edge.to)) {
                ++cnt;
                sum += edge.weight;
                if (cnt == V - 1) {
                    break;
                }
            }
        }
        System.out.println(sum);
    }
    static void makeSet() {
        for (int i = 1; i < V; i++) {
            parents[i] = i;
        }
    }
    static int findSet(int a) {
        if (parents[a] == a) {
            return a;
        } else {
            return parents[a] = findSet(parents[a]);
        }
    }
    static boolean union(int a, int b) {
        a = findSet(a);
        b = findSet(b);

        if (a != b) {
            parents[b] = a;
            return true;
        }
        return false;
    }
}