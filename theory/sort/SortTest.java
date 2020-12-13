package sort;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class SortTest {

    static class Edge implements Comparable<Edge> {
        int aNode;
        int bNode;
        int cost;


        public Edge(int aNode, int bNode, int cost) {
            super();
            this.aNode = aNode;
            this.bNode = bNode;
            this.cost = cost;
        }

        @Override
        public String toString() {
            return "[" + aNode + "-> " + bNode + ", cost=" + cost + "]";
        }

        @Override
        public int compareTo(Edge o) {
            if (this.cost == o.cost) {
                return Integer.compare(this.aNode, this.bNode);
            } else {
                return Integer.compare(this.cost, o.cost);
            }
        }

    }

    public static void main(String[] args) {
        List<Edge> edges = Arrays.asList(new Edge(1, 2, 3), new Edge(3, 4, 3), new Edge(1, 3, 5),
                new Edge(2, 3, 2));

        Collections.sort(edges);

        System.out.println(edges);

        Collections.sort(edges, new MyComp());

        Collections.sort(edges, new Comparator<Edge>() {
            public int compare(Edge o1, Edge o2) {
                if (o1.cost == o2.cost) {
                    return Integer.compare(o1.aNode, o2.bNode);
                } else {
                    return Integer.compare(o1.cost, o2.cost);
                }
            }
        });

        Collections.sort(edges, (Edge o1, Edge o2) -> {
            if (o1.cost == o2.cost) {
                return Integer.compare(o1.aNode, o2.bNode);
            } else {
                return Integer.compare(o1.cost, o2.cost);
            }

        });
        
        

    }

    static class MyComp implements Comparator<Edge> {

        @Override
        public int compare(Edge o1, Edge o2) {
            if (o1.cost == o2.cost) {
                return Integer.compare(o1.aNode, o2.bNode);
            } else {
                return Integer.compare(o1.cost, o2.cost);
            }
        }

    }

}
