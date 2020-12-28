import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// set needed components
		Scanner read = new Scanner(System.in);
		int B, len, pos, i, total = 0;
		String s, N;
		
		// get N and S
		s = read.nextLine();
		read.close();
		pos = s.indexOf(" ");
		N = s.substring(0, pos);
		B = Integer.parseInt(s.substring(pos + 1));
		len = N.length();
		
		// convert
		for (i = 0; i < len; i++) {
			int shuttle;
			char[] two;
			two = N.toCharArray();
			if (48 <= (int) two[i] && (int) two[i] <= 57) {
				shuttle = ((int) two[i]) - 48;
				total += shuttle*Math.pow(B, len-1-i);
			}else {
				shuttle = ((int) two[i]) - 55;
				total += shuttle*Math.pow(B, len-1-i);
			}
		}
		
		// display answer
		System.out.println(total);
		return;
	}

}
