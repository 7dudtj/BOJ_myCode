import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main{
    public static void main(String[] args) throws IOException{
        // Set needed variables
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] A = new int[N];
        String[] input = br.readLine().split(" ");
        for (int i = 0; i < N; i++){
            A[i] = Integer.parseInt(input[i]);
        }
        input = br.readLine().split(" ");
        br.close();
        int B = Integer.parseInt(input[0]);
        int C = Integer.parseInt(input[1]);
        long answer = 0;

        // Calculate answer
        for (int i = 0; i < N; i++){
            answer += 1;
            A[i] -= B;
            if (A[i] > 0){
                answer += A[i] / C;
                if (A[i] % C != 0){
                    answer += 1;
                }
            }
        }

        // Print answer and end program
        System.out.print(answer);
        return;
    }
}