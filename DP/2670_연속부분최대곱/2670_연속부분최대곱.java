import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
	public static void main(String args[]) throws IOException	{
    // set needed variables
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());
    double[] input = new double[N];

    // get input
    for (int i = 0; i < N; i++){
      input[i] = Double.parseDouble(br.readLine());
    }

    // do dp
    double max = input[0];
    for (int i = 1; i < N; i++){
      input[i] = Math.max(input[i], input[i] * input[i-1]);
      max = Math.max(max, input[i]);
    }

    // print answer and end program
    System.out.println(String.format("%.3f", max));
    br.close();
    return;
  }
}