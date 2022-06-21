import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
  public static void main(String[] args) throws IOException{
    // set needed components
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int D = Integer.parseInt(br.readLine());
    long[][] dp = new long[8][D+1];

    // do dp
    dp[7][0] = 1;
    for (int i = 1; i <= D; i++){
      dp[0][i] = (dp[1][i-1]+dp[2][i-1])%1000000007;
      dp[1][i] = (dp[0][i-1]+dp[3][i-1])%1000000007;
      dp[2][i] = (dp[0][i-1]+dp[3][i-1]+dp[4][i-1])%1000000007;
      dp[3][i] = (dp[1][i-1]+dp[2][i-1]+dp[4][i-1]+dp[5][i-1])%1000000007;
      dp[4][i] = (dp[2][i-1]+dp[3][i-1]+dp[5][i-1]+dp[6][i-1])%1000000007;
      dp[5][i] = (dp[3][i-1]+dp[4][i-1]+dp[6][i-1]+dp[7][i-1])%1000000007;
      dp[6][i] = (dp[4][i-1]+dp[5][i-1]+dp[7][i-1])%1000000007;
      dp[7][i] = (dp[5][i-1]+dp[6][i-1])%1000000007;
    }

    // print answer and end program
    System.out.print(dp[7][D]);
    br.close();
    return;
  }
}