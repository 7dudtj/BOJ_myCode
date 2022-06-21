import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.math.BigInteger;

public class Main {
  public static void main(String[] args) throws IOException{
    // set needed components
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String n = null;

    // do dp
    BigInteger[] dp = new BigInteger[251];
    dp[0] = BigInteger.ONE;
    dp[1] = BigInteger.ONE;
    for (int i = 2; i <= 250; i++){
      dp[i] = dp[i-1].add(dp[i-2].multiply(BigInteger.TWO));
    }
    
    // get input and answer
    while ((n = br.readLine()) != null){
      System.out.println(dp[Integer.parseInt(n)]);
    }
    br.close();
    return;
  }
}