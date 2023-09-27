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

        // Make LCS
        int lcsLength = dp[first.length][second.length];
        char[] myLcs = new char[lcsLength];
        int iIdx = first.length;
        int jIdx = second.length;
        int count = lcsLength;
        while (iIdx > 0 && jIdx > 0 && count > 0){
            if (dp[iIdx][jIdx - 1] == dp[iIdx][jIdx]){
                jIdx--;
            }else if (dp[iIdx - 1][jIdx] == dp[iIdx][jIdx]){
                iIdx--;
            }else{
                // Find LCS char
                count--;
                myLcs[count] = first[iIdx - 1];
                iIdx--;
                jIdx--;
            }
        }

        // Print answer and end program
        System.out.println(lcsLength);
        if (lcsLength != 0){
            System.out.println(new String(myLcs));
        }    
        return;
    }
}