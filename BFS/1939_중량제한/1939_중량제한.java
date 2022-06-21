import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.List;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
  static List<Edge>[] adjList;
  static int f1, f2, N;
	public static void main(String args[]) throws IOException	{
    // set needed variables
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine(), " ");
    N = Integer.parseInt(st.nextToken());
    int M = Integer.parseInt(st.nextToken());
    adjList = new List[N+1];
    for (int i = 1; i <= N; i++) adjList[i] = new LinkedList<>();

    // get map
    int A, B, C;
    for (int i = 0; i < M; i++){
      st = new StringTokenizer(br.readLine(), " ");
      A = Integer.parseInt(st.nextToken());
      B = Integer.parseInt(st.nextToken());
      C = Integer.parseInt(st.nextToken());

      adjList[A].add(new Edge(B, C));
      adjList[B].add(new Edge(A, C));
    }

    // get factory number
    st = new StringTokenizer(br.readLine(), " ");
    f1 = Integer.parseInt(st.nextToken());
    f2 = Integer.parseInt(st.nextToken());

    // do binary search
    int start = 0;
    int end = 1000000000;
    int mid;
    boolean possible;
    while (start <= end){
      // reset data
      mid = (start + end) / 2;
      possible = false;

      // check path
      possible = searchPath(mid);

      // adjust value
      if (possible) start = mid + 1;
      else end = mid - 1;
    }

    // print answer and end program
    System.out.println(end);
    br.close();
    return;
  }

  // search path by bfs
  private static boolean searchPath(int weight){
    // set needed variables
    Queue<Edge> q = new LinkedList<>();
    boolean[] visited = new boolean[N+1];

    // set data
    q.add(new Edge(f1, 0));
    visited[f1] = true;

    // main loop
    Edge tmp;
    while (!q.isEmpty()){
      tmp = q.poll();
      // find way at given weight
      if (tmp.adj == f2) return true;

      for (Edge e: adjList[tmp.adj]){
        if (e.w >= weight && !visited[e.adj]){
          visited[e.adj] = true;
          q.add(e);
        }
      }
    }

    // impossible
    return false;
  }
}

// Edge class
class Edge{
  int adj;
  int w;
  public Edge(int adj, int w){
    this.adj = adj;
    this.w = w;
  }
}