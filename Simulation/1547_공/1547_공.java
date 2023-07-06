import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// set needed components
		Scanner read = new Scanner(System.in);
		int M, X, Y, i, pos;
		int[] cup = new int[4];
		String s;
		
		// get M
		M = read.nextInt();
		
		// set default
		cup[0] = 0;
		cup[1] = 1;
		cup[2] = 2;
		cup[3] = 3;
		s = read.nextLine();
		
		// do process
		for (i = 0; i < M; i++) {
			// get X and Y
			s = read.nextLine();
			pos = s.indexOf(" ");
			X = Integer.parseInt(s.substring(0, pos));
			Y = Integer.parseInt(s.substring(pos + 1));
			
			swap(cup, X, Y);
		}
		
		// find cup
		read.close();
		if (cup[1] == 1) {
			System.out.println(1);
			return;
		}else if (cup[2] == 1) {
			System.out.println(2);
			return;
		}else if (cup[3] == 1) {
			System.out.println(3);
			return;
		}
	}
	
	public static void swap(int[] cup, int X, int Y) {
		int tmp = cup[X];
		
		cup[X] = cup[Y];
		cup[Y] = tmp;
	}

}