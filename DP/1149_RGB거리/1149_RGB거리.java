import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.Arrays;

public class Main {

  // set needed variables
  final static int RED = 0;
  final static int GREEN = 1;
  final static int BLUE = 2;

  static int[][] cost;
  static int[][] dp;

  public static void main(String[] args) throws IOException{
    // set needed components
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());
    cost = new int[N+1][3];
    dp = new int[N+1][3];
    int[] answer = new int[3];

    // get cost data
    for (int i = 1; i <= N; i++){
      StringTokenizer st = new StringTokenizer(br.readLine(), " ");

      cost[i][RED] = Integer.parseInt(st.nextToken());
      cost[i][GREEN] = Integer.parseInt(st.nextToken());
      cost[i][BLUE] = Integer.parseInt(st.nextToken());
    }

    // preset first house
    dp[1][RED] = cost[1][RED];
    dp[1][GREEN] = cost[1][GREEN];
    dp[1][BLUE] = cost[1][BLUE];

    // do process
    answer[RED] = calCost(N, RED);  
    answer[GREEN] = calCost(N, GREEN);
    answer[BLUE] = calCost(N, BLUE);
    Arrays.sort(answer);

    // print answer and end program
    System.out.print(answer[0]);
    br.close();
    return;
  }

  // cost calculating function using dp
  public static int calCost(int N, int color){
    // not done. do process
    if (dp[N][color] == 0){
      // color: red
      if (color == RED){
        dp[N][RED] = Math.min(calCost(N-1, GREEN), calCost(N-1, BLUE)) + cost[N][RED];
      }
      // color: green
      else if (color == GREEN){
        dp[N][GREEN] = Math.min(calCost(N-1, RED), calCost(N-1, BLUE)) + cost[N][GREEN];
      }
      // color: blue
      else{
        dp[N][BLUE] = Math.min(calCost(N-1, RED), calCost(N-1, GREEN)) + cost[N][BLUE];
      }  
    }

    return dp[N][color];
  }
}
