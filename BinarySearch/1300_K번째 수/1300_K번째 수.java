import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main{
    // Set needed static variables
    static int N = 0;

    public static void main(String[] args) throws IOException{
        // Set needed variables
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        int k = Integer.parseInt(br.readLine());
        br.close();
        int left = 1;
        int right = k;
        int mid = 0;
        long count = 0;

        // Do binary search
        while (left < right){
            mid = (left + right) / 2;
            count = countNum(mid);

            if (count < k){
                left = mid + 1;
            }else {
                right = mid;
            }
        }

        // Print answer and end program
        System.out.print(left);
        return;
    }

    // Count the number of small values
    private static long countNum(int val){
        // Set function variables
        long answer = 0;

        // Calculate answer
        for (int i = 1; i <= N; i++){
            answer += Math.min(val / i, N);
        }

        return answer;
    }
}