import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {
  // set needed variables
  public static void main(String[] args) throws IOException{
    // set needed components
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine(), " ");
    long a = Long.parseLong(st.nextToken());
    long b = Long.parseLong(st.nextToken());
    long c = Long.parseLong(st.nextToken());
    long answer;

    // do process
    answer = power(a%c, b, c);

    // print answer and end program
    System.out.println(answer);
    br.close();
    return;
  }

  // power function
  private static long power(long a, long b, long c){
    if (b == 1) return a;

    long temp = power(a, b/2, c) % c;

    if (b % 2 == 0) return (temp * temp) % c;
    else return (((temp * temp) % c) * a) % c;
  }
}

