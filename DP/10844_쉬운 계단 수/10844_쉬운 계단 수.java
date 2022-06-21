import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
  public static void main(String[] args) throws IOException{
    // set needed components
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());
    int[][] dp = new int[10][N];
    int answer = 0;

    // do dp
    for (int i = 1; i <= 9; i++) dp[i][0] = 1;
    for (int i = 1; i < N; i++){
      dp[0][i] = dp[1][i-1];
      for (int j = 1; j <= 8; j++){
        dp[j][i] = (dp[j-1][i-1]+dp[j+1][i-1])%1000000000;
      }
      dp[9][i] = dp[8][i-1];
    }

    // get answer
    for (int i = 0; i < 10; i++){
      answer = (answer + dp[i][N-1])%1000000000;
    }

    // print answer and end program
    System.out.print(answer);
    br.close();
    return;
  }
}