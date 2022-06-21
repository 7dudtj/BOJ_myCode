import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.PriorityQueue;
import java.util.Collections;

public class Main {
  // set needed variables
  public static void main(String[] args) throws IOException{
    // set needed components
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;
    int N = Integer.parseInt(br.readLine());
    PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
    int answer = 0;

    // get data
    for (int i = 0; i < N; i++){
      st = new StringTokenizer(br.readLine(), " ");
      for (int j = 0; j < N; j++){
        pq.add(Integer.parseInt(st.nextToken()));
      }
    }

    // get answer
    for (int i = 0; i < N; i++) answer = pq.poll();

    // print answer and end program
    System.out.println(answer);
    br.close();
    return;
  }
}
