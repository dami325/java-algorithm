import java.io.*;
import java.util.*;

public class Main {
    static int A, K, answer = Integer.MAX_VALUE;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        A = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        bfs();
    }
    static void bfs() {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{A, 0});
        boolean[] visited = new boolean[K + 1];
        visited[A] = true;
        while (!queue.isEmpty()) {
            int tmp[] = queue.poll();
            if (tmp[0] == K) {
                System.out.println(tmp[1]);
                return;
            }
            // 연산 1과 연산 2를 둘다 시행한다
            if (tmp[0] * 2 <= K) { // 연산 2
                visited[tmp[0] * 2] = true;
                queue.offer(new int[]{tmp[0] * 2, tmp[1] + 1});
            }
            if (!visited[tmp[0] + 1]) { // 연산 1, // 연산 2로 수행한 수가 연산 1보다 더 적은 연산횟수이기 때문에 이미 연산 2로 수행한 수라면 패스
                queue.offer(new int[]{tmp[0] + 1, tmp[1] + 1});
            }
        }
    }
}