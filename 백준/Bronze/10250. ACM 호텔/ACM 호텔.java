import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		int H = 0;
		int W = 0;
		int N = 0;
		int count = 0;
		int[][] hotel;
		
		for(int t = 0; t < T; t++) {
			H = sc.nextInt();
			W = sc.nextInt();
			N = sc.nextInt();
		
			hotel = new int [H][W];
			
			for(int i = 0; i < H; i++) {
				for(int j = 0; j < W; j++) {
					hotel[i][j] = 101 + 100*i + j;
					
				}
			}
			
			for(int i = 0; i < W; i++) {
				for(int j = 0; j < H; j++) {
					count++;
					if(count == N) {
						System.out.println(hotel[j][i]);
						break;
					}
				}
			}
			
			
			
			count = 0;
		}
    }
}