import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
	public static void main(String args[]) throws IOException	{
    // set needed variables
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    int[] dp = new int[n+1];

    // do dp
    dp[1] = 1;
    for (int i = 2; i <= n; i++){
      int min = Integer.MAX_VALUE;
      for (int j = 1; j*j <= i; j++){
        if (min > dp[i-j*j]) min = dp[i-j*j];
      }
      dp[i] = min + 1;
    }

    // print answer and end program
    System.out.println(dp[n]);
    br.close();
    return;
  }
}