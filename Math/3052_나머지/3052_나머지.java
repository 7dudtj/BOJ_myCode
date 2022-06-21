import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// set needed components
		Scanner read = new Scanner(System.in);
		int in, out, i, j, key, count = 0, answer;
		int[] list = new int[10];
		for (i = 0; i < 10; i++) list[i] = -1;
		
		// get and store data
		for (i = 0; i < 10; i++) {
			in = read.nextInt();
			out = in % 42;
			list[i] = out;
		}
		
		// process data
		for (j = 0; j < 10; j++) {
			key = list[j];
			for (i = j + 1; i < 10; i++) {
				if (list[i] == key) list[i] = -1;
			}
		}
		
		// search and find
		for (i = 0; i < 10; i++) {
			if (list[i] == -1) count++;
		}
		answer = 10 - count;
		System.out.println(answer);
		
		// end program
		read.close();
		return;
	}

}
