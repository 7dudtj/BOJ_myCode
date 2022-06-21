import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {
	public static void main(String args[]) throws IOException	{
    // set needed variables
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());
    double[] p = new double[N+1];
    double answer = 0, a, b;

    // get data
    StringTokenizer st = new StringTokenizer(br.readLine(), " ");
    for (int i = 1; i <= N; i++){
      p[i] = Double.parseDouble(st.nextToken());
      answer += p[i];
    }

    // find answer
    for (int i = 1; i < N; i++){
      a = p[i];
      b = p[i+1];
      answer += calculate(a, b);
    }

    // print answer and end program
    System.out.print(answer);
    br.close();
    return;
  }

  // calculation function
  private static double calculate(double a, double b){
    return a*(1-b) + b*(1-a);
  }
}