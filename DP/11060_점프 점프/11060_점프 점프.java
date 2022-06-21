import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {
  public static void main(String[] args) throws IOException{
    // set needed components
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());
    int[] A = new int[N+1];
    int[] dp = new int[N+1];
    StringTokenizer st = new StringTokenizer(br.readLine(), " ");
    for (int i = 1; i <= N; i++) {
      A[i] = Integer.parseInt(st.nextToken());
      dp[i] = Integer.MAX_VALUE;
    }  

    // do dp
    dp[1] = 0;
    for (int i = 1; i < N; i++){
      for (int j = i+1; j <= i+A[i]; j++){
        if (j <= N){
          if (dp[j] == Integer.MAX_VALUE && dp[i] != Integer.MAX_VALUE){
            dp[j] = dp[i] + 1;
          }else if (dp[j] != Integer.MAX_VALUE){
            dp[j] = Math.min(dp[j], dp[i]+1);
          }
        }
      }
    }

    // print answer and end program
    if (dp[N] == Integer.MAX_VALUE) System.out.print(-1);
    else System.out.print(dp[N]);
    br.close();
    return;
  }
}