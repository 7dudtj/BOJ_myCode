import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Queue;
import java.util.LinkedList;

public class Main {
	public static void main(String args[]) throws Exception	{
    // set needed variables
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());
    Queue<Integer> q = new LinkedList<>();
    StringBuilder sb = new StringBuilder();

    // do process
    int x, last = 0;
    String s, t;
    for (int i = 0; i < N; i++){
      t = br.readLine();
      s = t.substring(0,2);

      // push
      if (s.equals("pu")){
        x = Integer.parseInt(t.substring(5));
        q.add(x);
        last = x;
      }
      // pop
      else if (s.equals("po")){
        if (q.isEmpty()) sb.append(-1).append('\n');
        else{
          sb.append(q.poll()).append('\n');
        }
      }
      // size
      else if (s.equals("si")){
        sb.append(q.size()).append('\n');
      }
      // empty
      else if (s.equals("em")){
        if (q.size() == 0) sb.append(1).append('\n');
        else sb.append(0).append('\n');
      }
      // front
      else if (s.equals("fr")){
        if (q.size() == 0) sb.append(-1).append('\n');
        else sb.append(q.peek()).append('\n');
      }
      // back
      else{
        if (q.size() == 0) sb.append(-1).append('\n');
        else sb.append(last).append('\n');
      }
    }

    // print answer and end program
    System.out.print(sb);
    br.close();
    return;
  }
}