import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.PriorityQueue;

public class Main {
  // set needed static variables
  public static void main(String[] args) throws IOException{
    // set needed variables
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();
    int N = Integer.parseInt(br.readLine());
    PriorityQueue<Integer> min = new PriorityQueue<>((o1, o2) -> o1 - o2);
    PriorityQueue<Integer> max = new PriorityQueue<>((o1, o2) -> o2 - o1);
    int input;

    // main process
    for (int i = 0; i < N; i++){
      // get input
      input = Integer.parseInt(br.readLine());

      // even: to max, odd: to min
      if (i % 2 == 0) max.add(input);
      else min.add(input);

      // compare min and max
      if (!max.isEmpty() && !min.isEmpty()){
        if (min.peek() < max.peek()){
          int tmp = max.poll();
          max.add(min.poll());
          min.add(tmp);
        }
      }

      // get answer
      sb.append(max.peek()).append('\n');
    }

    // print answer and end program
    System.out.print(sb);
    br.close();
    return;
  }
}
