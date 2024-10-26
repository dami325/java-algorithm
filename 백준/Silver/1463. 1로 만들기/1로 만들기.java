import java.util.Scanner;

public class Main {

    private static Integer[] dp;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int x = sc.nextInt();
        dp = new Integer[x + 1];

        dp[0] = dp[1] = 0;

        System.out.println(topDown(x));
    }

    private static int topDown(int x) {

        if (dp[x] == null) {
            if (x % 6 == 0) {
                dp[x] = Math.min(topDown(x - 1), Math.min(topDown(x / 3), topDown(x / 2))) + 1;
            } else if (x % 3 == 0) {
                dp[x] = Math.min(topDown(x / 3), topDown(x - 1)) + 1;
            } else if (x % 2 == 0) {
                dp[x] = Math.min(topDown(x / 2), topDown(x - 1)) + 1;
            } else {
                dp[x] = topDown(x - 1) + 1;
            }
        }
        return dp[x];
    }
}