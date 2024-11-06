import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    private static int[] parent;
    private static PriorityQueue<Internet> queue = new PriorityQueue<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());

        parent = new int[n + 1];

        for (int i = 0; i <= n; i++) {
            parent[i] = i;
        }

        StringTokenizer st = null;

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            queue.add(new Internet(a, b, weight));
        }


        int result = 0;
        while (!queue.isEmpty()) {
            Internet poll = queue.poll();
            int a = poll.a;
            int b = poll.b;
            int weight = poll.weight;

            int min = Math.min(a, b);
            int max = Math.max(a, b);
            if (!isSameGroup(min, max)) {
                union(min, max);
                result += weight;
            }
        }

        System.out.println(result);


    }

    private static class Internet implements Comparable<Internet>{
        int a;
        int b;
        int weight;

        public Internet(int a, int b, int weight) {
            this.a = a;
            this.b = b;
            this.weight = weight;
        }

        @Override
        public int compareTo(Internet o2) {
            return this.weight - o2.weight;
        }
    }

    private static int find(int n) {
        if (n == parent[n]) {
            return n;
        }
        return parent[n] = find(parent[n]);
    }
    private static void union(int a, int b) {
        int findA = find(a);
        int findB = find(b);
        if (findA != findB) {
            parent[findB] = findA;
        }
    }

    private static boolean isSameGroup(int a, int b) {
        a = find(a);
        b = find(b);
        return a == b;
    }
}