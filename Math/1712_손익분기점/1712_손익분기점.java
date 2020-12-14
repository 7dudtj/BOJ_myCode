import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// set needed components
		Scanner read = new Scanner(System.in);
		int A, B, C;
		
		// get A, B, C
		A = read.nextInt();
		B = read.nextInt();
		C = read.nextInt();
		
		if (B >= C) {
			System.out.println(-1);
			read.close();
			return;
		}else {
			System.out.println((A / (C - B)) + 1);
			read.close();
			return;
		}
	}

}
