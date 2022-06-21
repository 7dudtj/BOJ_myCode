import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {
	public static void main(String args[]) throws IOException	{
    // set needed variables
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine(), " ");
    long N = Long.parseLong(st.nextToken());
    int K = Integer.parseInt(st.nextToken());
    int Q = Integer.parseInt(st.nextToken());
    long x = 0, y = 0, answer;
    StringBuilder sb = new StringBuilder();

    // do query
    for (int i = 0; i < Q; i++){
      // get x and y
      st = new StringTokenizer(br.readLine(), " ");
      x = Long.parseLong(st.nextToken());
      y = Long.parseLong(st.nextToken());

      // if K == 1
      if (K == 1){
        sb.append(Math.abs(x-y)).append('\n');
        continue;
      }

      // if K != 1
      answer = 0;
      while (true){
        // find answer
        if (x == y){
          sb.append(answer).append('\n');
          break;
        }

        // x > y: decrease x
        if (x > y){
          x = (x + K - 2) / K;
          answer++;
        }

        // x < y: decrease y
        if (x < y){
          y = (y + K - 2) / K;
          answer++;
        }
      }
    }

    // print answer and end program
    System.out.print(sb);
    br.close();
    return;
  }
}