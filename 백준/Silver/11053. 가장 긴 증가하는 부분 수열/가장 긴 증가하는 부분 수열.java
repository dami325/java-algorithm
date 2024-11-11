import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    private static Integer[] dp, seq;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        dp = new Integer[n];
        seq = new Integer[n];
        for (int i = 0; i < n; i++) {
            seq[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < n; i++) {
            LIS(i);
        }

        int max = 0;
        for (Integer integer : dp) {
            max = Math.max(max, integer);
        }

        System.out.println(max);

    }

    private static int LIS(int N) {
        if (dp[N] == null) {
            dp[N] = 1;

            for (int i = N - 1; i >= 0; i--) {

                if (seq[i] < seq[N]) {
                    dp[N] = Math.max(dp[N], LIS(i) + 1);
                }
            }
        }

        return dp[N];
    }
}