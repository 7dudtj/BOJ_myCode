import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.Arrays;
import java.util.List;
import java.util.LinkedList;

public class Main {
  public static void main(String[] args) throws IOException{
    // set needed components
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine(), " ");
    int n = Integer.parseInt(st.nextToken());
    int k = Integer.parseInt(st.nextToken());
    int[] allCoin = new int[n];
    int[] dp = new int[k+1];
    for (int i = 1; i <= k; i++) dp[i] = Integer.MAX_VALUE;
    List<Integer> coin = new LinkedList<>();

    // get coin
    for (int i = 0; i < n; i++) allCoin[i] = Integer.parseInt(br.readLine());
    br.close();

    // get coin set
    Arrays.sort(allCoin);
    if (allCoin[0] <= k) coin.add(allCoin[0]);
    for (int i = 1; i < n; i++){
      if (allCoin[i]!=allCoin[i-1] && allCoin[i] <= k) coin.add(allCoin[i]);
    }

    // basic setting for dp
    for (Integer v: coin) dp[v] = 1;

    // do dp
    for (int i = 1; i <= k; i++){
      for (Integer v: coin){
        if (v<=i && dp[i-v]!=Integer.MAX_VALUE){
          dp[i] = Math.min(dp[i], dp[i-v]+1);
        }
      }
    }
    
    // print answer and end program
    if (dp[k] == Integer.MAX_VALUE) System.out.print(-1);
    else System.out.print(dp[k]);
    return;
  }
}