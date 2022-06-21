import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.List;
import java.util.LinkedList;
import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Comparator;

public class Main {
  // set needed variables
  static List<Edge>[] adjList;
  static int n, m, t, a, b, d, s, g, h;
  static int[] distance;
  static final int INF = 100000000;

  public static void main(String[] args) throws IOException{
    // set needed components
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;
    StringBuilder sb = new StringBuilder();
    int T = Integer.parseInt(br.readLine());

    // do main process
    for (int times = 0; times < T; times++){
      // get n, m, and t
      st = new StringTokenizer(br.readLine(), " ");
      n = Integer.parseInt(st.nextToken());
      m = Integer.parseInt(st.nextToken());
      t = Integer.parseInt(st.nextToken());

      // fill distance
      distance = new int[n+1];
      for (int i = 0; i <= n; i++) distance[i] = INF;

      // get s, g, and h
      st = new StringTokenizer(br.readLine(), " ");
      s = Integer.parseInt(st.nextToken());
      g = Integer.parseInt(st.nextToken());
      h = Integer.parseInt(st.nextToken());

      // get Edges
      adjList = new List[n+1];
      for (int i = 1; i <= n; i++) adjList[i] = new LinkedList<>();
      for (int i = 0; i < m; i++){
        st = new StringTokenizer(br.readLine(), " ");
        a = Integer.parseInt(st.nextToken());
        b = Integer.parseInt(st.nextToken());
        d = Integer.parseInt(st.nextToken());
        // if edge is g-h
        if ((a == g && b == h) || (a == h && b == g)){
          adjList[a].add(new Edge(b, d*2-1));
          adjList[b].add(new Edge(a, d*2-1));
        }
        // if edge is not g-h
        else{
          adjList[a].add(new Edge(b, d*2));
          adjList[b].add(new Edge(a, d*2));
        }

      }

      // get destinations and sort
      List<Integer> destinations = new ArrayList<>();
      for (int i = 0; i < t; i++) destinations.add(Integer.parseInt(br.readLine()));
      Collections.sort(destinations);

      // do dijkstra
      dijkstra(s);

      // check answer
      for (int i: destinations){
        if (distance[i] % 2 == 1){
          sb.append(i).append(" ");
        }
      }

      // end cycle
      sb.append('\n');
    }

    // print answer and end program
    System.out.print(sb);
    br.close();
    return;
  }

  // dijkstra function
  public static void dijkstra(int s){
    // set needed variables
    boolean[] visited = new boolean[n+1];

    // set start point
    distance[s] = 0;

    // set priority queue
    PriorityQueue<Edge> pq = new PriorityQueue<Edge>(new Comparator<Edge>(){
      @Override
      public int compare(Edge e1, Edge e2) {
        return e1.w - e2.w;
      }  
    });
    pq.add(new Edge(s, 0));

    // do main process
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

