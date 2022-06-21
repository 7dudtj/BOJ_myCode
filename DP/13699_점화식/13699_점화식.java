import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
	public static void main(String args[]) throws IOException	{
    // set needed variables
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    long[] dp = new long[n+1];
    dp[0] = 1;

    // do dp
    for (int i = 1; i <= n; i++){
      for (int j = 0; j < i; j++){
        dp[i] += (dp[j] * dp[i-j-1]);
      }
    }

    // print answer and end program
    System.out.println(dp[n]);
    br.close();
    return;
  }
}