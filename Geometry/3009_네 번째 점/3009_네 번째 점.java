import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// set needed components
		Scanner read = new Scanner(System.in);
		int w1 = 0, w2 = 0, h1 = 0, h2 = 0, ws, hs, wt = 0, ht = 0, 
				pos, f, l, width, height;
		String s;
		
		// get informaiton
		s = read.nextLine();
		pos = s.indexOf(" ");
		f = Integer.parseInt(s.substring(0, pos));
		wt += f;
		l = Integer.parseInt(s.substring(pos + 1));
		ht += l;
		w1 = f;
		h1 = l;
		
		s = read.nextLine();
		pos = s.indexOf(" ");
		f = Integer.parseInt(s.substring(0, pos));
		wt += f;
		l = Integer.parseInt(s.substring(pos + 1));
		ht += l;
		if (w1 != f) w2 = f;
		if (h1 != l) h2 = l;
		
		s = read.nextLine();
		pos = s.indexOf(" ");
		f = Integer.parseInt(s.substring(0, pos));
		wt += f;
		l = Integer.parseInt(s.substring(pos + 1));
		ht += l;
		if (w1 != f) w2 = f;
		if (h1 != l) h2 = l;
		
		// calculation
		read.close();
		ws = 2 * (w1 + w2);
		hs = 2 * (h1 + h2);
		width = ws - wt;
		height = hs - ht;
		
		// display results
		System.out.println(width + " " + height);
	}

}