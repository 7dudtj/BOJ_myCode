import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// set needed components
		Scanner read = new Scanner(System.in);
		int N, i, j, x, y, pos;
		int[] xList, yList;
		String s;
		
		// get N
		s = read.nextLine();
		N = Integer.parseInt(s);
		
		// make xList and yList
		xList = new int[N];
		yList = new int[N];
		
		// get information
		for (i = 0; i < N; i++) {
			s = read.nextLine();
			pos = s.indexOf(" ");
			x = Integer.parseInt(s.substring(0, pos));
			y = Integer.parseInt(s.substring(pos + 1));
			xList[i] = x;
			yList[i] = y;
		}
		read.close();
		
		// do process
		for (i = 0; i < N; i++) {
			int ans = 0;
			for (j = 0; j < N; j++) {
				if (j == i) continue;
				if ((xList[j] > xList[i]) && (yList[j] > yList[i])) ans++;
			}
			System.out.print(ans + 1);
			if (i != N - 1) System.out.print(" ");
		}
	}

}
