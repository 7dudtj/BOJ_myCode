import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main{
    public static void main(String[] args) throws IOException{
        // Set needed vairables
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] list = new int[N];
        String[] input = br.readLine().split(" ");
        br.close();
        int[] asc = new int[N];
        int[] des = new int[N];
        for (int i = 0; i < N; i++){
            list[i] = Integer.parseInt(input[i]);
            asc[i] = 1;
            des[i] = 1;
        }

        // Make asc list
        for (int i = 0; i < N - 1; i++){
            for (int j = i + 1; j < N; j++){
                if (list[i] < list[j]){
                    if (asc[i] == asc[j]){
                        asc[j]++;
                    }
                }
            }
        }
        
        // Make des list
        for (int i = N - 1; i > 0; i--){
            for (int j = i - 1; j >= 0; j--){
                if (list[i] < list[j]){
                    if (des[i] == des[j]){
                        des[j]++;
                    }
                }
            }
        }

        // Find answer
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < N; i++){
            if (max < asc[i] + des[i]){
                max = asc[i] + des[i];
            }
        }

        // Print answer and end program
        System.out.print(max - 1);
        return;
    }
}