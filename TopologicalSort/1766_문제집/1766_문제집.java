import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.List;
import java.util.LinkedList;
import java.util.PriorityQueue;

public class Main {
  // set static variables
  static StringBuilder sb = new StringBuilder();
  static int N;
  static List<Integer>[] graph;
  static int[] indegree;

  public static void main(String[] args) throws IOException{
    // set needed variables
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine(), " ");
    N = Integer.parseInt(st.nextToken());
    int M = Integer.parseInt(st.nextToken());
    graph = new List[N];
    for (int i = 0; i < N; i++) graph[i] = new LinkedList<>();
    indegree = new int[N];
    int A, B;

    // get graph
    for (int i = 0; i < M; i++){
      st = new StringTokenizer(br.readLine(), " ");
      A = Integer.parseInt(st.nextToken());
      B = Integer.parseInt(st.nextToken());
      graph[A-1].add(B-1);
      indegree[B-1]++;
    }

    // do topological sort
    ts();

    // print answer and end program
    System.out.println(sb);
    br.close();
    return;
  }

  // topological sort function
  public static void ts(){
    // set function variables
    PriorityQueue<Integer> pq = new PriorityQueue<>((o1, o2) -> o1 - o2);

    // set PriorityQueue
    for (int i = 0; i < N; i++){
      if (indegree[i] == 0) pq.add(i);
    }

    // do topological sort
    while (!pq.isEmpty()){
      int node = pq.poll();

      for (int v: graph[node]){
        indegree[v]--;
        if (indegree[v] == 0) pq.add(v);
      }

      sb.append(node+1).append(" ");
    }
  }
}
