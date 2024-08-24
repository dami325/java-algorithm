import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Solution {
    public String[] solution(String[][] tickets) {
        List<String> result = new ArrayList<>();
        boolean[] visited = new boolean[tickets.length];

        DFS(tickets, "ICN", "ICN", 0, result, visited);

        Collections.sort(result);

        return result.get(0).split(",");
    }

    private void DFS(String[][] tickets, String start, String sum, int depth, List<String> result, boolean[] visited) {
        if (depth == tickets.length) {
            result.add(sum);
            return;
        }

        for (int i = 0; i < tickets.length; i++) {
            String left = tickets[i][0];
            String right = tickets[i][1];
            if (left.equals(start) && !visited[i]) {
                visited[i] = true;
                DFS(tickets, right, sum + "," + right,depth + 1,result,visited);
                visited[i] = false;
            }
        }

    }
}