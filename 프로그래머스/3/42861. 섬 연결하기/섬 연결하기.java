import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Queue;
class Solution {

    private ArrayList<Node>[] graph;
    private boolean[] visited;
    private int n, answer, count;

    public int solution(int n, int[][] costs) {
        this.answer = 0;
        this.n = n;
        this.graph = new ArrayList[n];
        this.visited = new boolean[n];

        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < costs.length; i++) {
            int start = costs[i][0];
            int end = costs[i][1];
            int cost = costs[i][2];

            graph[start].add(new Node(end, cost));
            graph[end].add(new Node(start, cost));
        }

        bfs();

        return this.answer;
    }

    private void bfs() {
        Queue<Node> nodes = new PriorityQueue<>(
                (n1, n2) -> {
                    return n1.cost - n2.cost;
                }
        );
        for (Node node : graph[0]) {
            nodes.offer(node);
        }

        visited[0] = true;

        while (!nodes.isEmpty()) {
            Node node = nodes.poll();
            if (visited[node.end]) {
                continue;
            }
            visited[node.end] = true;
            answer += node.cost;
            for (Node n : graph[node.end]) {
                nodes.offer(n);
            }
        }

    }

    class Node {
        int end;
        int cost;

        public Node(int end, int cost) {
            this.end = end;
            this.cost = cost;
        }
    }
}