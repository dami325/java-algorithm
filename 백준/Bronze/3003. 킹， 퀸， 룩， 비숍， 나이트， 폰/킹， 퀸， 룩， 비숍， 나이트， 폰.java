import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] predefinedValues = {1, 1, 2, 2, 2, 8};
        int[] number = new int[6];


        for (int i = 0; i < predefinedValues.length; i++) {
            number[i] = sc.nextInt();
            number[i] = (predefinedValues[i] != number[i]) ? predefinedValues[i] - number[i] : 0;
            System.out.print(number[i] + " ");
        }

    }

}