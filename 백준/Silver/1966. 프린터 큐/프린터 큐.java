import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        LinkedList<Item> queue = new LinkedList<>();

        int t = Integer.parseInt(br.readLine());

        StringTokenizer st = null;
        while (t-- > 0) {
            st = new StringTokenizer(br.readLine());

            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                queue.add(new Item(i, Integer.parseInt(st.nextToken())));
            }

            int count = 0;
            OUTER:
            while (!queue.isEmpty()) {

                Item next = queue.pop();

                for (Item item : queue) {
                    if (next.weight < item.weight) {
                        queue.add(next);
                        continue OUTER;
                    }
                }
                count++;

                if (next.index == m) {
                    System.out.println(count);
                    break;
                }
            }
            queue.clear();
        }
    }

    static class Item{
        int index;
        int weight;

        public Item(int index, int weight) {
            this.index = index;
            this.weight = weight;
        }
    }
}