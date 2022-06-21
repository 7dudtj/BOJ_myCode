import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
	public static void main(String args[]) throws IOException	{
    // set needed variables
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    int[] dp = new int[n+1];
    dp[0] = 1;
    dp[1] = 1;

    // if n == 1
    if (n == 1) {
      System.out.println(1);
      br.close();
      return;
    }

    // do dp
    for (int i = 2; i <= n; i++){
      dp[i] = dp[i-1]%10 + dp[i-2]%10;
    }

    // print answer and end program
    System.out.println(dp[n]%10);
    br.close();
    return;
  }
}