import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

class Solution {

    private int result,n;
    private Set<Integer> visited = new HashSet<>();
    private Stack<Integer> stack = new Stack<>();
    private int[][] computers;
    private HashSet<Integer>[] graph;
    public int solution(int n, int[][] computers) {
      this.computers = computers;
      this.n = n;
      this.graph = new HashSet[n];

      for (int i = 0; i < n; i++) {
        graph[i] = new HashSet<>();
      }

      for (int i = 0; i < n; i++) {
        for (int j = 0; j < n; j++) {
          if (i != j && computers[i][j] == 1) {
            graph[i].add(j);
            graph[j].add(i);
          }
        }
      }

      for (int i = 0; i < n; i++) {
        if (!visited.contains(i)) {
          result++;
          dfs(i);
        }
      }

      return result;
    }

    private void dfs(int index) {
      stack.push(index);

      while (!stack.isEmpty()) {
        Integer node = stack.pop();

        if (!visited.contains(node)) {
          visited.add(node);
          HashSet<Integer> edgeSet = graph[node];
          for (Integer edge : edgeSet) {
            if (!visited.contains(edge)) {
              stack.push(edge);
            }
          }
        }
      }
    }
  }