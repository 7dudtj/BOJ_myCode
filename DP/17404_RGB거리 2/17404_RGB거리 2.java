import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.ArrayList;
import java.util.Collections;

// bottom-up dp
public class Main {
  // set needed variables
  private static final int INF = 1000 * 1000;

  public static void main(String[] args) throws IOException{
    // set needed components
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;
    int N = Integer.parseInt(br.readLine());
    ArrayList<Integer> list = new ArrayList<>();
    int[][] cost = new int[N+1][3];
    int[][] dp = new int[N+1][3];

    // get cost
    for (int i = 1; i <= N; i++){
      st = new StringTokenizer(br.readLine(), " ");
      cost[i][0] = Integer.parseInt(st.nextToken());
      cost[i][1] = Integer.parseInt(st.nextToken());
      cost[i][2] = Integer.parseInt(st.nextToken());
    }

    // do main dp
    // 0: RED, 1: GREEN, 2: BLUE
    for (int j = 0; j < 3; j++){
      // preset dp data
      for (int i = 0; i < 3; i++){
        if (i == j) dp[1][i] = cost[1][i];
        else dp[1][i] = INF;
      }

      // do bottom-up dp
      for (int i = 2; i <= N; i++){
        dp[i][0] = Math.min(dp[i-1][1], dp[i-1][2]) + cost[i][0];
        dp[i][1] = Math.min(dp[i-1][0], dp[i-1][2]) + cost[i][1];
        dp[i][2] = Math.min(dp[i-1][0], dp[i-1][1]) + cost[i][2];
      }

      // add result to list
      for (int i = 0; i < 3; i++){
        if (i != j) list.add(dp[N][i]);
      }
    }

    // get answer, print answer, and end program
    Collections.sort(list);
    System.out.println(list.get(0));
    br.close();
    return;
  }
}
