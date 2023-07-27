import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main{
    public static void main(String[] args) throws IOException{
        // Set needed variables
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = null;
        StringBuilder sb = new StringBuilder();

        // Do modulo calculation
        while ((input = br.readLine()) != null){
            int n = Integer.parseInt(input);
            int base = 1;
            int count = 1;
            while ((base = base % n) != 0){
                base = base * 10 + 1;
                count++;
            }
            sb.append(count).append('\n');
        }

        // Print answer and end program
        System.out.print(sb.toString());
        br.close();
        return;
    }
}