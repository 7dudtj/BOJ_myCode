import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {
	public static void main(String args[]) throws IOException	{
    // set needed variables
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int T = Integer.parseInt(br.readLine());
    int N, M;
    int[] coin, dp;
    StringTokenizer st;
    StringBuilder sb = new StringBuilder();

    // do process for T times
    for (int p = 0; p < T; p++){
      // get data
      N = Integer.parseInt(br.readLine());
      coin = new int[N];
      st = new StringTokenizer(br.readLine(), " ");
      for (int i = 0; i < N; i++) coin[i] = Integer.parseInt(st.nextToken());
      M = Integer.parseInt(br.readLine());
      dp = new int[M+1];
      dp[0] = 1;

      // do dp
      for (int i = 0; i < N; i++){
        for (int j = coin[i]; j <= M; j++){
          dp[j] += dp[j-coin[i]];
        }
      }

      // get answer
      sb.append(dp[M]).append('\n');
    }

    // print answer and end program
    System.out.print(sb);
    br.close();
    return;
  }
}