import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.lang.Math;

public class Main {
  // set needed variables
  public static void main(String[] args) throws IOException{
    // set needed components
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine(), " ");
    long min = Long.parseLong(st.nextToken());
    long max = Long.parseLong(st.nextToken());
    int len = (int)(max - min + 1);
    boolean[] state = new boolean[len];
    int answer = 0;

    // do main process
    for (long i = 2; i*i <= max; i++){
      long start = min % (i*i) == 0 ? 0 : i*i - (min % (i*i));
      for (long j = start; j < len; j += (i*i)){
        state[(int)j] = true;
      }
    }

    // count answer
    for (int i = 0; i < len; i++){
      if (!state[i]) answer++;
    }

    // print answer and end program
    System.out.println(answer);
    br.close();
    return;
  }
}
