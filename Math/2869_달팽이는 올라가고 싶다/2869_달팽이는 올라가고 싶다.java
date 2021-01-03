import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// set needed components
		Scanner read = new Scanner(System.in);
		int A, B, V, mid, pos, ans;
		String s;
		
		// get A, B, and V
		s = read.nextLine();
		pos = s.indexOf(" ");
		A = Integer.parseInt(s.substring(0, pos));
		s = s.substring(pos + 1);
		pos = s.indexOf(" ");
		B = Integer.parseInt(s.substring(0, pos));
		V = Integer.parseInt(s.substring(pos + 1));
		read.close();
		
		// do process
		if ((V - A) % (A - B) == 0) mid = (int) (V - A) / (A - B);
		else mid = (int) (V - A) / (A - B) + 1;
		ans = mid + 1;
		
		System.out.println(ans);
	}

}
