import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.List;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Comparator;
import java.util.Arrays;

public class Main {
  // set needed variables
  static int N;
  static int[] distance;
  static boolean[] visited;

  public static void main(String[] args) throws IOException{
    // set needed components
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine(), " ");
    N = Integer.parseInt(st.nextToken());
    int M = Integer.parseInt(st.nextToken());
    int X = Integer.parseInt(st.nextToken()) - 1;
    int from, to, time;
    int[] NtoX = new int[N];
    int[] sum = new int[N];
    List<Edge>[] adjList = new List[N];
    for (int i = 0; i < N; i++) adjList[i] = new LinkedList<>();

    // get Edges
    for (int i = 0; i < M; i++){
      st = new StringTokenizer(br.readLine(), " ");
      from = Integer.parseInt(st.nextToken()) - 1;
      to = Integer.parseInt(st.nextToken()) - 1;
      time = Integer.parseInt(st.nextToken());
      adjList[from].add(new Edge(to, time));
    }

    // do DijkstraSP - N to X
    for (int i = 0; i < N; i++){
      if (i == X){
        NtoX[i] = 0;
      }else{
        reset();
        int startPoint = i;
        int endPoint = X;

        PriorityQueue<Edge> pq = new PriorityQueue<>(new Comparator<Edge>(){
          @Override
          public int compare(Edge e1, Edge e2){
            return e1.weight - e2.weight;
          }
        });
        distance[startPoint] = 0;
        visited[startPoint] = true;
        pq.add(new Edge(startPoint, 0));
        while (!pq.isEmpty()){
          Edge tmp = pq.poll();
          if (tmp.adjvertex == endPoint) continue;
          visited[tmp.adjvertex] = true;
          for (Edge e: adjList[tmp.adjvertex]){
            if (!visited[e.adjvertex] && distance[tmp.adjvertex] + e.weight < distance[e.adjvertex]){
              distance[e.adjvertex] = distance[tmp.adjvertex] + e.weight;
              pq.add(new Edge(e.adjvertex, distance[e.adjvertex]));
            }
          }
        }
        NtoX[i] = distance[endPoint];
      }
    }

    // do DijkstraSP - X to N
    reset();
    int startPoint = X;

    PriorityQueue<Edge> pq = new PriorityQueue<>(new Comparator<Edge>(){
      @Override
      public int compare(Edge e1, Edge e2){
        return e1.weight - e2.weight;
      }
    });
    distance[startPoint] = 0;
    visited[startPoint] = true;
    pq.add(new Edge(startPoint, 0));
    while (!pq.isEmpty()){
      Edge tmp = pq.poll();
      visited[tmp.adjvertex] = true;
      for (Edge e: adjList[tmp.adjvertex]){
        if (!visited[e.adjvertex] && distance[tmp.adjvertex] + e.weight < distance[e.adjvertex]){
          distance[e.adjvertex] = distance[tmp.adjvertex] + e.weight;
          pq.add(new Edge(e.adjvertex, distance[e.adjvertex]));
        }
      }
    }

    // make and process sum List
    for (int i = 0; i < N; i++) sum[i] = NtoX[i] + distance[i];
    Arrays.sort(sum);

    // print answer and end program
    System.out.println(sum[N-1]);
    br.close();
    return;
  }

  // reset distance and visited
  public static void reset(){
    distance = new int[N];
    for (int i = 0; i < N; i++) distance[i] = Integer.MAX_VALUE;
    visited = new boolean[N];
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
