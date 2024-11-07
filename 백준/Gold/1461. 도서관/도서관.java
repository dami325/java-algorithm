import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    private static int n,m;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        PriorityQueue<Integer> queue = new PriorityQueue<>((o1, o2) -> {
            if (o1 > 0 && o2 > 0) {
                return o2 - o1;
            }
            return o1 - o2;
        });

        st = new StringTokenizer(br.readLine());

        while (st.hasMoreTokens()) {
            queue.add(Integer.parseInt(st.nextToken()));
        }

        int result = 0;
        int maxIndex = 0;
        while (!queue.isEmpty()) {
            int index = queue.poll();
            int abs = Math.abs(index);
            maxIndex = Math.max(abs, maxIndex);
            ifSameSignPoll(queue, index);

            result += (abs * 2);
        }

        System.out.println(result - maxIndex);
    }

    private static void ifSameSignPoll(PriorityQueue<Integer> queue, Integer index) {

        for (int i = 0; i < m - 1; i++) {
            if (queue.isEmpty()) {
                return;
            }
            if (index < 0 && queue.peek() < 0) {
                queue.poll();
            } else if (index > 0 && queue.peek() > 0) {
                queue.poll();
            }

        }
    }
}