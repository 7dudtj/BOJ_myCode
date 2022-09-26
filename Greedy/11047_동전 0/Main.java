import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main{
    public static void main(String[] args) throws IOException{

        // set needed variables
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[] A = new int[N+1];
        int answer = 0, quotient = 0;

        // get coin's value A
        for (int i = 1; i <= N; i++){
            A[i] = Integer.parseInt(br.readLine());
        }

        // find minimum number of coins
        for (int i = N; i >= 1; i--){

            quotient = K / A[i];
            if (quotient != 0){
                answer += quotient;
                K -= A[i] * quotient;
            }
            
            if (K == 0) break;
        }

        // print answer and end program
        System.out.print(answer);
        br.close();
        return;
    }
}