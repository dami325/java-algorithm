import java.util.Arrays;
class Solution {

    int[] unionFind;

    public int solution(int n, int[][] costs) {
      int answer = 0;
      Arrays.sort(costs, (o1, o2) -> {
        return o1[2] - o2[2];
      });

      unionFind = new int[n];

      for (int i = 0; i < n; i++) {
        unionFind[i] = i;
      }

      for (int[] cost : costs) {
        if (find(cost[0]) != find(cost[1])) {
          union(Math.min(cost[0], cost[1]), Math.max(cost[0], cost[1]));
          answer += cost[2];
        }
        ;
      }

      return answer;
    }

    private int find(int a) {
      if (a == unionFind[a]) {
        return a;
      } else {
        return unionFind[a] = find(unionFind[a]);
      }
    }

    private void union(int a, int b) {
      a = find(a);
      b = find(b);
      if (a != b) {
        unionFind[b] = a;
      }
    }
  }