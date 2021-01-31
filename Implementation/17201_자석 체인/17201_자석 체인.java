import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		String a, state;
		int num, i;
		char first, second;
		boolean magnet = true;
		
		Scanner read = new Scanner(System.in);
		a = read.nextLine();
		num = Integer.parseInt(a);
		state = read.nextLine();
		read.close();
		
		for (i = 0; i < num - 1; i++) {
			first = state.charAt(i * 2 + 1);
			second = state.charAt(i * 2 + 2);
			
			if (first == second) magnet = false;
		}
		
		if (magnet) {
			System.out.println("Yes");
		} else {
			System.out.println("No");
		}
	}

}
