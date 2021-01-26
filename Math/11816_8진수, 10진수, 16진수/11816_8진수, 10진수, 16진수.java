import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// set needed components
		Scanner read = new Scanner(System.in);
		String input;
		int ans;
		
		// get input
		input = read.nextLine();
		read.close();
		
		// check if input is 8, 10, or 16
		if (input.substring(0,1).equals("0")) {
			// input is 16
			if (input.substring(0,2).equals("0x")) {
				input = input.substring(2);
				ans = Integer.valueOf(input, 16);
				System.out.println(ans);
			}
			// input is 8
			else {
				input = input.substring(1);
				ans = Integer.valueOf(input, 8);
				System.out.println(ans);
			}
		}
		// input is 10
		else {
			System.out.println(input);
		}
	}

}
