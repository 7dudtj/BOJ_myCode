import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {
  public static void main(String[] args) throws IOException{
    // set needed components
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    long T, x, y, input, answer;
    StringTokenizer st;

    // get T
    T = Integer.parseInt(br.readLine());

    // do process
    for (int i = 0; i < T; i++){
      st = new StringTokenizer(br.readLine(), " ");
      x = Integer.parseInt(st.nextToken());
      y = Integer.parseInt(st.nextToken());
      input = y - x;
      answer = flying(input);
      System.out.println(answer);
    }

    // end program
    br.close();
    return;
  }

  public static long flying(long input){
    long from = 1, to = 2, token = 1, count = 1;

    while (true){
      if (from <= input && input < to) return count;
      else{
        count++;
        from = to;
        to += token;
        if (from <= input && input < to) return count;
        else {
          token++;
          count++;
          from = to;
          to += token;
        }
      }
    }
  }
}
