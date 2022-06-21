import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {
  public static void main(String[] args) throws IOException{
    // set needed components
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());
    int[] cost = new int[N];
    StringTokenizer st = new StringTokenizer(br.readLine(), " ");
    for (int i = 0; i < N; i++) cost[i] = Integer.parseInt(st.nextToken());
    int[] dp = new int[N];
    for (int i = 0; i < N; i++) dp[i] = 1;
    
    // do dp
    for (int i = 1; i < N; i++){
      for (int j = i-1; j >= 0; j--){
        if (cost[j] > cost[i]) dp[i] = Math.max(dp[i], dp[j]+1);
      }
    }

    // find answer
    int max = dp[0];
    for (int i = 1; i < N; i++) if (max < dp[i]) max = dp[i];

    // print answer and end program
    System.out.print(max);
    br.close();
    return;
  }
}