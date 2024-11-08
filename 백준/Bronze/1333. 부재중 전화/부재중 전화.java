import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int song = Integer.parseInt(st.nextToken());
        int bell = Integer.parseInt(st.nextToken());

        int time = 0;
        int delay = 5;

        for (int i = 0; i < n; i++) {
            time += song;
            for (int j = 0; j < delay; j++) {
                if (time % bell == 0) {
                    System.out.println(time);
                    return;
                }
                time++;
            }
        }

        while (time % bell != 0) {
            time++;
        }
        System.out.println(time);
    }
}