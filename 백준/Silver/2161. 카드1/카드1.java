import java.io.IOException;
import java.util.LinkedList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        LinkedList<Integer> queue = new LinkedList<>();

        int n = sc.nextInt();
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= n; i++) {
            queue.add(i);
        }

        while (!(queue.size() <= 1)) {

            sb.append(queue.poll()).append(" ");

            queue.add(queue.poll());
        }

        sb.append(queue.poll());

        System.out.println(sb.toString());

    }
}