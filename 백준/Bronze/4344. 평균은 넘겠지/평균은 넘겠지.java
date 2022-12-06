import java.util.Scanner;
public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int C = sc.nextInt();
		int[][] arr = new int[C][];
		double[] N = new double[C];
		double num = 0;
		
		for(int i = 0; i < C; i++) {
			double total = 0;
			
			arr[i] = new int[sc.nextInt()];
			
			for(int j = 0; j < arr[i].length; j++) {
				arr[i][j] = sc.nextInt();
				total += arr[i][j];
			}
			N[i] = total/arr[i].length;
		}
		for(int i = 0; i < C; i++) {
			num = 0;
			for(int j = 0; j < arr[i].length; j++) {
				if(N[i] < arr[i][j]) {
					num += 1;
				}
			}
			N[i] = (num/arr[i].length)*100;
		}
		for(double i : N) {
			String result = String.format("%.3f",i);
			System.out.println(result+"%");
		}
	}

}