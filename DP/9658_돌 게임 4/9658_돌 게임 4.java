import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
  public static void main(String[] args) throws IOException{
    // set needed components
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine()); br.close(); 
    int[] dp = new int[N+1];
    int[] pick = {1, 3, 4};
    boolean find;

    // exception handling
    if (N <= 4){
      if (N==1 || N==3) System.out.print("CY");
      else System.out.print("SK");
      return;
    } 

    // do dp
    dp[2] = 1; dp[4] = 1;
    for (int i = 5; i <= N; i++){
      find = false;
      for (int v: pick){
        if (dp[i-v] == 0) {
          find = true;
          break;
        }
      }
      if (find) dp[i] = 1;
    }

    // print answer and end program
    if (dp[N] == 1) System.out.print("SK");
    else System.out.print("CY");
    return;
  }
}