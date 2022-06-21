import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// set needed components
		Scanner read = new Scanner(System.in);
		int A, B, C;
		int pos;
		String s;
		int min = Integer.MAX_VALUE;
		int loc = -1;
		
		// get A, B, and C
		s = read.nextLine();
		pos = s.indexOf(" ");
		A = Integer.parseInt(s.substring(0,pos));
		s = s.substring(pos + 1);
		pos = s.indexOf(" ");
		B = Integer.parseInt(s.substring(0, pos));
		C = Integer.parseInt(s.substring(pos + 1));
		read.close();
		
		// if sum is over 100
		if (A + B + C >= 100) {
			System.out.println("OK");
			return;
		}
		
		// find which one is less
		if (A < min) {
			min = A; loc = 0;
		}
		if (B < min) {
			min = B; loc = 1;
		}
		if (C < min) {
			min = C; loc = 2;
		}
		
		// display answer
		if (loc == 0) {
			System.out.println("Soongsil");
		}else if (loc == 1) {
			System.out.println("Korea");
		}else {
			System.out.println("Hanyang");
		}
		return;
	}

}
