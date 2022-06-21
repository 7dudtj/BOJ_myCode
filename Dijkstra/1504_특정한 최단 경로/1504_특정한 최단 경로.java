import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.List;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Comparator;

public class Main {
  static int[] distance;
  static boolean[] visited;
  static int N;
  static List<Edge>[] adjList;
	public static void main(String args[]) throws IOException	{
    // set needed variables
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    N = Integer.parseInt(st.nextToken());
    int E = Integer.parseInt(st.nextToken());
    adjList = new List[N+1];
    for (int i = 1; i <= N; i++) adjList[i] = new LinkedList<>();
    int v1, v2;

    // get map
    int a, b, c;
    for (int i = 0; i < E; i++){
      st = new StringTokenizer(br.readLine(), " ");
      a = Integer.parseInt(st.nextToken());
      b = Integer.parseInt(st.nextToken());
      c = Integer.parseInt(st.nextToken());
      adjList[a].add(new Edge(b, c));
      adjList[b].add(new Edge(a, c));
    }

    // get v1 & v2
    st = new StringTokenizer(br.readLine(), " ");
    v1 = Integer.parseInt(st.nextToken());
    v2 = Integer.parseInt(st.nextToken());

    // do dijkstra
    int one2v1 = dijkstra(1, v1);
    int v12v2 = dijkstra(v1, v2);
    int v22N = dijkstra(v2, N);
    int one2v2 = dijkstra(1, v2);
    int v22v1 = dijkstra(v2, v1);
    int v12N = dijkstra(v1, N);

    // no answer
    if (one2v1 == Integer.MAX_VALUE ||
    v12v2 == Integer.MAX_VALUE ||
    v22N == Integer.MAX_VALUE ||
    one2v2 == Integer.MAX_VALUE ||
    v22v1 == Integer.MAX_VALUE ||
    v12N == Integer.MAX_VALUE){
      System.out.println(-1);
      br.close();
      return;
    }

    // find answer
    int one2two = one2v1 + v12v2 + v22N;
    int two2one = one2v2 + v22v1 + v12N;
    if (one2two > two2one) System.out.println(two2one);
    else System.out.println(one2two);
    br.close();
    return;
  }

  // Dijkstra function
  private static int dijkstra(int from, int to){
    // reset data
    distance = new int[N+1];
    visited = new boolean[N+1];
    for (int i = 1; i <= N; i++){
      distance[i] = Integer.MAX_VALUE;
      visited[i] = false;
    }

    // do dijkstra
    distance[from] = 0;
    PriorityQueue<Edge> pq = new PriorityQueue<>(new Comparator<Edge>(){
      @Override
      public int compare(Edge e1, Edge e2){
        return e1.w - e2.w;
      }
    });
    pq.add(new Edge(from, 0));
    while (!pq.isEmpty()){
      Edge tmp = pq.poll();
      if (visited[tmp.adj]) continue;
      visited[tmp.adj] = true;
      for (Edge e: adjList[tmp.adj]){
        if (!visited[e.adj] && distance[tmp.adj] + e.w < distance[e.adj]){
          distance[e.adj] = distance[tmp.adj] + e.w;
          pq.add(new Edge(e.adj, distance[e.adj]));
        }
      }
    }

    // return distance
    return distance[to];
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