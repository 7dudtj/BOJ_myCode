import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
  public static void main(String[] args) throws IOException{
    // set needed components
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine()); br.close();
    int[] tri = new int[121];
    int[] size = new int[121];
    int[] dp = new int[N+1];
    for (int i = 1; i <= N; i++) dp[i] = Integer.MAX_VALUE;
    int idx = 1;

    // exception handling
    if (N == 1){
      System.out.print(1);
      return;
    }

    // calculate size
    int count = 1;
    for (int i = 1; i <= 120; i++){
      tri[i] = tri[i-1]+count;
      count++;
      size[i] = size[i-1]+tri[i];
    }

    // basic setting for dp
    for (int i = 1; i <= 120; i++){
      if (size[i] <= N) dp[size[i]] = 1;
    }

    // do dp
    for (int i = 2; i <= N; i++){
      // dp[i] == 1
      if (dp[i] == 1) idx++;
      // dp[i] != 1
      else{
        for (int j = idx; j >= 1; j--){
          dp[i] = Math.min(dp[i], 1+dp[i-size[j]]);
        }
      }
    }
    
    // print answer and end program
    System.out.print(dp[N]);
    return;
  }
}