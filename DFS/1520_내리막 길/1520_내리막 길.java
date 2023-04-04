import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main{

	// set static variables
	static int N, M;
	static int[][] map;
	static int[][] dp;
	static int[] di = {0, 1, 0, -1};
	static int[] dj = {-1, 0, 1, 0};

	public static void main(String[] args) throws IOException{

		// set needed variables
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input = br.readLine().split(" ");
		M = Integer.parseInt(input[0]);
		N = Integer.parseInt(input[1]);

		// make map
		map = new int[M +1][N + 1];
		for (int i = 0; i <= M; i++){
			for (int j = 0; j <= N; j++){
				map[i][j] = 10001;
			}
		}
		for (int i = 1; i <= M; i++){
			input = br.readLine().split(" ");
			for (int j = 1; j <= N; j++){
				map[i][j] = Integer.parseInt(input[j-1]);
			}
		}

		// do dp with dfs, print answer, and end program
		dp = new int[M + 1][N + 1];
		for (int i = 0; i <= M; i++){
			for (int j = 0; j <= N; j++){
				dp[i][j] = -1;
			}
		}
		System.out.print(dfs(1, 1));
		br.close();
		return;
	}

	// dfs function
	private static int dfs(int i, int j){

		if (i == M && j == N) return 1;

		if (dp[i][j] != -1) return dp[i][j];

		dp[i][j] = 0;
		for (int k = 0; k < 4; k++){

			int ni = i + di[k];
			int nj = j + dj[k];

			if (ni <= 0 || ni > M || nj <= 0 || nj > N) continue;

			if (map[i][j] > map[ni][nj]) dp[i][j] += dfs(ni, nj);
		}

		return dp[i][j];
	}
}