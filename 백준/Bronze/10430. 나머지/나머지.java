import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
public class Main {
    public static void main(String[] args) throws IOException {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
             BufferedWriter bw = new BufferedWriter(new java.io.OutputStreamWriter(System.out));) {

            String line = br.readLine();
            StringTokenizer st = new StringTokenizer(line);
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            System.out.println((a + b) % c);
            System.out.println(((a % c) + (b % c))%c);
            System.out.println((a * b) % c);
            System.out.println(((a % c) * (b % c)) % c);
        }
    }
}