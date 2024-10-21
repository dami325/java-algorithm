import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 임의의 두 사람이 최소 몇 단계 만에 이어질 수 있는지 계산
 * <p>
 * 전혀 상관없을 것 같은 인하대학교의 이강호와 서강대학교의 민세희는 몇 단계 ?
 * 천민호는 이강호와 같은 학교
 * 천민호와 최백준은 Baekjoon Online Judge를 통해 알게 되었다.
 * 최백준과 김선영은 같이 Startlink를 창업
 * 김선영과 김도현은 같은 학교 동아리
 * 김도현과 민세희는 같은 학교
 * 이강호-천민호-최백준-김선영-김도현-민세희 와 같이 5단계
 * <p>
 * 이강호 -> 천민호 -> 최백준 -> 김선영 -> 김도현 -> 민세희
 * <p>
 * 케빈 베이컨 => 단계의 총 합이 가장 적은 사람
 * 케빈 베이컨 수 => 모든 사람과 케빈 베이컨 게임을 했을 때, 나오는 단계의 합이다.
 * <p>
 * 입력
 * BOJ 유저의 수와 친구 관계
 * <p>
 * 출력
 * 케빈 베이컨의 수가 가장 작은 사람
 */
public class Main {

    private static int N, M;
    private static ArrayDeque<Integer> queue = new ArrayDeque();
    private static ArrayList<Integer>[] graph;
    private static boolean[] visited;
    private static int[] results;
    private static int name = 101;
    private static int result = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        visited = new boolean[N + 1];
        results = new int[N + 1];
        graph = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            graph[start].add(end);
            graph[end].add(start);
        }

        for (int i = 1; i <= N; i++) {
            Arrays.fill(results, 200);
            results[0] = 0;
            bfs(i);
            Arrays.fill(visited, false);
        }

        System.out.println(name);
    }

    private static void bfs(int index) {
        visited[index] = true;
        for (Integer integer : graph[index]) {
            results[integer] = 1;
            queue.add(integer);
        }
        while (!queue.isEmpty()) {
            Integer poll = queue.poll();
            if (!visited[poll]) {
                visited[poll] = true;
                for (Integer integer : graph[poll]) {
                    queue.add(integer);
                    results[integer] = Math.min(results[poll] + 1, results[integer]);
                }
            }
        }

        int sum = Arrays.stream(results).sum();

        if (result > sum) {
            name = index;
            result = sum;
        } else if (result == sum) {
            if (name > index) {
                name = index;
                result = sum;
            }
        }
    }

}