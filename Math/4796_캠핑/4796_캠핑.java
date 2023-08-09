import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main{
    public static void main(String[] args) throws IOException{
        // Set needed variables
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String endCode = "0 0 0";
        StringBuilder sb = new StringBuilder();
        String input = null;
        int count = 0;

        // Find answer
        while (!(input = br.readLine()).equals(endCode)){
            // Get data
            String[] tmp = input.split(" ");
            int L = Integer.parseInt(tmp[0]);
            int P = Integer.parseInt(tmp[1]);
            int V = Integer.parseInt(tmp[2]);
            int caseAnswer = (V / P) * L + Math.min(L, (V % P));

            // Make answer
            count++;
            String answer = String.format("Case %d: %d\n", count, caseAnswer);
            sb.append(answer);
        }

        // Print answer and end program
        System.out.print(sb.toString());
        br.close();
        return;
    }
}