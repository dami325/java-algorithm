import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {

    private static boolean[][] visited;
    private static int[][] maps;
    private static int totalGroup, queueCount,n;
    private static List<Integer> resultList = new ArrayList<>();
    private static ArrayDeque<int[]> queue = new ArrayDeque<>();
    private static int[] dx = {0, 0, 1, -1};
    private static int[] dy = {1, -1, 0, 0};
    public static void main(String[] args) throws IOException {
        /**
         * 1은 집이 있는 곳을, 0은 집이 없는 곳을 나타낸다.
         * 우, 혹은 아래위로 다른 집이 있는 경우 대각선 x
         *
         *  1. 지도의 크기 N 입력받는다
         *
         *  2. N개의 줄에 각각 0 또는 1을 2차원 배열에 저장한다.
         *
         *  3. 단지 수와 각 그룹의 노드수를 오름차순으로 정렬하여 한줄에 하나씩 출력한다.
         *
         *  제한시간 1초
         *  배열 최대 크기 25 X 25 = 625
         *
         *
         *  풀이
         *  2차원 처음부터 배열 돌면서 1을 만났을경우 totalGroup++
         *  큐에 넣고 BFS. 상하좌우 인덱스 범위에 1이 있으면
         *  큐에 넣고 BFS 반복 BFS 끝나면 다시 배열 순회
         *  큐에 데이터를 넣을때마다 집의 개수 count++
         *  bfs 끝날때 집 개수 List에 넣기
         *  List 오름차순 정렬
         *  totalGroup 출력
         *  List 순차적으로 출력
         */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());

        maps = new int[n][n];
        visited = new boolean[n][n];

        for (int i = 0; i < n; i++) {
            String line = br.readLine();
            for (int j = 0; j < n; j++) {
                maps[i][j] = line.charAt(j) - '0';
            }
        }

        for (int x = 0; x < n; x++) {
            for (int y = 0; y < n; y++) {
                if (maps[x][y] == 1 && !visited[x][y]) {
                    bfs(x,y);
                }
            }
        }

        StringBuilder sb = new StringBuilder();

        Collections.sort(resultList);

        sb.append(totalGroup).append("\n");
        resultList.forEach(r -> sb.append(r).append("\n"));

        System.out.println(sb.toString());
    }

    private static void bfs(int x, int y) {
        visited[x][y] = true;
        totalGroup++;

        queue.add(new int[] {x,y});
        queueCount++;

        while (!queue.isEmpty()) {
            int[] arr = queue.poll();

            for (int k = 0; k < 4; k++) {
                int i = arr[0] + dx[k];
                int j = arr[1] + dy[k];
                if (i >= 0 && i < n && j >= 0 && j < n) {
                    if (maps[i][j] == 1 && !visited[i][j]) {
                        queue.add(new int[]{i, j});
                        queueCount++;
                        visited[i][j] = true;
                    }
                }
            }
        }
        resultList.add(queueCount);
        queueCount = 0;
    }
}