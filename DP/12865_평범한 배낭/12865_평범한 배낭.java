import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.Arrays;

public class Main {
	public static void main(String args[]) throws Exception	{
    // set needed variables
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine(), " ");
    int N = Integer.parseInt(st.nextToken());
    int K = Integer.parseInt(st.nextToken());
    int[] W = new int[N+1];
    int[] V = new int[N+1];
    int[] dp = new int[K+1];

    // get data
    for (int i = 1; i <= N; i++){
      st = new StringTokenizer(br.readLine(), " ");
      W[i] = Integer.parseInt(st.nextToken());
      V[i] = Integer.parseInt(st.nextToken());
    }

    // do dp
    for (int i = 1; i <= N; i++){
      for (int j = K; j >= 0; j--){
        int e = j + W[i];
        if (e <= K){
          dp[e] = Math.max(dp[e], dp[j] + V[i]);
        }
      }
    }
    Arrays.sort(dp);
    
    // print answer and end program
    System.out.print(dp[K]);
    br.close();
    return;
  }
}