import java.math.BigInteger;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		BigInteger A = s.nextBigInteger();
		BigInteger B = s.nextBigInteger();
		
		System.out.println(A.add(B));
		
	}

}