import java.util.Scanner;

public class Main {
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        final int A = sc.nextInt();
        final int B = sc.nextInt();
        final int C = sc.nextInt();

        final String result = (A * B * C) + " ";

        final int beforeLength = result.length();

        for (int i = 0; i <= 9; i++) {
            int afterLength = result.replaceAll(i + "", "").length();
            int iCount = beforeLength - afterLength;
            System.out.println(iCount);
        }
    }
}