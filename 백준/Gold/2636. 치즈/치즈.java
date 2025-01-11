import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 판의 가장자리에는 치즈가 놓여 있지 않다.
 * 처음에 세팅할때 치즈 개수를 COUNT 해둔다
 * 그러면 가장자리부터 상하좌우 탐색해 가며 1을 만나면 모두 방문 처리 후 0으로 바꾼다.
 * (이 때 0으로 바꾸는 개수를 COUNT 해둔다)
 * 더이상 방문할 수 없으면 한시간 추가하고
 * 치즈개수 COUNT 와 바꾼 개수 COUNT를 비교해 같지않다면
 * 치즈개수 = 치즈개수 - 바꾼개수 (남아있는개수) 저장
 * 다시 탐색
 * 같으면 시간 추가하고
 * 시간 출력
 * 치즈 개수 출력
 */
public class Main {

    static int r, c, cheeseCount, changeCount, time;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    static String[][] arr;
    static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        arr = new String[r][c];

        for (int i = 0; i < r; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < c; j++) {
                String s = st.nextToken();
                arr[i][j] = s;
                if (s.equals("1")) {
                    cheeseCount++;
                }
            }
        }

        bfs();
        System.out.println(time);
        System.out.println(cheeseCount);
    }

    private static void bfs() {
        Queue<int[]> queue = new ArrayDeque<>();
        while (0 != cheeseCount - changeCount) {
            cheeseCount -= changeCount;
            changeCount = 0;
            time++;
            queue.add(new int[]{0, 0});
            visited = new boolean[r][c];
            while (!queue.isEmpty()) {
                int[] poll = queue.poll();
                int x = poll[0];
                int y = poll[1];
                for (int i = 0; i < 4; i++) {
                    // 상하좌우
                    int xx = dx[i] + x;
                    int yy = dy[i] + y;
                    if(0 <= xx && 0 <= yy && r > xx && c > yy && !visited[xx][yy]){
                        String value = arr[xx][yy];
                        visited[xx][yy] = true;
                        if (value.equals("1")) {
                            arr[xx][yy] = "0";
                            changeCount++;
                        }else {
                            queue.add(new int[]{xx, yy});
                        }
                    }
                }
            }
        }
    }
}