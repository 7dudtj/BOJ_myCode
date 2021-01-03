import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// set needed components
		int H, M;
		Scanner read = new Scanner(System.in);
		
		// get Hour and Minute
		H = read.nextInt();
		M = read.nextInt();
		
		// set new time
		if (M >= 45) {
			M -= 45;
			System.out.print(H + " " + M);
		}else {
			if (H != 0) {
				--H;
				M += 15;
				System.out.print(H + " " + M);
			}else {
				H = 23;
				M += 15;
				System.out.print(H + " " + M);
			}
		}
		
		// end of program
		read.close();
		return;
	}

}
