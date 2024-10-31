import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
    private static int cogCount = 4;
    private static LinkedList<Character>[] cogs = new LinkedList[cogCount + 1];
    private static boolean[] visited;
    private static ArrayList<Integer>[] graph = new ArrayList[cogCount + 1];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int i = 1; i <= cogCount; i++) {
            graph[i] = new ArrayList<>();
            cogs[i] = new LinkedList<>();
        }
        graph[1].add(2);
        graph[2].add(1);
        graph[2].add(3);
        graph[3].add(2);
        graph[3].add(4);
        graph[4].add(3);

        final int corner = 8;

        for (int i = 1; i <= cogCount; i++) {
            char[] charArray = br.readLine().toCharArray();
            for (int j = 0; j < corner; j++) {
                cogs[i].add(charArray[j]);
            }
        }

        int t = Integer.parseInt(br.readLine());

        StringTokenizer st = null;
        for (int i = 0; i < t; i++) {
            visited = new boolean[cogCount + 1];
            st = new StringTokenizer(br.readLine());
            int number = Integer.parseInt(st.nextToken());
            int direction = Integer.parseInt(st.nextToken());
            if (direction == -1) {
                reverse(number);
            } else {
                clockwise(number);
            }
        }

        int score = 0;
        score += cogs[1].get(0).equals('1') ? 1 : 0;
        score += cogs[2].get(0).equals('1') ? 2 : 0;
        score += cogs[3].get(0).equals('1') ? 4 : 0;
        score += cogs[4].get(0).equals('1') ? 8 : 0;

        System.out.println(score);
    }

    private static void reverse(int cogIndex) {
        visited[cogIndex] = true;
        LinkedList<Character> cog = cogs[cogIndex];
        for (Integer around : graph[cogIndex]) {
            if (around < cogIndex) {
                if (!cogs[around].get(2).equals(cog.get(6)) && !visited[around]) {
                    clockwise(around);
                }
                ;
            } else {
                if (!cogs[around].get(6).equals(cog.get(2)) && !visited[around]) {
                    clockwise(around);
                }
            }
        }
        cog.add(7,cog.remove(0));
    }

    private static void clockwise(int cogIndex) {
        visited[cogIndex] = true;
        LinkedList<Character> cog = cogs[cogIndex];
        for (Integer around : graph[cogIndex]) {
            if (around < cogIndex) {
                if (!cogs[around].get(2).equals(cog.get(6)) && !visited[around]) {
                    reverse(around);
                }
                ;
            } else {
                if (!cogs[around].get(6).equals(cog.get(2)) && !visited[around]) {
                    reverse(around);
                }
            }
        }
        cog.add(0,cog.remove(7));
    }

}