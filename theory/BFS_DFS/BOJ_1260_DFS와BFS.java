package BFS_DFS;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_1260_DFS와BFS {

    static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer tokens;
    static StringBuilder output = new StringBuilder();
    static int N, M, V;

    static List<Integer>[] graph;
    static boolean[] visited;

    public static void main(String[] args) throws Exception {

        tokens = new StringTokenizer(input.readLine());
        N = Integer.parseInt(tokens.nextToken());
        M = Integer.parseInt(tokens.nextToken());
        V = Integer.parseInt(tokens.nextToken());

        graph = new List[N + 1];

        for (int i = 1; i < graph.length; i++) {
            graph[i] = new ArrayList<Integer>();
        }

        for (int i = 0; i < M; i++) {
            tokens = new StringTokenizer(input.readLine());
            int from = Integer.parseInt(tokens.nextToken());
            int to = Integer.parseInt(tokens.nextToken());
            graph[from].add(to);
            graph[to].add(from);
        }

        for (int i = 1; i < graph.length; i++) {
            Collections.sort(graph[i]);
        }

        visited = new boolean[N + 1];

        dfs(V);
        output.append("\n");
        bfs(V);
        
        System.out.println(output);
    }

    static void dfs(int node) {
        visited[node] = true;
        output.append(node).append(" ");

        List<Integer> childs = graph[node];

        for (int i = 0; i < childs.size(); i++) {
            int child = childs.get(i);
            if (!visited[child]) {
                dfs(child);
            }
        }
    }

    static void bfs(int start) {
        
        Arrays.fill(visited, false);
        
        Queue<Integer> q = new LinkedList<>();
        q.add(start);
        
        visited[start] = true;
        
        while(!q.isEmpty()) {
            Integer front = q.poll();
            
            output.append(front).append(" ");
            
            List<Integer> childs = graph[front];
            
            for(int i = 0; i<childs.size(); i++) {
                Integer child = childs.get(i);
                if(!visited[child]) {
                    visited[child] = true;
                    q.add(child);
                }
            }
        }
    }
}












