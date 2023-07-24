import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main{
    public static void main(String[] args) throws IOException{
        // Set needed variables
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        br.close();
        StringBuilder total = new StringBuilder();
        StringBuilder sub = null;

        // Make answer
        for (int i = 1; i <= N; i++){
            sub = new StringBuilder();
            for (int j = 1; j <= i; j++){
                sub.append("*");
            }
            total.append(sub.toString()).append("\n");
        }

        // Print answer and end program
        System.out.print(total.toString());
        return;
    }
}