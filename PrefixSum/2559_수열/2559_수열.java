import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main{
	public static void main(String[] args) throws IOException{
		// set needed variables
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String[] inputs = br.readLine().split(" ");
    int N = Integer.parseInt(inputs[0]);
    int K = Integer.parseInt(inputs[1]);
    int[] temps = new int[N];
    inputs = br.readLine().split(" ");
    for (int i = 0; i < N; i++){
      temps[i] = Integer.parseInt(inputs[i]);
    }
    int answer = Integer.MIN_VALUE;
    int window = 0;

    // find first continuous value
    for (int i = 0; i < K; i++){
      window += temps[i];
    }
    answer = window;

    // find maximum window
    for (int i = 1; i <= N - K; i++){
      // slide window
      window -= temps[i - 1];
      window += temps[i + K - 1];

      // find big window
      if (window > answer){
        answer = window;
      }
    }

    // print answer and end program
    System.out.print(answer);
    br.close();
    return;
	}
}