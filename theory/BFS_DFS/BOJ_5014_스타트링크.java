package BFS_DFS;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_5014_스타트링크 {

    static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer tokens = null;
    static int F, S, G, U, D;
    static int[] visited;


    public static void main(String[] args) throws Exception {
        tokens = new StringTokenizer(input.readLine());

        F = Integer.parseInt(tokens.nextToken());
        S = Integer.parseInt(tokens.nextToken());
        G = Integer.parseInt(tokens.nextToken());
        U = Integer.parseInt(tokens.nextToken());
        D = Integer.parseInt(tokens.nextToken());

        visited = new int[F+1];

        if (!Elevator(S)) {
            System.out.println("use the stairs");
        }
    }

    static boolean Elevator(int S) {
        Queue<Integer> q = new LinkedList<>();
                
        q.add(S);
        visited[S] = 1;
        
        while(!q.isEmpty()) {
            Integer front = q.remove();
            
            if(front == G)
            {
                System.out.println(visited[front]-1);
                return true;
            }
            int Up = front+U;
            
            if(Up <= F && visited[Up]==0) {
                visited[Up] = visited[front]+1;
                q.add(Up);
            }
            int Down = front-D;
            if(Down >=1 && visited[Down] == 0) {
                visited[Down] = visited[front]+1;
                q.add(Down);
            }
        }

        return false;
    }

}
