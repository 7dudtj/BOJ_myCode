import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main{
    public static void main(String[] args) throws IOException{
        // Set needed variables
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] hist = new int[N + 2];
        for (int i = 1; i <= N; i++){
            hist[i] = Integer.parseInt(br.readLine());
        }
        br.close();
        Stack<Integer> s = new Stack<>();
        int answer = 0;

        // Find answer
        s.push(0);
        for (int i = 1; i <= N + 1; i++){
            while (!s.isEmpty()){
                int top = s.peek();
                if (hist[top] <= hist[i]) break;
                s.pop();
                answer = Math.max(answer, hist[top] * (i - s.peek() - 1));
            }
            s.push(i);
        }

        // Print answer and end program
        System.out.print(answer);
        return;
    }
}