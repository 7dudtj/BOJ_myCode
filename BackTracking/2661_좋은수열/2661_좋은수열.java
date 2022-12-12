import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main{
	
	// set static variables
	static String answer = "";
	static int N = 0;

	public static void main(String[] args) throws IOException{

		// set needed variables
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		br.close();

		// do backtracking
		answer = "1";
		bt(0, 1);
		answer = "2";
		bt(0, 2);
		answer = "3";
		bt(0, 3);
	}

	// backtracking function
	private static void bt(int loc, int num){

		// check finish condition
		if (loc == N){
			System.out.print(answer.substring(0, answer.length() - 1));
			System.exit(0);
		}

		// check possibility
		boolean possible = true;
		for (int i = 1; i <= 40; i++){

			if (i*2 > loc+1) break;

			if (answer.substring(loc-i+1, loc+1).equals(answer.substring(loc-2*i+1, loc-i+1))){
				possible = false;
			}

			if (!possible) break;
		}

		// not possible
		if (!possible) return;

		// possible
		for (int i = 1; i <= 3; i++){
			answer += Integer.toString(i);
			bt(loc + 1, i);
			answer = answer.substring(0, answer.length() - 1);
		}

		return;
	}
}