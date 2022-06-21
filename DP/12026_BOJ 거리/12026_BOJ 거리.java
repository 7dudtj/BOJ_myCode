import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
  public static void main(String[] args) throws IOException{
    // set needed components
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());
    String input = br.readLine();
    String cur;
    int[] dp = new int[N];
    for (int i = 0; i < N; i++) dp[i] = Integer.MAX_VALUE;
    dp[0] = 1;

    // do dp
    for (int i = 0; i < N-1; i++){
      if (dp[i] != Integer.MAX_VALUE){
        cur = input.substring(i,i+1);
        if (cur.equals("B")){
          for (int j = i+1; j < N; j++){
            if (input.substring(j,j+1).equals("O")){
              dp[j] = Math.min(dp[j], dp[i] + (j-i)*(j-i));
            }
          }
        }else if (cur.equals("O")){
          for (int j = i+1; j < N; j++){
            if (input.substring(j,j+1).equals("J")){
              dp[j] = Math.min(dp[j], dp[i] + (j-i)*(j-i));
            }
          }
        }else if (cur.equals("J")){
          for (int j = i+1; j < N; j++){
            if (input.substring(j,j+1).equals("B")){
              dp[j] = Math.min(dp[j], dp[i] + (j-i)*(j-i));
            }
          }
        }
      }
    }

    // print answer and end program
    if (dp[N-1] == Integer.MAX_VALUE) System.out.print(-1);
    else System.out.print(dp[N-1]-1);
    br.close();
    return;
  }
}