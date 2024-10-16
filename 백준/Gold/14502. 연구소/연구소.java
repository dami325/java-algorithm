import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

    private static int n,m,result;
    private static int[][] maps;
    private static boolean[][] visited;
    private static int[] dx = {0,0,1,-1};
    private static int[] dy = {1,-1,0,0};
    private static ArrayDeque<int[]> queue = new ArrayDeque<>();
    private static ArrayList<int[]> viruses = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        maps = new int[n][m];
        visited = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                int value = Integer.parseInt(st.nextToken());
                maps[i][j] = value;
                if (value == 2) {
                    int[] virus = {i, j};
                    viruses.add(virus);
                }
            }
        }

        dfs(0,0,0);

        System.out.println(result);

    }

    private static void dfs(int x, int y, int depth) {
        if (depth == 3) {
            result = Math.max(bfs(), result);
            return;
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (maps[i][j] == 0) {
                    maps[i][j] = -1;
                    dfs(i, j, depth + 1);
                    maps[i][j] = 0;
                }
            }
        }
    }

    /**
     * 안전지대 세는 bfs 정의
     */
    private static int bfs() {
        queue.addAll(viruses);
        boolean[][] visited = new boolean[n][m];

        int count = 0; // 바이러스 퍼진 개수
        while (!queue.isEmpty()) {
            int[] poll = queue.poll();
            for (int i = 0; i < 4; i++) {
                int x = poll[0] + dx[i];
                int y = poll[1] + dy[i];
                if (x >= 0 && y >= 0 && x < n && y < m && maps[x][y] == 0 && !visited[x][y]) {
                    visited[x][y] = true;
                    queue.add(new int[]{x, y});
                    count++;
                }
            }
        }

        int zeroCount = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (maps[i][j] == 0) {
                    zeroCount++;
                }
            }
        }

        return zeroCount - count; // 전체 0의 개수에 바이러스 퍼진만큼 뺴주기
    }
}