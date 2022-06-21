import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
  public static void main(String[] args) throws IOException{
    // set needed components
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine()); br.close();

    // exception handling
    if (N <= 2){
      if (N == 1) System.out.print(3);
      else System.out.print(7);
      return;
    }

    // do dp
    int[] dp = new int[N+1];
    dp[1] = 3; dp[2] = 7;
    for (int i = 3; i <= N; i++) dp[i] = (2*dp[i-1]+dp[i-2]) % 9901;

    // print answer and end program
    System.out.print(dp[N]);
    return;
  }
}