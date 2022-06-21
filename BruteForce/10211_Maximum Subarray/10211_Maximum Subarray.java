import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {
  public static void main(String[] args) throws IOException{
    // set needed components
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int T = Integer.parseInt(br.readLine()), N, max;
    int[] X;
    int[][] dp;
    StringTokenizer st;
    StringBuilder sb = new StringBuilder();

    // do process for T times
    for (int t = 0; t < T; t++){
      // get data and set variables
      max = Integer.MIN_VALUE;
      N = Integer.parseInt(br.readLine());
      X = new int[N];
      dp = new int[N][N];
      st = new StringTokenizer(br.readLine(), " ");
      for (int i = 0; i < N; i++) {
        X[i] = Integer.parseInt(st.nextToken());
        if (max < X[i]) max = X[i];
        dp[0][i] = X[i];
      }

      // do dp
      for (int i = 1; i < N; i++){
        for (int j = i; j < N; j++){
          dp[i][j] = dp[i-1][j-1] + dp[0][j];
          if (max < dp[i][j]) max = dp[i][j];
        }
      }

      // get answer
      sb.append(max).append('\n');
    }

    // print answer and end program
    System.out.print(sb);
    br.close();
    return;
  }
}