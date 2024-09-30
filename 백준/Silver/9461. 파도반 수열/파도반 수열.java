import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        // DP(N) = DP(N-2) + DP(N-3)
        Scanner sc = new Scanner(System.in);

        long[] DP = new long[101];
        DP[1] = 1;
        DP[2] = 1;
        DP[3] = 1;
        DP[4] = 2;
        DP[5] = 2;
        DP[6] = 3;
        DP[7] = 4;
        DP[8] = 5;
        DP[9] = 7;
        DP[10] = 9;

        for (int i = 11; i <= 100; i++) {
            DP[i] = DP[i - 2] + DP[i - 3];
        }

        int T = sc.nextInt();

        for (int i = 0; i < T; i++) {
            int N = sc.nextInt();
            System.out.println(DP[N]);
        }
    }
}