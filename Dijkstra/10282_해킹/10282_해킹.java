import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.List;
import java.util.LinkedList;
import java.util.PriorityQueue;

public class Main {
  // set needed variables
  static List<Edge>[] adjList;
  static int n, count, time;
  static boolean[] infected;
  static int[] distance;

  public static void main(String[] args) throws IOException{
    // set needed components
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int T = Integer.parseInt(br.readLine());
    StringTokenizer st;
    int d, c, a, b, s;

    // do process for T times
    for (int times = 0; times < T; times++){
      // get n, d, and c
      st = new StringTokenizer(br.readLine(), " ");
      n = Integer.parseInt(st.nextToken());
      d = Integer.parseInt(st.nextToken());
      c = Integer.parseInt(st.nextToken());

      // set adjList, infected, and distance
      adjList = new List[n+1];
      for (int i = 1; i <= n; i++) adjList[i] = new LinkedList<>();
      infected = new boolean[n+1];
      distance = new int[n+1];
      for (int i = 1; i <= n; i++) distance[i] = Integer.MAX_VALUE;
      
      // get dependence
      for (int i = 0; i < d; i++){
        // get a, b, and s
        st = new StringTokenizer(br.readLine(), " ");
        a = Integer.parseInt(st.nextToken());
        b = Integer.parseInt(st.nextToken());
        s = Integer.parseInt(st.nextToken());

        // make adjList
        adjList[b].add(new Edge(a, s));
      }

      // do dijkstra
      dijkstra(c);

      // get answer
      time = Integer.MIN_VALUE;
      count = 0;
      for (int i = 1; i <= n; i++){
        if (infected[i] == true){
          count++;
          if (time < distance[i]) time = distance[i];
        }
      }

      // print answer
      System.out.println(count+" "+time);
    }

    // end program
    br.close();
    return;
  }

  // dijkstra function
  private static void dijkstra(int s){
    // set start point
    distance[s] = 0;

    // set priority queue
    PriorityQueue<Edge> pq = new PriorityQueue<>();
    pq.add(new Edge(s, 0));

    // do main process
    while (!pq.isEmpty()){
      Edge tmp = pq.poll();
      if (infected[tmp.adj]) continue;
      infected[tmp.adj] = true;
      for (Edge e: adjList[tmp.adj]){
        if (!infected[e.adj] && distance[tmp.adj] + e.w < distance[e.adj]){
          distance[e.adj] = distance[tmp.adj] + e.w;
          pq.add(new Edge(e.adj, distance[e.adj]));
        }
      }
    }
  }
}

// Edge class
class Edge implements Comparable<Edge>{
  // class variables
  int adj;
  int w;
  // constructor
  public Edge(int adj, int w){
    this.adj = adj;
    this.w = w;
  }
  // Comparable
  @Override
  public int compareTo(Edge e){
    return w - e.w;
  }
}
