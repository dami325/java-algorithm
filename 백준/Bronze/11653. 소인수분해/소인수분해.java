import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        if(N == 1) return;

        int dv = 2;
        while (true) {
            if(N <= dv) {
                System.out.println(N);
                break;
            }
            else if(N % dv == 0) {
                System.out.println(dv);
                N /= dv;
            }
            else if(N % dv != 0) {
                dv++;
            }
        }
    }
}