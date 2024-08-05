import java.util.HashSet;
import java.util.Set;
class Solution {

            private boolean[] visited;
            private String n;
            private int answer = 0;
            private int depth = 1;
            private Set<Integer> set = new HashSet<>();

            public int solution(String numbers) {

                n = numbers;

                visited = new boolean[n.length()];

                for (int i = 0; i < n.length(); i++) {

                    dfs(0, "");

                    depth++;

                    if (depth > n.length()) {
                        break;
                    }

                }

                return answer;
            }

            private void dfs(int depth, String str) {
                if (depth == this.depth) {
                    int number = Integer.parseInt(str);
                    isDecimal(number);
                    return;
                }

                for (int i = 0; i < n.length(); i++) {
                    if (!visited[i]) {
                        visited[i] = true;
                        dfs(depth + 1, str + n.charAt(i));
                        visited[i] = false;
                    }
                }


            }

            private void isDecimal(int number) {
                if (set.contains(number)) {
                    return;
                }
                set.add(number);

                if (number <= 1) {
                    return;
                }

                if (number <= 3) {
                    answer++;
                    return;
                }

                if (number % 2 == 0 || number % 3 == 0) {
                    return;
                }

                for (int i = 5; i * i <= number; i += 6) {
                    if (number % i == 0 || number % (i + 2) == 0) {
                        return;
                    }
                }

                answer++;

            }

        }