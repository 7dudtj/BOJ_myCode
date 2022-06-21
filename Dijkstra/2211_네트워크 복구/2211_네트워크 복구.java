import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.List;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Comparator;

public class Main {
  // set needed variables
  static int n, m, a, b, c;
  static List<Edge>[] adjList;
  static Line[] list;
  static int[] distance;
  static int[] previous;
  static int answer = 0;
  static StringBuilder sb = new StringBuilder();

  public static void main(String[] args) throws IOException{
    // set needed components
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine(), " ");
    n = Integer.parseInt(st.nextToken());
    m = Integer.parseInt(st.nextToken());
    adjList = new List[n+1];
    for (int i = 1; i <= n; i++) adjList[i] = new LinkedList<>();
    list = new Line[m];
    distance = new int[n+1];
    for (int i = 0; i <= n; i++) distance[i] = Integer.MAX_VALUE;
    previous = new int[n+1];
    for (int i = 0; i <= n; i++) previous[i] = i;

    // get lines and make adjList
    for (int i = 0; i < m; i++){
      st = new StringTokenizer(br.readLine(), " ");
      a = Integer.parseInt(st.nextToken());
      b = Integer.parseInt(st.nextToken());
      c = Integer.parseInt(st.nextToken());
      list[i] = new Line(a, b, c);
      adjList[a].add(new Edge(b, c));
      adjList[b].add(new Edge(a, c));
    }

    // do dijkstra
    dijkstra(1);

    // answer check
    for (int i = 2; i <= n; i++){
      checkEdge(i, previous[i]);
    }

    // print answer and end program
    System.out.println(answer);
    System.out.print(sb);
    br.close();
    return;
  }

  // Edge checking function
  private static void checkEdge(int a, int b){
    for (int i = 0; i < m; i++){
      if ((list[i].a == a && list[i].b == b) || (list[i].a == b && list[i].b == a)){
        answer++;
        sb.append(a+" "+b+'\n');
        return;
      }
    }
  }

  // dijkstra function
  private static void dijkstra(int s){
    boolean[] visited = new boolean[n+1];
    distance[s] = 0;

    PriorityQueue<Edge> pq = new PriorityQueue<>(new Comparator<Edge>(){
      @Override
      public int compare(Edge e1, Edge e2){
        return e1.w - e2.w;
      }
    });
    pq.add(new Edge(s, 0));

    while (!pq.isEmpty()){
      Edge tmp = pq.poll();
      if (visited[tmp.adj]) continue;
      visited[tmp.adj] = true;
      for (Edge e: adjList[tmp.adj]){
        if (!visited[e.adj] && distance[tmp.adj] + e.w < distance[e.adj]){
          distance[e.adj] = distance[tmp.adj] + e.w;
          previous[e.adj] = tmp.adj;
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

// Line class
class Line{
  int a;
  int b;
  int c;
  public Line(int a, int b, int c){
    this.a = a;
    this.b = b;
    this.c = c;
  }
}

