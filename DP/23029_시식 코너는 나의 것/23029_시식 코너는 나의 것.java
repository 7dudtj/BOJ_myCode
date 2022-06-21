import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
	public static void main(String args[]) throws IOException	{
    // set needed variables
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());
    int[] food = new int[N+1];
    for (int i= 1; i <= N; i++) food[i] = Integer.parseInt(br.readLine());
    int[][] dp = new int[N+1][3];
    dp[1][0] = food[1];
    int answer = Integer.MIN_VALUE;

    // do dp
    for (int i = 2; i <= N; i++){
      dp[i][0] = dp[i-1][2] + food[i];
      dp[i][1] = dp[i-1][0] + food[i]/2;
      dp[i][2] = Math.max(dp[i-1][0], Math.max(dp[i-1][1], dp[i-1][2]));
    }

    // find answer
    for (int i = 0; i < 3; i++){
      if (answer < dp[N][i]) answer = dp[N][i];
    }

    // print answer and end program
    System.out.print(answer);
    br.close();
    return;
  }
}