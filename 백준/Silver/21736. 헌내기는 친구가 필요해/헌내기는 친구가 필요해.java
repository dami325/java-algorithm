import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

  private static boolean[][] visited;
  private static char[][] street;
  private static int n,m;
  private static int result;
  private static int[] dx = {0, 0, 1, -1};
  private static int[] dy = {-1, 1, 0, 0};
  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    n = Integer.parseInt(st.nextToken());
    m = Integer.parseInt(st.nextToken());

    street = new char[n][m];
    visited = new boolean[n][m];

    int x = 0;
    int y = 0;

    for (int i = 0; i < n; i++) {
      String line = br.readLine();
      for (int j = 0; j < m; j++) {
        char c = line.charAt(j);
        street[i][j] = c;
        if (c == 'I') {
          x = i;
          y = j;
        }
      }
    }

    visited[x][y] = true;
    dfs(x, y);

    System.out.println(result > 0 ? result : "TT");
  }

  private static void dfs(int x, int y) {
    for (int i = 0; i < 4; i++) {
      int xx = dx[i] + x;
      int yy = dy[i] + y;
      if (xx >= 0 && xx < n && yy >= 0 && yy < m && !visited[xx][yy] && street[xx][yy] != 'X') {
        visited[xx][yy] = true;
        if (street[xx][yy] == 'P') {
          result++;
        }
        dfs(xx, yy);
      }
    }
  }

}