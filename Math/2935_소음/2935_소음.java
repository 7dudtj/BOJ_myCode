import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// set needed components
		Scanner read = new Scanner(System.in);
		String A, B, oper;
		int Alen, Blen, i;
		
		// get A, B, and operator
		A = read.nextLine();
		oper = read.nextLine();
		B = read.nextLine();
		Alen = A.length();
		Blen = B.length();
		
		// do process
		if (oper.equals("*")) {
			System.out.print(1);
			for (i = 0; i < Alen + Blen - 2; i++) System.out.print(0);
		}else if (oper.equals("+")) {
			if (Alen == Blen) {
				System.out.print(2);
				for (i = 0; i < Alen - 1; i++) System.out.print(0);
			}else if (Alen > Blen) {
				System.out.print(1);
				for (i = 0; i < Alen - Blen - 1; i++) System.out.print(0);
				System.out.print(1);
				for (i = 0; i < Blen - 1; i++) System.out.print(0);
			}else {
				System.out.print(1);
				for (i = 0; i < Blen - Alen - 1; i++) System.out.print(0);
				System.out.print(1);
				for (i = 0; i < Alen - 1; i++) System.out.print(0);
			}
		}
		
	}

}
