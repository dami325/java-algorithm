import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();

        StringBuilder sb = new StringBuilder();
        for (int i = str.length() - 1; i > -1; i--) {
            sb.append(str.charAt(i));
        }

        System.out.println(sb.toString().equals(str) ? "1" : "0");
    }
}