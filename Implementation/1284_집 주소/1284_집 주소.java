import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// set needed components
		Scanner read = new Scanner(System.in);
		String input;
		int len;
		
		input = read.nextLine();
		len = input.length();
		
		while (Integer.parseInt(input) != 0) {
			int answer = 0, zero = 0, one = 0, i;
			char[] list;
			
			list = input.toCharArray();
			
			// check which number is exist
			for (i = 0; i < len; i++) {
				if (list[i] == '1') one++;
				if (list[i] == '0') zero++;
			}
			
			answer = 2 + (len - 1) + (one * 2) + (zero * 4) + 
					((len - one - zero) * 3);
			
			System.out.println(answer);
			
			input = read.nextLine();
			len = input.length();
		}
		
		// end program
		return;
	}

}
