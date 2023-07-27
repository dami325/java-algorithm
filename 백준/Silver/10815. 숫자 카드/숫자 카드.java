

import java.util.HashSet;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int numCards = sc.nextInt();
        HashSet<Integer> cardSet = new HashSet<>();

        for (int i = 0; i < numCards; i++) {
            cardSet.add(sc.nextInt());
        }

        int numNumbers = sc.nextInt();

        for (int i = 0; i < numNumbers; i++) {
            int number = sc.nextInt();
            if (cardSet.contains(number)) {
                System.out.print("1 ");
            } else {
                System.out.print("0 ");
            }
        }

    }

}