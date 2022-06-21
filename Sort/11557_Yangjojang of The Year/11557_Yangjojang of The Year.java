import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// set needed components
		Scanner read = new Scanner(System.in);
		int T, N, i, j, amount, pos, index, max;
		String s, uni, ans;
		
		
		// get T
		s = read.nextLine();
		T = Integer.parseInt(s);
		
		// do process for T times
		for (i = 0; i < T; i++) {
			// get N
			s = read.nextLine();
			N = Integer.parseInt(s);
			// make list
			String[] uL;
			int[] aL;
			uL = new String[N];
			aL = new int[N];
			// get information of N uni's
			for (j = 0; j < N; j++) {
				s = read.nextLine();
				pos = s.indexOf(" ");
				uni = s.substring(0, pos);
				amount = Integer.parseInt(s.substring(pos + 1));
				uL[j] = uni;
				aL[j] = amount;
			}
			// find out answer
			max = -1;
			index = -1;
			for (j = 0; j < N; j++) {
				if (aL[j] > max) {
					index = j;
					max = aL[j];
				}
			}
			// display answer
			System.out.println(uL[index]);
		}
		
		// end program
		read.close();
		return;
	}

}
