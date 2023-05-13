import java.util.Scanner;
public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int result = 0;
        if(N % 4 == 0 && (N % 100 != 0 || N % 400 == 0)){
            result = 1;
        }

        System.out.println(result);
    }
}