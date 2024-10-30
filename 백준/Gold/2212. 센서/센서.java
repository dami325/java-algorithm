import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int k = Integer.parseInt(br.readLine());
        if (k >= n) {
            System.out.println(0);
            return;
        }
        List<Integer> arr = new ArrayList<>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr.add(Integer.parseInt(st.nextToken()));
        }

        Collections.sort(arr);

        for (int i = 0; i < n-1; i++) {
            int element = arr.get(i + 1) - arr.get(i);
            arr.set(i, element);
        }
        int size = arr.size();

        int sum = 0;

        Collections.sort(arr,Comparator.reverseOrder());

        for (int i = k; i < size; i++) {
            sum += arr.get(i);
        }

        System.out.println(sum);
    }
}