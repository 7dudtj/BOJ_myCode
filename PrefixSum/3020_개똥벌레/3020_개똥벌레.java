import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main{
    // Set needed static variables

    public static void main(String[] args) throws IOException{
        // Set needed variables
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] NH = br.readLine().split(" ");
        int N = Integer.parseInt(NH[0]);
        int H = Integer.parseInt(NH[1]);
        int[] lowerBarrier = new int[H + 1];
        int[] cumLowerBarrier = new int[H + 1];
        int[] upperBarrier = new int[H + 1];
        int[] cumUpperBarrier = new int[H + 1];
        int[] totalBarrier = new int[H + 1];
        int barrier = 0;
        int minValue = Integer.MAX_VALUE;
        int minCount = 0;

        // Get barrier information
        for (int i = 0; i < N; i++){
            barrier = Integer.parseInt(br.readLine());
            // Get lower barrier
            if (i % 2 == 0){
                lowerBarrier[barrier]++;
            }
            // Get upper barrier
            else{
                upperBarrier[barrier]++;
            }
        }
        br.close();

        // Get cumulative information
        cumLowerBarrier[H] = lowerBarrier[H];
        cumUpperBarrier[H] = upperBarrier[H];
        for (int i = H - 1; i >= 1; i--){
            cumLowerBarrier[i] = cumLowerBarrier[i + 1] + lowerBarrier[i];
            cumUpperBarrier[i] = cumUpperBarrier[i + 1] + upperBarrier[i];
        }

        // Calculate total barriers
        for (int i = 1; i <= H; i++){
            totalBarrier[i] = cumLowerBarrier[i] + cumUpperBarrier[H - i + 1];
        }

        // Find answer
        Arrays.sort(totalBarrier);
        minValue = totalBarrier[1];
        minCount = 1;
        for (int i = 2; i <= H; i++){
            if (totalBarrier[i] == minValue){
                minCount++;
            }else{
                break;
            }
        }

        // Print answer and end program
        System.out.printf("%d %d", minValue, minCount);
        return;
    }
}