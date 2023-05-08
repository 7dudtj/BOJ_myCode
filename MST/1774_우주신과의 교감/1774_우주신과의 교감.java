import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.lang.Math;
import java.util.PriorityQueue;

public class Main{
  // set static variables
  static int[] parent;
  static int[] depth;

  public static void main(String[] args) throws IOException{
    // set needed variables
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine(), " ");
    int N = Integer.parseInt(st.nextToken());
    int M = Integer.parseInt(st.nextToken());
    int[] godX = new int[N + 1];
    int[] godY = new int[N + 1];
    PriorityQueue<Edge> pq = new PriorityQueue<>();
    parent = new int[N + 1];
    depth = new int[N + 1];
    for (int i = 1; i <= N; i++){
      parent[i] = i;
      depth[i] = 1;
    }
    double answer = 0;

    // get gods' coordinate
    for (int i = 1; i <= N; i++){
      st = new StringTokenizer(br.readLine(), " ");
      godX[i] = Integer.parseInt(st.nextToken());
      godY[i] = Integer.parseInt(st.nextToken());
    }

    // make possible edges
    for (int i = 1; i < N; i++){
      for (int j = i + 1; j <= N; j++){
        pq.add(new Edge(i, godX[i], godY[i], j, godX[j], godY[j]));
      }
    }

    // get current channels
    for (int i = 1; i <= M; i++){
      st = new StringTokenizer(br.readLine(), " ");
      int aGod = Integer.parseInt(st.nextToken());
      int bGod = Integer.parseInt(st.nextToken());
      union(aGod, bGod);
    }

    // connect gods
    while (!pq.isEmpty()){
      Edge tmp = pq.poll();

      if (find(tmp.a) != find(tmp.b)){
        union(tmp.a, tmp.b);
        answer += tmp.distance;
      }
    }

    // print answer and end program
    System.out.printf("%.2f", answer);
    br.close();
    return;
  }

  // union function
  private static void union(int a, int b){
    a = find(a);
    b = find(b);

    if (a == b) return;

    int aDepth = depth[a];
    int bDepth = depth[b];

    if (aDepth > bDepth){
      parent[b] = a;
    }else if (aDepth < bDepth){
      parent[a] = b;
    }else{ // aDepth == bDepth
      parent[b] = a;
      depth[a]++;
    }

    return;
  }

  // find function
  private static int find(int x){
    if (parent[x] == x){
      return x;
    }

    return parent[x] = find(parent[x]);
  }
}

// Edge class
class Edge implements Comparable<Edge>{
  /* Edge connects a node to b node */

  // Edge variables
  int a;
  int ax;
  int ay;
  int b;
  int bx;
  int by;
  double distance;

  // Edge constructor
  public Edge(int a, int ax, int ay, int b, int bx, int by){
    this.a = a;
    this.ax = ax;
    this.ay = ay;
    this.b = b;
    this.bx = bx;
    this.by = by;
    this.distance = Math.sqrt(Math.pow(ax - bx, 2) + Math.pow(ay - by, 2));
  }

  // Edge compare function
  @Override
  public int compareTo(Edge e){
    if (distance - e.distance <= 0) return -1;
    else return 1;
  }
}