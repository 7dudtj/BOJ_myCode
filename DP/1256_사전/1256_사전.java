import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.math.BigInteger;

// buttom-up DP
public class Main {
  // set needed variables
  static BigInteger[][] memo;

  public static void main(String[] args) throws IOException{
    // set needed components
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;
    StringBuilder sb = new StringBuilder();
    int n, m;
    BigInteger k;
    String answer = "";

    // get n and m
    st = new StringTokenizer(br.readLine(), " ");
    n = Integer.parseInt(st.nextToken());
    m = Integer.parseInt(st.nextToken());
    k = BigInteger.valueOf(Integer.parseInt(st.nextToken()));

    // preset memo
    memo = new BigInteger[n+m+1][n+m+1];
    for (int i = 0; i < n+m+1; i++){
      for (int j = 0; j < n+m+1; j++){
        if (i == 0 && j == 0) memo[i][j] = BigInteger.ONE;
        else if (i == j) memo[i][j] = BigInteger.ONE;
        else if (j == 0) memo[i][j] = BigInteger.ONE;
        else if (j == 1) memo[i][j] = BigInteger.valueOf(i);
        else if (i < j) memo[i][j] = BigInteger.ZERO;
        else memo[i][j] = BigInteger.ZERO;
      }
    }

    // do combination
    k = k.subtract(BigInteger.ONE);
    if (comb(n+m, m).compareTo(k) <= 0) {
      System.out.println(-1);
    }
    else{
      for (int i = n+m-1; i >= 0; i--){
        if (i >= m && memo[i][m].compareTo(k) > 0){
          sb.append("a");
        }else{
          sb.append("z");
          k = k.subtract(memo[i][m]);
          m--;
        }
      }
      System.out.print(sb);
    }

    // print answer and end program
    br.close();
    return;
  }

  // combination function
  public static BigInteger comb(int n, int m){

    // calculate by using buttom-up DP
    for (int i = 2; i < n+1; i++){
      for (int j = 1; j <= i-1; j++){
        memo[i][j] = memo[i-1][j-1].add(memo[i-1][j]);
      }
    }

    return memo[n][m];
  }
}
