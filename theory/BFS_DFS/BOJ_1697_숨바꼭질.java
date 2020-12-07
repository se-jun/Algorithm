package BFS_DFS;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_1697_숨바꼭질 {


    static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer tokens = null;
    static int[] visited;
    static int subin, brother;

    public static void main(String[] args) throws Exception {
        tokens = new StringTokenizer(input.readLine());

        subin = Integer.parseInt(tokens.nextToken());

        brother = Integer.parseInt(tokens.nextToken());

        visited = new int[100001];

        Move(subin);

    }

    static boolean Move(int S) {
        Queue<Integer> q = new LinkedList<>();

        q.add(S);
        visited[S] = 1;

        while (!q.isEmpty()) {
            Integer front = q.remove();

            if (front == brother) {
                System.out.println(visited[front] - 1);
                return true;
            }
            int walk_front = front + 1;

            if (walk_front <= 100000 && visited[walk_front] == 0) {
                visited[walk_front] = visited[front] + 1;
                q.add(walk_front);
            }
            int walk_back = front - 1;

            if (walk_back >= 0 && visited[walk_back] == 0) {
                visited[walk_back] = visited[front] + 1;
                q.add(walk_back);
            }
            int Teleport = front * 2;
            if (Teleport <= 100000 && visited[Teleport] == 0) {
                visited[Teleport] = visited[front] + 1;
                q.add(Teleport);
            }
        }

        return false;
    }
}
