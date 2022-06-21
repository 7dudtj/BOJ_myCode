import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {
  public static void main(String[] args) throws IOException{
    // set needed components
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;
    StringBuilder sb = new StringBuilder();
    int T = Integer.parseInt(br.readLine());
    int n, answer;
    int[][] s;
    int[][] dp;

    // do testcases
    for (int tc = 0; tc < T; tc++){
      // get stickers
      n = Integer.parseInt(br.readLine());
      s = new int[2][n];
      for (int l = 0; l < 2; l++){
        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < n; i++) s[l][i] = Integer.parseInt(st.nextToken());
      }
      
      // do dp
      dp = new int[3][n];
      dp[0][0] = 0;
      dp[1][0] = s[0][0];
      dp[2][0] = s[1][0];
      for (int i = 1; i < n; i++){
        dp[0][i] = Math.max(dp[0][i-1], Math.max(dp[1][i-1], dp[2][i-1]));
        dp[1][i] = Math.max(dp[0][i-1], dp[2][i-1]) + s[0][i];
        dp[2][i] = Math.max(dp[0][i-1], dp[1][i-1]) + s[1][i];
      }

      // get answer
      answer = Math.max(dp[0][n-1], Math.max(dp[1][n-1], dp[2][n-1]));

      // save answer
      sb.append(answer).append('\n');
    }

    // print answer and end program
    System.out.print(sb);
    br.close();
    return;
  }
}