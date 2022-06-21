import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.List;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Comparator;

public class Main {
  public static void main(String[] args) throws IOException{
    // set needed components
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine(), " ");
    int N = Integer.parseInt(st.nextToken());
    int D = Integer.parseInt(st.nextToken());

    // make default map
    List<Edge>[] adjList = new List[D+1];
    for (int i = 0; i <= D; i++) adjList[i] = new LinkedList<>();
    for (int i = 0; i < D; i++) adjList[i].add(new Edge(i+1, 1));

    // add shortcuts
    int start, end, d;
    for (int i = 0; i < N; i++){
      // get data
      st = new StringTokenizer(br.readLine());
      start = Integer.parseInt(st.nextToken());
      end = Integer.parseInt(st.nextToken());
      d = Integer.parseInt(st.nextToken());

      // check shortcut is applicable
      if (0 <= start && end <= D){
        // add shortcut to map
        adjList[start].add(new Edge(end, d));
      }
    }

    // do dijkstra
    int[] distance = new int[D+1];
    boolean[] visited = new boolean[D+1];
    for (int i = 0; i <= D; i++) distance[i] = Integer.MAX_VALUE;
    distance[0] = 0;
    PriorityQueue<Edge> pq = new PriorityQueue<>(new Comparator<Edge>(){
      @Override
      public int compare(Edge e1, Edge e2){
        return e1.weight - e2.weight;
      }
    });
    pq.add(new Edge(0, 0));
    while (!pq.isEmpty()){
      Edge tmp = pq.poll();
      if (visited[tmp.adj]) continue;
      visited[tmp.adj] = true;
      for (Edge e: adjList[tmp.adj]){
        if (!visited[e.adj] && distance[tmp.adj] + e.weight < distance[e.adj]){
          distance[e.adj] = distance[tmp.adj] + e.weight;
          pq.add(new Edge(e.adj, distance[e.adj]));
        }
      }
    }

    // print answer and end program
    System.out.print(distance[D]);
    br.close();
    return;
  }
}

// Edge class
class Edge{
  int adj;
  int weight;
  public Edge(int a, int w){
    adj = a;
    weight = w;
  }
}