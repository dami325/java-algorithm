import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {

            StringBuilder sb = new StringBuilder();

            while (true) {
                String line = br.readLine();

                if (line.equals("# 0 0")) break;

                String[] split = line.split(" ");

                sb.append(split[0]);
                sb.append(" ");

                if (Integer.parseInt(split[1]) > 17 || Integer.parseInt(split[2]) >= 80) {
                    sb.append("Senior");
                } else {
                    sb.append("Junior");
                }
                System.out.println(sb);
                sb.setLength(0);

            }

        } catch (IOException e) {

        }

    }
}