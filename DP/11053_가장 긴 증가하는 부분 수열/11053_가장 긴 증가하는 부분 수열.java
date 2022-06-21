import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {
  public static void main(String[] args) throws IOException{
    // set needed components
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());
    int[] A = new int[N];
    int[] dp = new int[N];
    StringTokenizer st = new StringTokenizer(br.readLine(), " ");
    for (int i = 0; i < N; i++) {
      A[i] = Integer.parseInt(st.nextToken());
      dp[i] = 1;
    } 

    // do dp
    for (int i = 0; i < N-1; i++){
      for (int j = i+1; j < N; j++){
        if (A[i] < A[j]){
          if (dp[i] == dp[j]) dp[j] = dp[i] + 1;
        }
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
}s