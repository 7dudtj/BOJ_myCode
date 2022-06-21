import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
  public static void main(String[] args) throws IOException{
    // set needed components
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine()); br.close();
    int[] dp = new int[n+1];

    // exception handling
    if (n==1 || n==2){
      System.out.print(n==1?1:3);
      return;
    }

    // do dp
    dp[1] = 1; dp[2] = 3;
    for (int i = 3; i <= n; i++){
      dp[i] = (dp[i-2]*2+dp[i-1])%10007;
    }

    // print answer and end program
    System.out.print(dp[n]);
    return;
  }
}