import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// set needed components
		Scanner read = new Scanner(System.in);
		int N, M, i, j, pos;
		String s;
		char[][] map;
		char[] shuttle;
		
		// get N and M
		s = read.nextLine();
		pos = s.indexOf(" ");
		N = Integer.parseInt(s.substring(0, pos));
		M = Integer.parseInt(s.substring(pos + 1));
		
		// set default map
		map = new char[M][N];
		
		// get data, process, and send
		for (i = 0; i < N; i++) {
			s = read.nextLine();
			shuttle = s.toCharArray();
			// process shuttle array
			for (j = 0; j < M; j++) {
				if (shuttle[j] == '.') {
					map[M-j-1][i] = '.';
				}else if (shuttle[j] == 'O') {
					map[M-j-1][i] = 'O';
				}else if (shuttle[j] == '-') {
					map[M-j-1][i] = '|';
				}else if (shuttle[j] == '|') {
					map[M-j-1][i] = '-';
				}else if (shuttle[j] == '/') {
					map[M-j-1][i] = '\\';
				}else if (shuttle[j] == '\\') {
					map[M-j-1][i] = '/';
				}else if (shuttle[j] == '^') {
					map[M-j-1][i] = '<';
				}else if (shuttle[j] == '<') {
					map[M-j-1][i] = 'v';
				}else if (shuttle[j] == 'v') {
					map[M-j-1][i] = '>';
				}else if (shuttle[j] == '>') {
					map[M-j-1][i] = '^';
				}
			}// processing finish
		}
		read.close();
		
		// display results
		for (i = 0; i < M; i++) {
			for (j = 0; j < N; j++) {
				System.out.print(map[i][j]);
			}
			System.out.println("");
		}
		
		// end program
		return;
	}

}
