import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

    private static final int weight = 1;
    private static int count = 1;
    private static int n, m, r;
    private static ArrayList<Node>[] graphs;
    private static boolean[] visited;
    private static int[] result;
    private static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());

        graphs = new ArrayList[n + 1];
        result = new int[n + 1];
        visited = new boolean[n + 1];

        for (int i = 0; i <= n; i++) {
            graphs[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());

            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            graphs[start].add(new Node(end, weight));
            graphs[end].add(new Node(start, weight));
        }

        for(int i = 1; i <= n; i++) {
            graphs[i].sort((o1, o2) -> o2.end - o1.end);
        }

        dfs(r);

        for (int i = 1; i <= n; i++) {
            sb.append(result[i]).append("\n");
        }

        System.out.println(sb.toString());

    }

    private static void dfs(int index) {
        visited[index] = true;
        result[index] = count++;

        ArrayList<Node> graph = graphs[index];

        for (Node node : graph) {
            if(visited[node.end])
                continue;
            dfs(node.end);
        }
    }

    private static class Node {
        private int end;
        private int weight;

        public Node(int end, int weight) {
            this.end = end;
            this.weight = weight;
        }
    }
}