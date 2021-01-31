import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// set needed components
		Scanner read = new Scanner(System.in);
		int n;
		
		// get n
		n = Integer.parseInt(read.nextLine());
		
		// do process
		if (n % 8 == 1) System.out.println(1);
		else if (n % 8 == 2) System.out.println(2);
		else if (n % 8 == 3) System.out.println(3);
		else if (n % 8 == 4) System.out.println(4);
		else if (n % 8 == 5) System.out.println(5);
		else if (n % 8 == 6) System.out.println(4);
		else if (n % 8 == 7) System.out.println(3);
		else if (n % 8 == 0) System.out.println(2);
		
		// end program
		read.close();
		return;
	}

}
