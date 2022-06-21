import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.math.BigInteger;

public class Main {
	public static void main(String args[]) throws IOException	{
    // set needed variables
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    br.close();
    BigInteger[] dp = new BigInteger[n+1];

    // n:0 or 1
    if (n == 0 || n == 1){
      System.out.println(n);
      return;
    }

    // n >= 2: do dp
    dp[0] = new BigInteger("0");
    dp[1] = new BigInteger("1");
    for (int i = 2; i <= n; i++){
      dp[i] = dp[i-1].add(dp[i-2]);
    }

    // print answer and end program
    System.out.println(dp[n]);
    return;
  }
}