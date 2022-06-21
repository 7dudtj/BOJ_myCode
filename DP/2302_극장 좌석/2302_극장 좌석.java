import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
  public static void main(String[] args) throws IOException{
    // set needed components
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());
    boolean[] vip = new boolean[N+1];
    int M = Integer.parseInt(br.readLine());
    int answer = 1, count = 0;
    int[] dp = new int[41];

    // get vip
    for (int i = 0; i < M; i++){
      vip[Integer.parseInt(br.readLine())] = true;
    }
    
    // do dp
    dp[0] = 1; dp[1] = 1;
    for (int i = 2; i <= 40; i++) dp[i] = dp[i-1]+dp[i-2];
    
    // calculate
    for (int i = 1; i <= N; i++){
      if (vip[i]){
        if (count != 0) answer *= dp[count];
        count = 0;
      }else{
        count++;
      }
    }
    if (count != 0) answer *= dp[count];

    // print answer and end program
    System.out.print(answer);
    br.close();
    return;
  }
}