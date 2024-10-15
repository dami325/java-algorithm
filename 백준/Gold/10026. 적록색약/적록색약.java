import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.List;

public class Main {

    /**
     * NXN 배열
     * R빨 G초 B파
     * 구역은 같은색(인접 상하좌우)
     * 적록 색약인사람은 RG도 같은 구역
     * <p>
     * 입력
     * 첫째줄 N 5
     * 둘째줄 ~ N줄 그림 RRRBB
     * <p>
     * 출력
     * 적록색약이 아닌 사람 구역 + " " + 적록색약인 사람 구역
     * <p>
     * 풀이
     * <p>
     * 알고리즘 선택
     * bfs
     * <p>
     * 1. 초기화
     * queue 초기화
     * 상하좌우 배열 dx, dy 초기화
     * n 초기화
     * n x n 2차원 방문 배열 초기화
     * n x n 2차원 배열 초기화
     * 일반인용 count
     * 색약용 count
     * <p>
     * 2. 구현
     * 2차원배열 0,0 부터 탐색
     * 일반인용 bfs(x,y)
     * 색약용 bfs(x,y)
     * <p>
     * <p>
     * 3. 출력
     * 일반인용count + " " + 색약용count
     */

    private static ArrayDeque<int[]> queue = new ArrayDeque<>();
    private static int count, blindnessCount, n;
    private static int[] dx = {0, 0, 1, -1};
    private static int[] dy = {1, -1, 0, 0};
    private static int UP_DOWN_LEFT_RIGHT = 4;
    private static char[][] boards;
    private static boolean[][] visited, blindVisited;
    private static List<Character> blindness = List.of('R', 'G');

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());

        boards = new char[n][n];
        visited = new boolean[n][n];
        blindVisited = new boolean[n][n];

        for (int i = 0; i < n; i++) {
            boards[i] = br.readLine().toCharArray();
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (!visited[i][j]) {
                    bfs(i, j);
                }
                if (!blindVisited[i][j]) {
                    blindnessBfs(i, j);
                }
            }
        }

        System.out.println(count + " " + blindnessCount);
    }

    private static void blindnessBfs(int i, int j) {
        blindnessCount++;
        queue.add(new int[]{i, j});
        blindVisited[i][j] = true;

        while (!queue.isEmpty()) {
            int[] point = queue.poll();
            for (int k = 0; k < UP_DOWN_LEFT_RIGHT; k++) {
                int x = point[0] + dx[k];
                int y = point[1] + dy[k];
                if (x >= 0 && y >= 0 && x < n && y < n && !blindVisited[x][y]) {
                    char next = boards[x][y];
                    char before = boards[point[0]][point[1]];
                    if (next == before || (blindness.contains(next) && blindness.contains(before))) {
                        queue.add(new int[]{x, y});
                        blindVisited[x][y] = true;
                    }
                }
            }
        }
    }

    private static void bfs(int i, int j) {
        count++;
        queue.add(new int[]{i, j});
        visited[i][j] = true;

        while (!queue.isEmpty()) {
            int[] point = queue.poll();
            for (int k = 0; k < UP_DOWN_LEFT_RIGHT; k++) {
                int x = point[0] + dx[k];
                int y = point[1] + dy[k];
                if (x >= 0 && y >= 0 && x < n && y < n && !visited[x][y] && boards[x][y] == boards[point[0]][point[1]]) {
                    queue.add(new int[]{x, y});
                    visited[x][y] = true;
                }
            }
        }
    }

}