import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] V = new int[201];
        for (int i = 0; i<N; i++)
            V[sc.nextInt()+100]++;
        System.out.print(V[sc.nextInt()+100]);
    }
}