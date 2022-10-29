import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main{

	public static void main(String[] args) throws IOException{

		// set needed variables
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		int[] coins = new int[n];
		int[] dp = new int[k+1];
		dp[0] = 1;

		// get coins
		for (int i = 0; i < n; i++){
			coins[i] = Integer.parseInt(br.readLine());
		}
		
		// do dp
		for (int i = 0; i < n; i++){
			for (int j = coins[i]; j <= k; j++){
				dp[j] += dp[j-coins[i]];
			}
		}
		
		// print answe and end program
		System.out.print(dp[k]);
		br.close();
		return;
	}
}