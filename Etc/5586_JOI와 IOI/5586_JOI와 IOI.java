import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// set needed components
		Scanner read = new Scanner(System.in);
		String s;
		int len, i, JOI = 0, IOI = 0;
		
		// get s
		s = read.nextLine();
		len = s.length();
		read.close();
		
		// check
		if (len == 1 || len == 2) {
			System.out.println(0 + "\n" + 0);
			return;
		}
		
		// do process
		for (i = 0; i < len - 2; i++) {
			// count 'JOI'
			if (s.substring(i, i + 1).equals("J")) {
				if (s.substring(i + 1, i + 2).equals("O")) {
					if (s.substring(i + 2, i + 3).equals("I")) JOI++;
				}
			}
			
			// count 'IOI'
			if (s.substring(i, i + 1).equals("I")) {
				if (s.substring(i + 1, i + 2).equals("O")) {
					if (s.substring(i + 2, i + 3).equals("I")) IOI++;
				}
			}
		}
		
		// display results
		System.out.println(JOI + "\n" + IOI);
		return;
	}

}
