import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int computerCount = Integer.parseInt(br.readLine());
        int lineCount = Integer.parseInt(br.readLine());

        ArrayList<Integer>[] netWorks = new ArrayList[computerCount + 1];

        for (int i = 1; i < computerCount + 1; i++) {
            netWorks[i] = new ArrayList<>();
        }

        boolean[] visited = new boolean[computerCount + 1];

        for (int i = 0; i < lineCount; i++) {
            String[] computerNumbers = br.readLine().split(" ");
            int left = Integer.parseInt(computerNumbers[0]);
            int right = Integer.parseInt(computerNumbers[1]);
            netWorks[left].add(right);
            netWorks[right].add(left);
        }

        System.out.println(dfs(netWorks, visited, 1) - 1);
    }

    private static int dfs(ArrayList<Integer>[] netWorks, boolean[] visited, int index) {
        visited[index] = true;
        int count = 1;

        ArrayList<Integer> netWork = netWorks[index];

        for (Integer computer : netWork) {
            if (!visited[computer]) {
                count += dfs(netWorks, visited, computer);
            }
        }

        return count;
    }
}