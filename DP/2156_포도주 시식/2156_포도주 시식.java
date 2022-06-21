import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
  public static void main(String[] args) throws IOException{
    // set needed components
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    int[] wine = new int[n+1];
    int[] dp = new int[n+1];

    // get data
    for (int i = 1; i <= n; i++){
      wine[i] = Integer.parseInt(br.readLine());
    } br.close();

    // exception handling
    if (n <= 2){
      if (n == 1) System.out.print(wine[1]);
      else System.out.print(wine[1]+wine[2]);
      return;
    }

    // do dp
    dp[1] = wine[1];
    dp[2] = wine[1]+wine[2];
    for (int i = 3; i <= n; i++){
      dp[i] = Math.max(dp[i-1], Math.max(dp[i-2]+wine[i], dp[i-3]+wine[i-1]+wine[i]));
    }

    // print answer and end program
    System.out.print(dp[n]);
    return;
  }
}