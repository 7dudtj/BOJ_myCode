import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// set needed components
		Scanner read = new Scanner(System.in);
		String s, ss;
		int f, l;
		
		s = read.nextLine();
		ss = read.nextLine();
		
		f = s.length();
		l = ss.length();
		
		if (f >= l) System.out.println("go");
		else System.out.println("no");
		
		read.close();
		return;
	}

}

