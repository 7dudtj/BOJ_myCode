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
    int M = Integer.parseInt(st.nextToken());
    int[] m = new int[N+1];
    int[] c = new int[N+1];
    int[] dp = new int[10001];
    
    // get memory and cost
    st = new StringTokenizer(br.readLine(), " ");
    for (int i = 1; i <= N; i++){
      m[i] = Integer.parseInt(st.nextToken());
    }
    st = new StringTokenizer(br.readLine(), " ");
    for (int i = 1; i <= N; i++){
      c[i] = Integer.parseInt(st.nextToken());
    }

    // do dp
    for (int i = 1; i <= N; i++){
      for (int j = 10000; j >= 0; j--){
        int cost = j + c[i];
        if (cost <= 10000){
          dp[cost] = Math.max(dp[cost], dp[j] + m[i]);
        }
      }
    }

    // find answer, print answer, and end program
    for (int i = 0; i <= 10000; i++){
      if (dp[i] >= M){
        System.out.print(i);
        br.close();
        return;
      }
    }
  }
}