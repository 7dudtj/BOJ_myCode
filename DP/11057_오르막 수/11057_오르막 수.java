import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
  public static void main(String[] args) throws IOException{
    // set needed components
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());
    int[][] dp = new int[100][N+1];

    // do dp
    for (int i = 0; i < 10; i++) dp[i][1] = 1;
    for (int i = 2; i <= N; i++){
      for (int j = 0; j <= 9; j++){
        for (int k = 0; k <= j; k++) dp[j][i] += dp[k][i-1];
        dp[j][i] %= 10007;
      }
    }

    // get answer
    int answer = 0; 
    for (int i = 0; i < 10; i++) answer += dp[i][N];
    answer %= 10007;

    // print answer and end program
    System.out.print(answer);
    br.close();
    return;
  }
}