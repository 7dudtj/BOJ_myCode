import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.Queue;
import java.util.LinkedList;

public class Main {
  public static void main(String[] args) throws IOException{
    // set needed variables
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine(), " ");
    long A = Long.parseLong(st.nextToken());
    long B = Long.parseLong(st.nextToken());

    // do BFS
    int answer = bfs(A, B);

    // print answer and end program
    System.out.println(answer);
    br.close();
    return;
  }

  // BFS function
  private static int bfs(long a, long b){
    Queue<Node> q = new LinkedList<>();
    q.add(new Node(a, 1));

    while (!q.isEmpty()){
      Node tmp = q.poll();

      // find b
      if (tmp.adj == b) return tmp.level;

      // do main process
      if (tmp.adj*2 <= 1000000000) q.add(new Node(tmp.adj*2, tmp.level + 1));
      if (tmp.adj*10 + 1 <= 1000000000) q.add(new Node(tmp.adj*10 + 1, tmp.level + 1));
    }

    return -1;
  }

  // 2의 제곱수인지 체크
  private static boolean two(long a){
    while (true){
      if (a == 1) return true;
      if (a % 2 != 0) return false;
      a = a / 2;
    }
  }
}

// Node class
class Node{
  long adj;
  int level;
  public Node (long adj, int level){
    this.adj = adj;
    this.level = level;
  }
}
