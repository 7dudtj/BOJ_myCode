import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// set neeeded components
		Scanner read = new Scanner(System.in);
		int answer, input, T, i;
		
		// get T
		T = read.nextInt();
		
		// do process
		for (i = 0; i < T - 1; i++) {
			input = read.nextInt();
			answer = (int)Math.pow(input / 2 + 1, 2);
			System.out.println(answer);
		}
		input = read.nextInt();
		answer = (int)Math.pow(input / 2 + 1, 2);
		System.out.print(answer);
		
		// end of program
		read.close();
		return;
	}

}
