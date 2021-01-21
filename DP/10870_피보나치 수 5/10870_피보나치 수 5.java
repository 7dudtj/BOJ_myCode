import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
  public static void main(String[] args) throws IOException{
    // set needed components
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());
    if (N == 0){
      System.out.print(0);
      return;
    }
    fib(N);
  }

  // n >= 1
  public static void fib(int n){
    int[] memo = new int[n+1];
    memo[0] = 0; memo[1] = 1;

    for (int i = 2; i <= n; i++){
      memo[i] = memo[i-1] + memo[i-2];
    }

    System.out.print(memo[n]);
  }
}
