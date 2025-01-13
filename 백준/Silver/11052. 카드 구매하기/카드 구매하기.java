import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 카드의 N 개가 되는 최대값을 구해야함
 * 0    0   1   2   3  4(N)
 * 1(1) 0   1   2   3  4
 * 2(5) 0   1   5   6  10
 * 3(6) 0   1   5   6  7
 * 4(7)
 * <p>
 * 규칙
 * dp[2][4] = max(p[2] + dp[2][4 - 2], dp[2 - 1][4] + dp[2][4 - 2])
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] p = new int[n + 1];
        int[][] dp = new int[n + 1][n + 1];
        for (int i = 1; i <= n; i++) {
            p[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (j >= i) {
                    dp[i][j] = Math.max(p[i] + dp[i][j - i], dp[i - 1][j]);
                }else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }

        System.out.println(dp[n][n]);

    }
}