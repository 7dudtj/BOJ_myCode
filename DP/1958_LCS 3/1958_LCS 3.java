import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
	public static void main(String args[]) throws IOException	{
    // set needed variables
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String s1 = br.readLine();
    String s2 = br.readLine();
    String s3 = br.readLine();
    int[][][] dp = new int[s1.length()+1][s2.length()+1][s3.length()+1];

    // do dp
    for (int i = 1; i <= s1.length(); i++){
      for (int j = 1; j <= s2.length(); j++){
        for (int k = 1; k <= s3.length(); k++){
          if (s1.substring(i-1,i).equals(s2.substring(j-1,j)) && 
          s2.substring(j-1,j).equals(s3.substring(k-1,k))){
            dp[i][j][k] = dp[i-1][j-1][k-1] + 1;
          }else{
            dp[i][j][k] = 
            Math.max(dp[i-1][j][k], Math.max(dp[i][j-1][k], dp[i][j][k-1]));
          }
        }
      }
    }

    // print answer and end program
    System.out.println(dp[s1.length()][s2.length()][s3.length()]);
    br.close();
    return;
  }
}