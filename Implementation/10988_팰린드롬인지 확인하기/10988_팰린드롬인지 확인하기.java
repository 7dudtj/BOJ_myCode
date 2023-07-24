import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main{
    public static void main(String[] args) throws IOException{
        // Set needed variables
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        StringBuilder sb = new StringBuilder(input);
        String reverse = sb.reverse().toString();

        // Check and print answer
        if (input.equals(reverse)){
            System.out.print(1);
        }else{
            System.out.print(0);
        }

        // End prograrm
        br.close();
        return;
    }
}