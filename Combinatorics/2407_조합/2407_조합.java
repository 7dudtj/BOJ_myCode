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
    int n, m;
    BigInteger answer = BigInteger.ZERO;

    // get n and m (n >= m)
    st = new StringTokenizer(br.readLine(), " ");
    n = Integer.parseInt(st.nextToken());
    m = Integer.parseInt(st.nextToken());

    // preset memo
    memo = new BigInteger[n+1][n+1];
    for (int i = 0; i < n+1; i++){
      for (int j = 0; j < n+1; j++){
        if (i == 0 && j == 0) memo[i][j] = BigInteger.ZERO;
        else if (i == j) memo[i][j] = BigInteger.ONE;
        else if (j == 0) memo[i][j] = BigInteger.ONE;
        else if (j == 1) memo[i][j] = BigInteger.valueOf(i);
        else if (i < j) memo[i][j] = BigInteger.ZERO;
        else memo[i][j] = BigInteger.ZERO;
      }
    }

    // check m
    int temp = n-m;
    if (temp < m) m = temp;

    // do combination
    answer = comb(n, m);

    // print answer and end program
    System.out.println(answer);
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
