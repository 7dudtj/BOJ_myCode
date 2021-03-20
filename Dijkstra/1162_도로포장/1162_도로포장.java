import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.List;
import java.util.LinkedList;
import java.util.PriorityQueue;
public class Main {
  // set needed variables
  public static void main(String[] args) throws IOException{
    // set needed components
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine(), " ");
    int N = Integer.parseInt(st.nextToken());
    int M = Integer.parseInt(st.nextToken());
    int K = Integer.parseInt(st.nextToken());
    List<Edge>[] adjList = new List[N+1];
    for (int i = 1; i <= N; i++) adjList[i] = new LinkedList<>();
    int a, b;
    long t;
    long[][] d = new long[N+1][K+1];
    for (int i = 0; i <= N; i++){
      for (int j = 0; j <= K; j++){
        d[i][j] = Long.MAX_VALUE;
      }
    }

    // get Edges
    for (int i = 0; i < M; i++){
      st = new StringTokenizer(br.readLine(), " ");
      a = Integer.parseInt(st.nextToken());
      b = Integer.parseInt(st.nextToken());
      t = Long.parseLong(st.nextToken());
      adjList[a].add(new Edge(b, t));
      adjList[b].add(new Edge(a, t));
    }

    // do Dijkstra
    d[1][0] = 0;
    PriorityQueue<Node> pq = new PriorityQueue<>();
    pq.add(new Node(1, 0, 0));
    while (!pq.isEmpty()){
      Node tmp = pq.poll();
      if (d[tmp.node][tmp.count] < tmp.cost) continue;
      for (Edge e: adjList[tmp.node]){
        // no pave
        if (d[tmp.node][tmp.count] + e.weight < d[e.to][tmp.count]){
          d[e.to][tmp.count] = d[tmp.node][tmp.count] + e.weight;
          pq.add(new Node(e.to, d[e.to][tmp.count], tmp.count));
        }

        // do pave
        if (tmp.count < K && d[tmp.node][tmp.count] < d[e.to][tmp.count + 1]){
          d[e.to][tmp.count + 1] = d[tmp.node][tmp.count];
          pq.add(new Node(e.to, d[e.to][tmp.count + 1], tmp.count + 1));
        }
      }
    }

    // find and print answer
    long min = Long.MAX_VALUE;
    for (int i = 0; i <= K; i++){
      if (d[N][i] < min) min = d[N][i];
    }
    System.out.println(min);

    // end program
    br.close();
    return;
  }
}

// Edge class
class Edge{
  // class variables
  int to;
  long weight;
  // constructor
  public Edge(int to, long weight){
    this.to = to;
    this.weight = weight;
  }
}

// Node class
class Node implements Comparable<Node>{
  // class variables
  int node;
  long cost;
  int count;
  // constructor
  public Node(int node, long cost, int count){
    this.node = node;
    this.cost = cost;
    this.count = count;
  }
  // Comparable
  @Override
  public int compareTo(Node n){
    return (int)cost - (int)n.cost;
  }
}
