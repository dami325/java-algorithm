import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

    private static boolean[] visited;
    private static ArrayList<Node>[] bossNodes;
    private static int n, m;
    private static int[] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        bossNodes = new ArrayList[n + 1];
        visited = new boolean[n + 1];
        for (int i = 1; i <= n; i++) {
            bossNodes[i] = new ArrayList<>();
        }

        dp = new int[n + 1];

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            int boss = Integer.parseInt(st.nextToken());
            if (boss != -1) {
                bossNodes[boss].add(new Node(i, 0));
            }
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int dpIndex = Integer.parseInt(st.nextToken());
            int value = Integer.parseInt(st.nextToken());
            dp[dpIndex] += value;
        }

        dfs(1);

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= n; i++) {
            sb.append(dp[i] + " ");
        }

        System.out.println(sb.toString());

    }

    private static void dfs(int index) {
        if (index > n) {
            return;
        }
        if (!visited[index]) {
            visited[index] = true;
            int weight = dp[index];
            for (Node node : bossNodes[index]) {
                int next = node.end;
                dp[next] += weight;
                dfs(next);
            };
            visited[index] = false;
        }
    }

    private static class Node {
        int end;
        int weight;

        public Node(int end, int weight) {
            this.end = end;
            this.weight = weight;
        }
    }
}