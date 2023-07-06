import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// set needed components
		Scanner read = new Scanner(System.in);
		int N, K, i, pos, point, count = 0, search;
		int[] list;
		String s;
		
		// get N and K
		s = read.nextLine();
		pos = s.indexOf(" ");
		N = Integer.parseInt(s.substring(0, pos));
		K = Integer.parseInt(s.substring(pos + 1));
		
		// make list
		list = new int[N];
		for (i = 0; i < N; i++) {
			point = read.nextInt();
			list[i] = point;
		}
		search = list[0];
		
		// set count
		for (i = 0; i < N; i++) {
			++count;
			if (search == K) {
				System.out.println(count);
				read.close();
				return;
			}
			search = list[search];
		}
		
		// no answer
		System.out.println("-1");
		read.close();
		return;
	}

}