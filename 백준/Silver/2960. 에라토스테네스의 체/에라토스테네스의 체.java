import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int k = sc.nextInt();

        boolean[] delete = new boolean[n + 1];
        int count = 0;
        for (int i = 2; i <= n; i++) {
            if (!delete[i]) {
                for (int j = i; j <= n; j += i) {
                    if (!delete[j]) {
                        delete[j] = true;
                        count++;
                        if (count == k) {
                            System.out.println(j);
                            return;
                        }
                    }

                }
            }

        }

    }

}