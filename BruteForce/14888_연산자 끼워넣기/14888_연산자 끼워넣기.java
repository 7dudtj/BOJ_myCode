import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main{

	// set static variables
	static int N;
	static int[] arr;
	static int[] oper;
	static int max = Integer.MIN_VALUE;
	static int min = Integer.MAX_VALUE;

	public static void main(String[] args) throws IOException{

		// set needed variables
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		arr = new int[N];
		String[] tmp = br.readLine().split(" ");
		for (int i = 0; i < N; i++) arr[i] = Integer.parseInt(tmp[i]);
		oper = new int[4];
		tmp = br.readLine().split(" ");
		for (int i = 0; i < 4; i++) oper[i] = Integer.parseInt(tmp[i]);

		// find answer by backtracking
		bt(0, arr[0]);

		// print answer and end program
		System.out.print(max + "\n" + min);
		br.close();
		return;
	}

	// backtracking function
	private static void bt(int nOper, int result){

		// finish calculation
		if (nOper == N - 1){
			if (max < result) max = result;
			if (min > result) min = result;
			return;
		}

		// do backtracking
		// 1. plus operation
		if (oper[0] > 0){
			oper[0]--;
			bt(nOper + 1, result + arr[nOper + 1]);
			oper[0]++;
		}
		// 2. minus operation
		if (oper[1] > 0){
			oper[1]--;
			bt(nOper + 1, result - arr[nOper + 1]);
			oper[1]++;
		}
		// 3. multiply operation
		if (oper[2] > 0){
			oper[2]--;
			bt(nOper + 1, result * arr[nOper + 1]);
			oper[2]++;
		}
		// 4. divide operation
		if (oper[3] > 0){
			oper[3]--;
			bt(nOper + 1, result / arr[nOper + 1]);
			oper[3]++;
		}

		return;
	}
}