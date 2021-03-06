import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.lang.Math;

// buttom-up DP
public class Main {
  // set needed variables
  public static void main(String[] args) throws IOException{
    // set needed components
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;
    int T = Integer.parseInt(br.readLine());

    // do process for T times
    for (int t = 0; t < T; t++){
      // get K
      int K = Integer.parseInt(br.readLine());
      // get chapters
      int[] chap = new int[K];
      st = new StringTokenizer(br.readLine(), " ");
      for (int i = 0; i < K; i++) chap[i] = Integer.parseInt(st.nextToken());
      // make DP table
      int[][] memo = new int[K][K];
      for (int i = 0; i < K-1; i++) memo[i][i+1] = chap[i] + chap[i+1];
      for (int gap = 2; gap < K; gap++){
        for (int i = 0; i+gap < K; i++){
          int j = i + gap;
          memo[i][j] = Integer.MAX_VALUE;
          int sum = 0;
          for (int m = i; m <= j; m++) sum += chap[m];

          for (int k = i; k < j; k++){
            memo[i][j] = Math.min(memo[i][j], memo[i][k]+memo[k+1][j]+sum);
          }
        }
      }
      // print answer
      System.out.println(memo[0][K-1]);
    }
    // end program
    br.close();
    return;
  }
}

