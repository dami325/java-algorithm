import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    private static int n;
    private static StringBuilder sb = new StringBuilder();
    private static ArrayList<Integer>[] graph;
    private static boolean[] visited;
    private static int[][] result;
    private static ArrayDeque<Integer> queue = new ArrayDeque();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        visited = new boolean[n];
        result = new int[n][n];
        graph = new ArrayList[n];

        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }

        StringTokenizer st = null;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                int v = Integer.parseInt(st.nextToken());
                if (v == 1) {
                    graph[i].add(j);
                }
            }
        }


        for (int i = 0; i < n; i++) {
            bfs(i);
        }

        for (int[] arr : result) {
            for (int n : arr) {
                sb.append(n).append(" ");
            }
            sb.append("\n");
        }

        System.out.println(sb.toString());
    }

    private static void bfs(int n) {
        Arrays.fill(visited,false);

        for (Integer node : graph[n]) {
            if (!visited[node]) {
                queue.add(node);
                visited[node] = true;
            }
        }

        while (!queue.isEmpty()) {
            Integer node = queue.poll();
            result[n][node] = 1;
            visited[node] = true;
            for (Integer node2 : graph[node]) {
                if (!visited[node2]) {
                    queue.add(node2);
                    visited[node2] = true;
                }
            }
        }

    }
}