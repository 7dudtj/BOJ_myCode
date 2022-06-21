import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {
  public static void main(String[] args) throws IOException{
    // set needed components
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine(), " ");
    int N = Integer.parseInt(st.nextToken());
    int M = Integer.parseInt(st.nextToken());
    int K = Integer.parseInt(st.nextToken());
    int[][] dp = new int[N][M];

    // set restricted area
    if (K != 0){
      int oi = (K-1)/M;
      int oj = (K-1)%M;
      for (int i = 0; i < oi; i++)
        for (int j = oj+1; j < M; j++) dp[i][j] = -1;
      for (int i = oi+1; i < N; i++)
        for (int j = 0; j < oj; j++) dp[i][j] = -1;
    }

    // do dp
    dp[0][0] = 1;
    for (int i = 0; i < N; i++){
      for (int j = 0; j < M; j++){
        if (dp[i][j] != -1){
          if (j+1<M && dp[i][j+1] != -1) dp[i][j+1] += dp[i][j];
          if (i+1<N && dp[i+1][j] != -1) dp[i+1][j] += dp[i][j];
        }
      }
    }

    // print answer and end program
    System.out.print(dp[N-1][M-1]);
    br.close();
    return;
  }
}