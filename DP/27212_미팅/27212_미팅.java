import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main{

	// set static variables

	public static void main(String[] args) throws IOException{

		// set needed variables
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		int[][] W = new int[C+1][C+1];

		// get W
		for (int i = 1; i <= C; i++){
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 1; j <= C; j++){
				W[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		// get A and B
		int[] A = new int[N+1];
		int[] B = new int[M+1];
		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 1; i <= N; i++) A[i] = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine(), " ");
		for (int j = 1; j <= M; j++) B[j] = Integer.parseInt(st.nextToken());

		// do dp
		long[][] dp = new long[N+1][M+1];
		for (int i = 1; i <= N; i++){
			for (int j = 1; j <= M; j++){
				dp[i][j] = Math.max(Math.max(dp[i-1][j], dp[i][j-1]), dp[i-1][j-1]+W[A[i]][B[j]]);
			}
		}

		// find answer
		long max = Long.MIN_VALUE;
		for (int i = 1; i <= N; i++){
			for (int j = 1; j <= M; j++){
				if (max < dp[i][j]) max = dp[i][j];
			}
		}

		// print answer and end program
		System.out.print(max);
		br.close();
		return;
	}
}