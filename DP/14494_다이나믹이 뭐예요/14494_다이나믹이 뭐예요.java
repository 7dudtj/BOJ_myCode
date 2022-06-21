import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {
  public static void main(String[] args) throws IOException{
    // set needed components
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine(), " ");
    int n = Integer.parseInt(st.nextToken());
    int m = Integer.parseInt(st.nextToken());
    long[][] dp = new long[n+1][m+1];
    dp[0][0] = 1;

    // do dp
    for (int i = 1; i <= n; i++){
      for (int j = 1; j <= m; j++){
        dp[i][j] = (dp[i-1][j-1] + dp[i-1][j] + dp[i][j-1]) % 1000000007;
      }
    }

    // print answer and end program
    System.out.print(dp[n][m]);
    br.close();
    return;
  }
}