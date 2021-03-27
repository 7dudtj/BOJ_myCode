import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.Deque;
import java.util.LinkedList;

public class Main {
  // set needed static variables
  public static void main(String[] args) throws IOException{
    // set needed variables
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;
    StringBuilder sb = new StringBuilder();
    Deque<Node> dq = new LinkedList<>();

    // get N, L
    st = new StringTokenizer(br.readLine(), " ");
    int N = Integer.parseInt(st.nextToken());
    int L = Integer.parseInt(st.nextToken());  

    // do main process
    st = new StringTokenizer(br.readLine(), " ");
    for (int i = 1; i <= N; i++){
      // get data
      int tmp = Integer.parseInt(st.nextToken());
      // delete useless node
      while (!dq.isEmpty() && dq.getLast().value > tmp) dq.removeLast();
      // add new node
      dq.addLast(new Node(tmp, i));
      // delete old node
      if (dq.getFirst().index <= i - L) dq.removeFirst();
      // get answer
      sb.append(dq.getFirst().value).append(" ");
    }
    
    // print answer and end program
    System.out.print(sb);
    br.close();
    return;
  }
}

// Node class
class Node{
  int value;
  int index;
  public Node(int v, int i){
    value = v;
    index = i;
  }
}
