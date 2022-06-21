import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
	public static void main(String args[]) throws IOException	{
    // set needed variables
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String s1 = br.readLine();
    String s2 = br.readLine();
    int[][] dp = new int[s2.length()+1][s1.length()+1];

    // do dp
    for (int i = 1; i <= s2.length(); i++){
      for (int j = 1; j <= s1.length(); j++){
        if (s2.substring(i-1,i).equals(s1.substring(j-1,j))){
          dp[i][j] = dp[i-1][j-1] + 1;
        }else{
          dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
        }
      }
    }

    // print answer and end program
    System.out.print(dp[s2.length()][s1.length()]);
    br.close();
    return;
  }
}