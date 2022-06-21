import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.List;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Arrays;

public class Main {
  // set needed variables
  public static void main(String[] args) throws IOException{
    // set needed components
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    StringTokenizer st;
    int T = Integer.parseInt(br.readLine());
    int N, M, K, u, v, c, t;
    List<Edge>[] adjList;
    int[][] d;

    // do process for T times
    for (int times = 0; times < T; times++){
      // get N, M, and K
      st = new StringTokenizer(br.readLine(), " ");
      N = Integer.parseInt(st.nextToken());
      M = Integer.parseInt(st.nextToken());
      K = Integer.parseInt(st.nextToken());

      // set adjList and distance
      adjList = new List[N+1];
      for (int i = 1; i <= N; i++) adjList[i] = new LinkedList<>();
      d = new int[N+1][M+1];
      for (int[] row: d){
        Arrays.fill(row,Integer.MAX_VALUE);
      }

      // get Edges and make adjList
      for (int i = 0; i < K; i++){
        // get u, v, c, and t
        st = new StringTokenizer(br.readLine(), " ");
        u = Integer.parseInt(st.nextToken());
        v = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        t = Integer.parseInt(st.nextToken());

        adjList[u].add(new Edge(v, c, t));
      }

      // do Dijkstra
      d[1][0] = 0;
      PriorityQueue<Node> pq = new PriorityQueue<>();
      pq.add(new Node(1, 0, 0));
      while (!pq.isEmpty()){
        Node tmp = pq.poll();
        if (d[tmp.node][tmp.cost] < tmp.time) continue;
        for (Edge e: adjList[tmp.node]){
          if (tmp.cost + e.cost <= M && d[tmp.node][tmp.cost] + e.time < d[e.to][tmp.cost + e.cost]){
            d[e.to][tmp.cost + e.cost] = d[tmp.node][tmp.cost] + e.time;
            pq.add(new Node(e.to, tmp.cost + e.cost, d[e.to][tmp.cost + e.cost]));
          }
        }
      }

      // find answer
      int min = Integer.MAX_VALUE;
      for (int i = 0; i <= M; i++){
        if (d[N][i] < min) min = d[N][i];
      }
      if (min != Integer.MAX_VALUE) {
        bw.write(String.valueOf(min));
        bw.newLine();
      }
      else {
        bw.write("Poor KCM");
        bw.newLine();
      }  
    }

    // print answer and end program
    bw.flush();
    br.close();
    return;
  }
}

// Edge class
class Edge{
  // class variables
  int to;
  int cost;
  int time;
  // constructor
  public Edge(int to, int cost, int time){
    this.to = to;
    this.cost = cost;
    this.time = time;
  }
}

// Node class
class Node implements Comparable<Node>{
  // class variables
  int node;
  int cost;
  int time;
  // constructor
  public Node(int node, int cost, int time){
    this.node = node;
    this.cost = cost;
    this.time = time;
  }
  // Comparable
  @Override
  public int compareTo(Node n){
    return cost - n.cost;
  }
}
