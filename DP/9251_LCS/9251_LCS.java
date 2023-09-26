import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main{
    public static void main(String[] args) throws IOException{
        // Set needed variables
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] first = br.readLine().toCharArray();
        char[] second = br.readLine().toCharArray();
        br.close();
        int[][] dp = new int[first.length + 1][second.length + 1];

        // Do dp
        for (int i = 1; i <= first.length; i++){
            for (int j = 1; j <= second.length; j++){
                if (first[i - 1] == second[j - 1]){
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                }else{
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }

        // Print answer and end program
        System.out.print(dp[first.length][second.length]);
        return;
    }
}