import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// set needed components
		Scanner read = new Scanner(System.in);
		String s;
		int len, i;
		char[] list;
		
		// get s
		s = read.nextLine();
		read.close();
		len = s.length();
		
		// make list
		list = s.toCharArray();
		
		// do process
		for (i = 0; i < len; i++) {
			if ((97 <= (int) list[i] && (int) list[i] <= 109) || 
					(65 <= (int) list[i] && (int) list[i] <= 77)) {
				System.out.print((char)(((int) list[i]) + 13));
			} else if (110 <= (int) list[i] && (int) list[i] <= 122) {
				System.out.print((char)(((int) list[i]) - 13));
			} else if (78 <= (int) list[i] && (int) list[i] <= 90) {
				System.out.print((char)(((int) list[i]) - 13));
			} else {
				System.out.print(list[i]);
			}
		}
	}

}
