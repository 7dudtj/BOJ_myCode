import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {
  public static void main(String[] args) throws IOException{
    // set needed components
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());
    int[] p = new int[N+1];
    int[] dp = new int[N+1];

    // get p
    StringTokenizer st = new StringTokenizer(br.readLine(), " ");
    for (int i = 1; i <= N; i++) p[i] = Integer.parseInt(st.nextToken());
    dp[1] = p[1];

    // do dp
    for (int i = 2; i <= N; i++){
      int to = i-1;
      int from = i-to;
      dp[i] = p[i];
      while (from <= to){
        if (dp[from]+dp[to] > dp[i]) dp[i] = dp[from] + dp[to];
        to--;
        from++;
      }

      // for test
      /*
      System.out.println("dp: "+i);
      for (int j = 1; j <= N; j++) System.out.print(dp[j]+" ");
      System.out.println();*/
    }

    // print answer and end program
    System.out.print(dp[N]);
    br.close();
    return;
  }
}