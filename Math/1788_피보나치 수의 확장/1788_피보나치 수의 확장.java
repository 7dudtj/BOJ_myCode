import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
  public static void main(String[] args) throws IOException{
    // set needed components
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine()); br.close();
    int N = Math.abs(n);
    int[] dp = new int[N+1];

    // exception handling
    if (N==0 || N==1){
      System.out.println(N);
      System.out.println(N);
      return;
    }

    // do dp
    dp[1] = 1;
    for (int i = 2; i <= N; i++){
      dp[i] = (dp[i-1] + dp[i-2]) % 1000000000;
    }

    // print answer and end programt
    if (n<0 && n%2==0) System.out.println(-1);
    else System.out.println(1);
    System.out.println(dp[N]);
    return;
  }
}