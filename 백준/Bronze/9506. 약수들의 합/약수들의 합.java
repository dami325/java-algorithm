import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (true) {

            int N = sc.nextInt();
            
            if(N==-1) break;

            List<Integer> arr = new ArrayList<>();
            int sum = 0;
            for (int i = 1; i < N; i++) {
                if (N % i == 0) {
                    arr.add(i);
                    sum += i;
                }
            }

            if (sum == N) {
                StringBuilder sb = new StringBuilder();
                sb.append(N);
                sb.append(" = ");
                for (int i = 0; i < arr.size(); i++) {
                    sb.append(arr.get(i));
                    if (i != arr.size() - 1)
                        sb.append(" + ");
                }
                System.out.println(sb.toString());
            }else {
                System.out.println(N + " is NOT perfect.");
            }
            
        }
    }
}