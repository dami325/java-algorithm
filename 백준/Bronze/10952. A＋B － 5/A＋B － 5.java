import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
             BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))) {

            while (true) {

                String line = br.readLine();

                StringTokenizer st = new StringTokenizer(line);

                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());

                if (a + b == 0) break;

                bw.write(String.valueOf(a + b));
                bw.newLine();
            }

        }
    }
}