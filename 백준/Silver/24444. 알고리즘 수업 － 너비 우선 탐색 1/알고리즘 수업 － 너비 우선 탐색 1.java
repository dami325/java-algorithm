import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    /**
     * 방향이 없는 그래프가 주어짐
     * 번호 1 ~ N 가중치 1
     * 노드의 방문 순서 출력
     * 오름차순 방문
     */
    static ArrayList<Integer>[] graph;
    static boolean[] visited;
    static int[] resultArr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int nodeCount = Integer.parseInt(st.nextToken());
        int lineCount = Integer.parseInt(st.nextToken());
        int startIndex = Integer.parseInt(st.nextToken());

        graph = new ArrayList[nodeCount + 1];
        visited = new boolean[nodeCount + 1];
        resultArr = new int[nodeCount + 1];

        for (int i = 1; i <= nodeCount; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < lineCount; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            graph[start].add(end);
            graph[end].add(start);
        }

        for (int i = 1; i <= nodeCount; i++) {
            Collections.sort(graph[i]);
        }

        BFS(startIndex);

        for (int i = 1; i <= nodeCount; i++) {
            System.out.println(resultArr[i]);
        }
    }

    private static void BFS(int startIndex) {
        int weight = 1;
        ArrayDeque<Integer> nodes = new ArrayDeque<>();
        visited[startIndex] = true;
        resultArr[startIndex] = weight++;

        for (Integer next : graph[startIndex]) {
            visited[next] = true;
            nodes.add(next);
        }

        while (!nodes.isEmpty()) {
            Integer next = nodes.poll();
            resultArr[next] = weight++;
            for (Integer nextNode : graph[next]) {
                if (!visited[nextNode]) {
                    visited[nextNode] = true;
                    nodes.add(nextNode);
                }
            }
        }
    }
}