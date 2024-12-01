import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String str = sc.nextLine();

        int[] cards = new int[10];

        for (int i = 0; i < str.length(); i++) {

            int n = Integer.parseInt(String.valueOf(str.charAt(i)));

            if (n == 6 || n == 9) {
                if (cards[6] <= cards[9]) {
                    cards[6]++;
                }else {
                    cards[9]++;
                }
            }else {

                cards[n]++;
            }
        }

        int max = 0;
        for (int card : cards) {
            max = Math.max(max, card);
        }

        System.out.println(max);
    }
}
