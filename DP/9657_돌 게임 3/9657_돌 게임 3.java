import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
  // set needed variables
  public static void main(String[] args) throws IOException{
    // set needed components
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());
    br.close();
    int[] pick = {1,3,4};

    // exception handling
    if (N == 2){
      System.out.print("CY");
      return;
    }
    if (N == 1 || N == 3 || N == 4){
      System.out.print("SK");
      return;
    }

    // do dp (N >= 5, O(3N))
    boolean[] dp = new boolean[N+1];
    boolean find;
    dp[1] = true; dp[2] = false; dp[3] = true; dp[4] = true;
    for (int i = 5; i <= N; i++){
      find = false;
      for (int p: pick){
        if (dp[i-p] == false) find = true;
      }
      if (find) dp[i] = true;
      else dp[i] = false;
    }

    // print answer and end program
    if (dp[N]) System.out.print("SK");
    else System.out.print("CY");
    return;
  }
}