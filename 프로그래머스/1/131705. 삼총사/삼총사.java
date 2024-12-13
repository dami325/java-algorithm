import java.io.IOException;
class Solution {

    private boolean[] visited;
    private int[] arr;
    private int deps = 3;
    private int result = 0;

    public int solution(int[] number) throws IOException {
        arr = number;

        visited = new boolean[arr.length];
        dfs(0,0,0);

        return result;
    }

    private void dfs(int deps, int sum, int index) {
        if (this.deps == deps) {
            if (sum == 0) {
                result++;
            }
            return;
        }

        for (int i = index; i < arr.length; i++) {
            if (!visited[i]) {
                visited[i] = true;
                dfs(deps + 1, sum + arr[i],i);
                visited[i] = false;
            }
        }

    }
}