import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.lang.Math;
import java.util.Arrays;

// buttom-up DP
public class Main {
  // set needed variables
  public static void main(String[] args) throws IOException{
    // set needed components
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;
    int n = Integer.parseInt(br.readLine());
    int[][] map = new int[n][n];
    int[][] memo = new int[n][n];

    // get map
    for (int i = 0; i < n; i++){
      st = new StringTokenizer(br.readLine(), " ");
      for (int j = 0; j < i+1; j++){
        map[i][j] = Integer.parseInt(st.nextToken());
      }
    }

    // do DP
    memo[0][0] = map[0][0];
    for (int i = 1; i < n; i++){
      for (int j = 0; j < i+1; j++){
        if (j == 0){
          memo[i][j] = memo[i-1][j] + map[i][j];
        }else{
          memo[i][j] = Math.max(memo[i-1][j-1], memo[i-1][j]) + map[i][j];
        }
      }
    }

    // find answer
    int[] answer = new int[n];
    for (int i = 0; i < n; i++) answer[i] = memo[n-1][i];
    Arrays.sort(answer);

    // print answer and end program
    System.out.print(answer[n-1]);
    br.close();
    return;
  }
}
