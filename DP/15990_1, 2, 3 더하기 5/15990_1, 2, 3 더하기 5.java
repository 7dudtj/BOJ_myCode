import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
  public static void main(String[] args) throws IOException{
    // set needed components
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    // do dp
    long[][] dp = new long[100001][4];
    dp[1][1] = 1; dp[2][2] = 1;
    dp[3][1] = 1; dp[3][2] = 1; dp[3][3] = 1;
    for (int i = 4; i <= 100000; i++){
      dp[i][1] = (dp[i-1][2]+dp[i-1][3])%1000000009;
      dp[i][2] = (dp[i-2][1]+dp[i-2][3])%1000000009;
      dp[i][3] = (dp[i-3][1]+dp[i-3][2])%1000000009;
    }
    for (int i = 1; i <= 100000; i++) dp[i][0] = (dp[i][1]+dp[i][2]+dp[i][3])%1000000009;

    // get input and answer
    int T = Integer.parseInt(br.readLine());
    StringBuilder sb = new StringBuilder();
    int n;
    for (int t = 0; t < T; t++){
      n = Integer.parseInt(br.readLine());
      sb.append(dp[n][0]).append('\n');
    }

    // print answer and end program
    System.out.print(sb);
    br.close();
    return;
  }
}