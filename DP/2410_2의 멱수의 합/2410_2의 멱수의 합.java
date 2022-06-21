import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
  public static void main(String[] args) throws IOException{
    // set needed components
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine()); br.close();
    int[] dp = new int[N+1];
    
    // exception handling
    if (N <= 2){
      System.out.print(N);
      return;
    }

    // do dp
    dp[1] = 1; dp[2] = 2;
    for (int i = 3; i <= N; i++){
      if (i%2 == 1) dp[i] = dp[i-1];
      else dp[i] = (dp[i-1]+dp[i/2])%1000000000;
    }

    // print answer and end program
    System.out.print(dp[N]);
    return;
  }
}