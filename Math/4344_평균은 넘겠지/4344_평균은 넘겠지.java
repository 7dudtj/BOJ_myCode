import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main{
    public static void main(String[] args) throws IOException{
        // Set needed variables
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int C = Integer.parseInt(br.readLine());
        String[] tmp = null;
        int N = 0;
        float count = 0;
        float[] score = null;
        float mean = 0;
        StringBuilder sb = new StringBuilder();
        String answer = "";

        // Do testcases
        for (int i = 0; i < C; i++){
            // Get data
            tmp = br.readLine().split(" ");
            N = Integer.parseInt(tmp[0]);
            score = new float[N];
            for (int j = 0; j < N; j++){
                score[j] = Float.parseFloat(tmp[j + 1]);
            }

            // Calculate mean
            mean = 0;
            for (int j = 0; j < N; j++){
                mean += score[j];
            }
            mean /= N;

            // Count number of students
            count = 0;
            for (int j = 0; j < N; j++){
                if (score[j] > mean){
                    count += 1;
                }
            }

            // Save answer
            answer = String.format("%.3f", ((count / (float) N)) * 100);
            sb.append(answer).append("%\n");
        }

        // Print answer and end program
        System.out.print(sb);
        br.close();
        return;
    }
}