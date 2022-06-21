import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {
	public static void main(String args[]) throws IOException	{
    // set needed variables
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine(), " ");
    int n = Integer.parseInt(st.nextToken());
    int k = Integer.parseInt(st.nextToken());
    int[][] dp = new int[n+1][n+1];
    
    // do dp
    dp[0][1] = 1;
    for (int i = 1; i <= n; i++){
      for (int j = 1; j <= i; j++){
        dp[i][j] = dp[i-1][j-1] + dp[i-1][j];
      }
    }
    
    // print answer and end program
    System.out.println(dp[n][k]);
    br.close();
    return;
  }
}