import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Arrays;

// buttom-up DP
public class Main {
  public static void main(String[] args) throws IOException{
    // set needed components
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());
    int[] memo = new int[N+1];
    memo[0] = 0; memo[1] = 0;

    // do process
    for (int i = 2; i <= N; i++){
      memo[i] = memo[i-1] + 1;
      if (i % 3 == 0) memo[i] = Math.min(memo[i], memo[i/3] + 1);
      if (i % 2 == 0) memo[i] = Math.min(memo[i], memo[i/2] + 1);
    }

    // print answer and end program
    System.out.print(memo[N]);
    br.close();
    return;
  }
}
