import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        /**
         * 첫 줄에 테스트케이스의 개수 T가 주어진다. T는 최대 1,000,000이다. 다음 T줄에는 각각 두 정수 A와 B가 주어진다. A와 B는 1 이상, 1,000 이하이다.
         */

        try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))) {

            int T = Integer.parseInt(br.readLine());


            for (int i = 0; i < T; i++) {
                String line = br.readLine();
                StringTokenizer st = new StringTokenizer(line);
                bw.write(String.valueOf(Integer.parseInt(st.nextToken()) + Integer.parseInt(st.nextToken())));
                bw.newLine();
            }

        }
    }
}