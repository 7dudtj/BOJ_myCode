import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
	public static void main(String args[]) throws IOException	{
    // set needed variables
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());
    long[] dp = new long[N+1];
    dp[0] = 0;
    dp[1] = 1;

    // do dp
    for (int i = 2; i <= N; i++){
      dp[i] = dp[i-1] + dp[i-2];
    }

    // print answer and end program
    System.out.println(dp[N]);
    br.close();
    return;
  }
}