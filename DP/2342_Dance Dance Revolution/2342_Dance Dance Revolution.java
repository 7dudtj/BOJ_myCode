import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.ArrayList;
import java.lang.Math;

public class Main {
  // set needed variables
  static ArrayList<Integer> input = new ArrayList<>();
  static int[][][] dp;

  public static void main(String[] args) throws IOException{
    // set needed components
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine(), " ");
    int s;

    // set list and dp table
    while (true){
      s = Integer.parseInt(st.nextToken());
      if (s == 0) break;
      input.add(s);
    }
    dp = new int[input.size()][5][5];

    // do process and print answer
    System.out.println(dfs(0, 0, 0));

    // end program
    br.close();
    return;
  }

  // dfs function
  private static int dfs(int idx, int left, int right){
    if (idx == input.size()) return 0;
    if (dp[idx][left][right] != 0) return dp[idx][left][right];

    int leftGo = dfs(idx + 1, input.get(idx), right) + move(left, input.get(idx));
    int rightGo = dfs(idx + 1, left, input.get(idx)) + move(right, input.get(idx));
    dp[idx][left][right] = Math.min(leftGo, rightGo);

    return dp[idx][left][right];
  }

  // move function
  private static int move(int from, int to){
    if (from == 0) return 2;
    else if (from == to) return 1;
    else if (Math.abs(from - to) == 2) return 4;
    else return 3;
  }
}s
