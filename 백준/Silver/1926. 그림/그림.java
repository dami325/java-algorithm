

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class Main {

  private static int[][] board;
  private static int n,m,result, totalCount;
  private static int[] xx = {0,0,1,-1};
  private static int[] yy = {1, -1, 0, 0};
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    n = Integer.parseInt(st.nextToken());
    m = Integer.parseInt(st.nextToken());
    board = new int[n][m];

    for (int i = 0; i < n; i++) {
      st = new StringTokenizer(br.readLine());
      for (int j = 0; j < m; j++) {
        board[i][j] = Integer.parseInt(st.nextToken());
      }
    }

    for (int i = 0; i < n; i++) {
      for (int j = 0; j < m; j++) {
        if (board[i][j] == 1) {
          board[i][j] = 0;
          bfs(i, j);
        }
      }
    }

    System.out.println(result);
    System.out.println(totalCount);
  }

  private static void bfs(int nn, int mm) {
    ArrayDeque<int[]> queue = new ArrayDeque<>();
    queue.add(new int[]{nn, mm});
    result ++;
    int count = 1;

    while (!queue.isEmpty()) {
      int[] current = queue.pop();
      int x = current[0];
      int y = current[1];
      for (int i = 0; i < 4; i++) {
        int dx = x + xx[i];
        int dy = y + yy[i];
        if (dx >= 0 && dx < n && dy >= 0 && dy < m) {
          if (board[dx][dy] == 1) {
            board[dx][dy] = 0;
            count++;
            queue.add(new int[]{dx, dy});
          }
        }
      }
    }

    totalCount = Math.max(totalCount, count);
  }

}
