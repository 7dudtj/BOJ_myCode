import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// set needed comoponents
		Scanner read = new Scanner(System.in);
		int N, Q, pos, shuttle, i, j;
		int[] array;
		int first, mid, last, dis, sum, ans;
		String s;
		
		// get N and Q
		s = read.nextLine();
		pos = s.indexOf(" ");
		N = Integer.parseInt(s.substring(0, pos));
		Q = Integer.parseInt(s.substring(pos + 1));
		
		// set array
		array = new int[N + 1];
		for (i = 0; i < N + 1; i++) {
			array[i] = Integer.MAX_VALUE;
		}
		
		// get array
		for (i = 0; i < N; i++) {
			shuttle = read.nextInt();
			array[i + 1] = shuttle;
		}
		s = read.nextLine(); // used for getting next line
		
		// get input and calculate cycle
		for (i = 0; i < Q; i++) {
			// get first value and last value
			sum = 0;
			s = read.nextLine();
			mid = s.indexOf(" ");
			first = Integer.parseInt(s.substring(0, mid));
			last = Integer.parseInt(s.substring(mid + 1));
			
			// check if j-1 < i
			if (last - 1 < first) {
				System.out.println("0");
				continue;
			}
			
			// calculation process
			dis = last - first;
			for (j = 0; j < dis; j++) {
				ans = Math.abs(array[first + 1] - array[first]);
				sum += ans;
				first++;
			}
			System.out.println(sum);
		}
		
		// end of program
		read.close();
		return;
	}

}