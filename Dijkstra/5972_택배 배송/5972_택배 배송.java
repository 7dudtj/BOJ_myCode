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
  static int N, M;
  static List<Edge>[] adjList;
  static int[] distance;
  static boolean[] visited;

  public static void main(String[] args) throws IOException{
    // set needed components
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine(), " ");
    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());
    List<Edge>[] adjList = new List[N];
    for (int i = 0; i < N; i++) adjList[i] = new LinkedList<>();
    distance = new int[N];
    visited = new boolean[N];
    for (int i = 0; i < N; i++){
      distance[i] = Integer.MAX_VALUE;
      visited[i] = false;
    }
    int startPoint = 0;

    // get Edges
    for (int i = 0; i < M; i++){
      st = new StringTokenizer(br.readLine(), " ");
      int a = Integer.parseInt(st.nextToken());
      int b = Integer.parseInt(st.nextToken());
      int c = Integer.parseInt(st.nextToken());
      adjList[a-1].add(new Edge(b-1, c));
      adjList[b-1].add(new Edge(a-1, c));
    }

    // do Dijkstra
    distance[startPoint] = 0;
    visited[startPoint] = true;
    PriorityQueue<Edge> pq = new PriorityQueue<>(new Comparator<Edge>(){
      @Override
      public int compare(Edge e1, Edge e2){
        return e1.weight - e2.weight;
      }
    });
    pq.add(new Edge(0, 0));
    while (!pq.isEmpty()){
      Edge temp = pq.poll();
      if (temp.adjvertex == N-1) continue;
      visited[temp.adjvertex] = true;
      for (Edge e: adjList[temp.adjvertex]){
        if (!visited[e.adjvertex] && distance[temp.adjvertex] + e.weight < distance[e.adjvertex]){
          distance[e.adjvertex] = distance[temp.adjvertex] + e.weight;
          pq.add(new Edge(e.adjvertex, distance[e.adjvertex]));
        }
      }
    }

    // print answer and end program
    System.out.println(distance[N-1]);
    br.close();
    return;
  } 
}

// Edge class
class Edge{
  int adjvertex;
  int weight;
  public Edge(int adj, int w){
    adjvertex = adj;
    weight = w;
  }
}
