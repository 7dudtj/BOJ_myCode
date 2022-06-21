import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
  public static void main(String[] args) throws IOException{
    // set needed components
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int T = Integer.parseInt(br.readLine());
    int n;
    long[] dp;
    StringBuilder sb = new StringBuilder();

    // do testcases for T times
    for (int times = 0; times < T; times++){
      // get n
      n = Integer.parseInt(br.readLine());

      // exception handling
      if (n <= 3){
        if (n == 3) sb.append(4).append('\n');
        else sb.append(n).append('\n');
        continue;
      }

      // do dp
      dp = new long[n+1];
      dp[1] = 1; dp[2] = 2; dp[3] = 4;
      for (int i = 4; i <= n; i++) dp[i] = (dp[i-1]+dp[i-2]+dp[i-3]) % 1000000009;

      // get answer
      sb.append(dp[n]).append('\n');
    }

    // print answer and end program
    System.out.print(sb);
    br.close();
    return;
  }
}