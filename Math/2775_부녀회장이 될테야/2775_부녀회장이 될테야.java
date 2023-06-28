import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main{
	public static void main(String[] args) throws IOException{
		// Set needed variables
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		int[][] dp = new int[15][15];
		StringBuilder sb = new StringBuilder();
		int k = 0;
		int n = 0;

		// Initialize default dp map
		for (int i = 1; i <= 14; i++){
			dp[0][i] = i;
		}

		// Calculate dp map
		for (int i = 1; i <= 14; i++){
			for (int j = 1; j <= 14; j++){
				dp[i][j] = dp[i][j-1] + dp[i-1][j];
			}
		}

		// Make answer
		for (int i = 0; i < T; i++){
			k = Integer.parseInt(br.readLine());
			n = Integer.parseInt(br.readLine());
			sb.append(dp[k][n]).append('\n');
		}
		br.close();

		// Print answer and end program
		System.out.print(sb);
		return;
	}
} {
    
}
