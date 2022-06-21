import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {
  public static void main(String[] args) throws IOException{
    // set needed components
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());
    int[] T = new int[N+1];
    int[] P = new int[N+1];
    int[] dp = new int[N+1];
    StringTokenizer st;

    // get data
    for (int i = 1; i <= N; i++){
      st = new StringTokenizer(br.readLine(), " ");
      T[i] = Integer.parseInt(st.nextToken());
      P[i] = Integer.parseInt(st.nextToken());
    }

    // do dp
    for (int i = 1; i <= N; i++){
      if (i+T[i]-1 <= N) dp[i+T[i]-1] = Math.max(dp[i+T[i]-1], dp[i-1]+P[i]);
      if (dp[i] < dp[i-1]) dp[i] = dp[i-1];
    }

    // print answer and end program
    System.out.print(dp[N]);
    br.close();
    return;
  }
}