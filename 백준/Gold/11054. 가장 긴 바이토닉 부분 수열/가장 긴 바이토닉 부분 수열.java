import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    /**
     * right 와 left 따로 수열 dp 저장 한다면
     * 특정 인덱스의 바이토닉 수열의 길이를 구하는공식은
     * right와 left에서 자신보다 낮은 수면서 가장 높은값을 가진 dp값을 둘다 더하고 + 1 해주면 될듯
     */

    private static int[] right, left, arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        right = new int[n];
        left = new int[n];
        arr = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        right[n - 1] = 1;
        for (int i = n - 2; i >= 0; i--) {
            int max = 0;
            for (int j = i + 1; j < n; j++) {
                if (arr[i] > arr[j]) {
                    max = Math.max(right[j], max);
                }
            }
            right[i] = max + 1;
        }

        left[0] = 1;

        for (int i = 1; i < n; i++) {
            int max = 0;
            for (int j = i - 1; j >= 0; j--) {
                if (arr[i] > arr[j]) {
                    max = Math.max(left[j], max);
                }
            }
            left[i] = max + 1;
        }

        int result = 0;
        for (int i = 0; i < n; i++) {
            result = Math.max(left[i] + right[i] - 1, result);
        }

        System.out.println(result);
    }
}