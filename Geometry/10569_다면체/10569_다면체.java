import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// set needed components
		Scanner read = new Scanner(System.in);
		int N, i, V, E, pos;
		String s;
		
		// get N
		N = read.nextInt();
		s = read.nextLine();
		
		// do process
		for (i = 0; i < N; i++) {
			s = read.nextLine();
			pos = s.indexOf(" ");
			V = Integer.parseInt(s.substring(0, pos));
			E = Integer.parseInt(s.substring(pos + 1));
			System.out.println(2 - V + E);
		}
		
		// end program
		read.close();
		return;
	}

}