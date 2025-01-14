import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		int n = scanner.nextInt();
		int [] Dp = new int[n+1];
		Dp[0]=1; // 2*1 사각형 경우의 수
		Dp[1]=3; // 2*2 사각형 경우의 수
		for(int i=2;i<n;i++) {
			Dp[i]=(Dp[i-1]+Dp[i-2]*2)%10007; 
		}
		System.out.println(Dp[n-1]); //2*n 사각형 경우의 수

	}
}