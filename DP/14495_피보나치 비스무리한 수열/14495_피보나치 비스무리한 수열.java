import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
  public static void main(String[] args) throws IOException{
    // set needed components
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine()); br.close();
    long[] dp = new long[n+1];

    // exception handling
    if (n==1 || n==2 || n==3){
      System.out.print(1);
      return;
    }

    // do dp
    dp[1] = dp[2] = dp[3] = 1;
    for (int i = 4; i <= n; i++) dp[i] = dp[i-1]+dp[i-3];

    // print answer and end program
    System.out.print(dp[n]);
    return;
  }
}