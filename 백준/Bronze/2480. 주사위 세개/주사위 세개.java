import java.util.Scanner;
public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int dice1 = sc.nextInt();
		int dice2 = sc.nextInt();
		int dice3 = sc.nextInt();
		int money = (dice1 == dice2) && (dice1 == dice3) ? 10000+dice1*1000 :
					(dice1 == dice2) && (dice1 != dice3)? 1000+dice1*100 :
					(dice2 == dice3) && (dice1 != dice2) ? 1000+dice2*100 :
					(dice1 == dice3) && (dice1 != dice2) ? 1000+dice1*100 :
					(dice1 > dice2) && (dice1 > dice3) ? dice1*100 :
					(dice2 > dice1) && (dice2 > dice3) ? dice2*100 :
					(dice3 > dice1) && (dice3 > dice2) ? dice3*100 : 0;
		System.out.println(money);
	}
}
