import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
  public static void main(String[] args) throws IOException{
    // set needed components
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    int[] dp = new int[n+1];

    // exception handling
    if (n==1 || n==2){
      System.out.println(n);
      br.close();
      return;
    }

    // do dp
    dp[1] = 1; dp[2] = 2;
    for (int i = 3; i <= n; i++){
      dp[i] = (dp[i-1]+dp[i-2])%10007;
    }

    // print answer and end program
    System.out.println(dp[n]);
    br.close();
    return;
  }
}