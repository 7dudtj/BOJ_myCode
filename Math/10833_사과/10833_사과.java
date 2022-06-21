import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// set needed components
		Scanner read = new Scanner(System.in);
		int N, A, B, i, sum = 0, pos;
		String s;
		
		
		// get N
		N = read.nextInt();
		s = read.nextLine();
		
		// do process
		for (i = 0; i < N; i++) {
			s = read.nextLine();
			pos = s.indexOf(" ");
			A = Integer.parseInt(s.substring(0, pos));
			B = Integer.parseInt(s.substring(pos + 1));
			sum += (B % A);
		}
		
		// display answer
		read.close();
		System.out.println(sum);
		return;
	}

}
