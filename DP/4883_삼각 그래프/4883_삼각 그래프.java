import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {
  public static void main(String[] args) throws IOException{
    // set needed components
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;
    int N, tcNum = 0;
    long answer = 0;
    long[][] map, dp;


    // do testcases
    while ((N = Integer.parseInt(br.readLine())) != 0){
      // get map
      map = new long[N+1][3];
      for (int i = 1; i <= N; i++){
        st = new StringTokenizer(br.readLine(), " ");
        for (int j = 0; j < 3; j++){
          map[i][j] = Long.parseLong(st.nextToken());
        }
      }

      // do dp
      dp = new long[N+1][3];
      dp[2][0] = map[1][1] + map[2][0];
      dp[2][1] = Math.min(Math.min(map[1][1]+map[2][0], map[1][1]), map[1][1]+map[1][2]) + map[2][1];
      dp[2][2] = Math.min(dp[2][1], Math.min(map[1][1], map[1][1]+map[1][2])) + map[2][2];
      for (int i = 3; i <= N; i++){
        dp[i][0] = Math.min(dp[i-1][0], dp[i-1][1]) + map[i][0];
        dp[i][1] = Math.min(
          Math.min(dp[i][0], dp[i-1][0]), Math.min(dp[i-1][1], dp[i-1][2])
          ) + map[i][1];
        dp[i][2] = Math.min(dp[i][1], Math.min(dp[i-1][1], dp[i-1][2])) + map[i][2];
      }

      // print answer
      tcNum++;
      answer = dp[N][1];
      System.out.println(tcNum+". "+answer);
    }
  }
}