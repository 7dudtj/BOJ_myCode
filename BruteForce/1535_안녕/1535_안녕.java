import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.Arrays;

public class Main {
  // set static variables

	public static void main(String args[]) throws Exception	{
    // set needed variables
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;
    int N = Integer.parseInt(br.readLine());
    int[] L = new int[N+1];
    st = new StringTokenizer(br.readLine(), " ");
    for (int i = 1; i <= N; i++){
      L[i] = Integer.parseInt(st.nextToken());
    }
    int[] J = new int[N+1];
    st = new StringTokenizer(br.readLine(), " ");
    for (int i = 1; i <= N; i++){
      J[i] = Integer.parseInt(st.nextToken());
    }
    int[] dp = new int[100];

    // do dp
    for (int i = 1; i <= N; i++){
      for (int j = 99; j >= 0; j--){
        int e = L[i] + j;
        if (e < 100){
          dp[e] = Math.max(dp[e], dp[j] + J[i]);
        }
      }
    }
    Arrays.sort(dp);

    // print answer and end program
    System.out.print(dp[99]);
    br.close();
    return;
  }
}