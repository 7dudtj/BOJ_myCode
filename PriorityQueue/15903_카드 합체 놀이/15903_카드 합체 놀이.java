import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.PriorityQueue;

public class Main {
  // set needed variables
  public static void main(String[] args) throws IOException{
    // set needed components
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine(), " ");
    int n = Integer.parseInt(st.nextToken());
    int m = Integer.parseInt(st.nextToken());
    long answer = 0;
    PriorityQueue<Long> pq = new PriorityQueue<>();

    // put initial data
    st = new StringTokenizer(br.readLine(), " ");
    for (int i = 0; i < n; i++) pq.add(Long.parseLong(st.nextToken()));

    // do merge for m times
    for (int i = 0; i < m; i++){
      long a = pq.poll();
      long b = pq.poll();
      pq.add(a+b);
      pq.add(a+b);
    }

    // get answer
    while (pq.peek() != null) answer += pq.poll();

    // print answer and end program
    System.out.println(answer);
    br.close();
    return;
  }
}

