import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;

public class Main{
    public static void main(String[] args) throws IOException{
        // Set needed variables
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        HashMap<String, Integer> dict = new HashMap<>();
        int answer = 0;

        // Make hash table
        for (int i = 1; i <= N; i++){
            dict.put(br.readLine(), i);
        }

        // Get output list
        int[] output = new int[N];
        for (int i = 0; i < N; i++){
            output[i] = dict.get(br.readLine());
        }
        br.close();

        // Find answer
        for (int i = 0; i < N - 1; i++){
            for (int j = i + 1; j < N; j++){
                if (output[i] > output[j]){
                    answer++;
                    break;
                }
            }
        }

        // Print answer and end program
        System.out.print(answer);
        return;
    }
}