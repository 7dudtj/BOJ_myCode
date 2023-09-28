import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main{
    public static void main(String[] args) throws IOException{
        // Set needed variables
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] first = br.readLine().toCharArray();
        char[] second = br.readLine().toCharArray();
        char[] third = br.readLine().toCharArray();
        br.close();
        int firstLen = first.length;
        int secondLen = second.length;
        int thirdLen = third.length;
        int[][][] dp = new int[firstLen + 1][secondLen + 1][thirdLen + 1];

        // Find LCS
        for (int i = 1; i <= firstLen; i++){
            for (int j = 1; j <= secondLen; j++){
                for (int k = 1; k <= thirdLen; k++){
                    if (first[i - 1] == second[j - 1] && second[j - 1] == third[k - 1]){
                        dp[i][j][k] = dp[i - 1][j - 1][k - 1] + 1;
                    }else{
                        dp[i][j][k] = Math.max(Math.max(dp[i - 1][j][k], dp[i][j - 1][k]), dp[i][j][k - 1]);
                    }
                }
            }
        }

        // Print answer and end program
        System.out.print(dp[firstLen][secondLen][thirdLen]);
        return;
    }
}