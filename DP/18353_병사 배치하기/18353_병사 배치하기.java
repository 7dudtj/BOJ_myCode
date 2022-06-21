import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {
  public static void main(String[] args) throws IOException{
    // set needed components
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());
    int[] sol = new int[N+1];
    int[] dp = new int[N+1];
    StringTokenizer st = new StringTokenizer(br.readLine(), " ");
    for (int i = 1; i <= N; i++) {
      sol[i] = Integer.parseInt(st.nextToken());
      dp[i] = 1;
    }  

    // do dp
    for (int i = 2; i <= N; i++){
      for (int j = i-1; j >= 1; j--){
        if (sol[j] > sol[i]){
           dp[i] = Math.max(dp[j]+1, dp[i]);
        }
      }
    }

    // find answer
    int max = dp[1];
    for (int i = 2; i <= N; i++) if (max < dp[i]) max = dp[i];

    // print answer and end program
    System.out.print(N-max);
    br.close();
    return;
  }
}