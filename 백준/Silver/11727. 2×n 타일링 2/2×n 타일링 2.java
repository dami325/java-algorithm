import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 길이 2의 직사각형을 3가지( 1, 2, 2)의 타일로 채우는 방법의 수..
 * 2x1     2x2     2x3     2x4    2x5    2x6     2x7     2x8
 * dp[1]=1 dp[2]=3  dp[1]+dp[2] ...
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 3;
        for (int i = 2; i < n; i++) {
            dp[i] = (dp[i - 1] + dp[i - 2] * 2) % 10007;
        }
        System.out.println(dp[n - 1]);
    }
}