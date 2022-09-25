import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.io.IOException;

public class Main {
	public static void main(String args[]) throws IOException	{
    // set needed variables
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());
    long answer = 0;
    PriorityQueue<Integer> pq = new PriorityQueue<>();

    // get input
    for (int i = 0; i < N; i++)
      pq.add(Integer.parseInt(br.readLine()));

    // if N == 1
    if (N == 1){
      System.out.println(0);
      br.close();
      return;
    }
    
    // do main process
    int first, second;
    while (true){
      if (pq.size() == 1){
        break;
      }
      first = pq.poll();
      second = pq.poll();
      answer += (first+second);
      pq.add(first+second);
    }

    // print answer and end program
    System.out.println(answer);
    br.close();
    return;
  }
}