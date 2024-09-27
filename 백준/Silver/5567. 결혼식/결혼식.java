import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        int result = 0;

        boolean[] visited = new boolean[n + 1];
        ArrayList<Integer>[] list = new ArrayList[n + 1];
        ArrayDeque<Integer> queue = new ArrayDeque<>();

        for (int i = 1; i < n + 1; i++) {
            list[i] = new ArrayList<>();
        }

        for (int i = 1; i < m; i++) {
            String[] numbers = br.readLine().split(" ");
            int left = Integer.parseInt(numbers[0]);
            int right = Integer.parseInt(numbers[1]);

            list[left].add(right);
            list[right].add(left);
        }


        ArrayList<Integer> friendList = list[1];

        if (friendList.isEmpty()) {
            System.out.println(0);
            return;
        }

        visited[1] = true;

        for (Integer friend : friendList) {
            visited[friend] = true;
            queue.add(friend);
            result++;
        }

        while (!queue.isEmpty()) {
            Integer friend = queue.poll();
            ArrayList<Integer> friendFriends = list[friend];
            for (Integer friendFriend : friendFriends) {
                if (visited[friendFriend]) {
                    continue;
                }
                visited[friendFriend] = true;
                result++;
            }
        }

        System.out.println(result);


    }
}