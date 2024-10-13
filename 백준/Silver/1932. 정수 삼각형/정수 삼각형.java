import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        long[][] arr = new long[n][n];
        long[][] dp = new long[n][n];

        for (int i = 0; i < n; i++) {
            String[] strArr = br.readLine().split(" ");
            for (int j = 0; j < strArr.length; j++) {
                long value = Long.parseLong(strArr[j]);
                arr[i][j] = value;
            }
        }
        // 예외처리
        if(n == 1) {
            System.out.println(arr[0][0]);
            return;
        }

        // dp 기본값 세팅 바텀업 방식 = 작은 문제부터
        dp[0][0] = arr[0][0];
        dp[1][0] = dp[0][0] + arr[1][0];
        dp[1][1] = dp[0][0] + arr[1][1];

        for (int i = 2; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                if(j == 0) {
                    dp[i][j] = dp[i-1][j] + arr[i][j];
                } else if (j == arr[i].length - 1) {
                    dp[i][j] = dp[i-1][j-1] + arr[i][j];
                } else {
                    dp[i][j] = Math.max(dp[i-1][j-1],dp[i-1][j]) + arr[i][j];
                }
            }
        }

        // 점화식 구해보기
        //dp[3][0] = dp[2][0] + arr[3][0]
        //dp[3][1] = Math.max(dp[2][0], dp[2][1]) + arr[3][1]
        //dp[i][j] = Math.max(dp[i-1][j-1],dp[i-1][j]) + arr[i][j]
        //dp[3][2] = Math.amx(dp[2][1], dp[2][2]) + arr[3][2]
        //dp[i][j] = Math.max(dp[i-1][j-1],dp[i-1][j]) + arr[3][2]
        //dp[3][3] = dp[2][2] + arr[3][3];

        long result = 0;
        for (int i = 0; i < dp[n - 1].length; i++) {
            result = Math.max(dp[n-1][i], result);
        }

        System.out.println(result);
    }
}