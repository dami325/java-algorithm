import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        Queue<Integer> queue = new ArrayDeque<>();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        for (int i = 1; i <= n; i++) {
            queue.add(i);
        }

        StringBuilder sb = new StringBuilder("<");

        while (!queue.isEmpty()) {
            for (int i = 1; i < k; i++) {
                queue.add(queue.poll());
            }
            sb.append(", ").append(queue.poll());
        }
        sb.append(">");

        String result = sb.toString().replaceFirst(", ", "");

        System.out.println(result);

    }
}