import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {
  // set needed variables
  static int n, k;

  public static void main(String[] args) throws IOException{
    // set needed components
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine(), " ");
    n = Integer.parseInt(st.nextToken());
    k = Integer.parseInt(st.nextToken());
    int answer = 0;

    // do dynamic programming
    answer = dp(n, k);

    // print answer and end program
    System.out.print(answer);
    br.close();
    return;
  }

  // dynamic programming function
  private static int dp(int n, int k){
    // find answer
    int[][] map = new int[n+1][k+1];
    for (int i = 1; i < n+1; i++){
      for (int j = 0; j < k+1; j++){
        // fill 0
        if (i == j || j == 0){
          map[i][j] = 1;
        }
        // dp
        else{
          map[i][j] = (map[i-1][j-1] + map[i-1][j]) % 10007;
        }
      }
    }

    return map[n][k];
  }
}
