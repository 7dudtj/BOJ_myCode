import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.ArrayList;
import java.util.Collections;
import java.lang.Math;

public class Main {
  // set needed static variables
  static int[] parent;

  public static void main(String[] args) throws IOException{
    // set needed variables
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine(), " ");
    int N = Integer.parseInt(st.nextToken());
    int M = Integer.parseInt(st.nextToken());
    double[] xcor = new double[N+1];
    double[] ycor = new double[N+1];
    parent = new int[N+1];
    for (int i = 1; i <= N; i++) parent[i] = i;
    ArrayList<Edge> edgeList = new ArrayList<>();
    int f, t, count = 0;
    double len = 0;

    // get nodes
    for (int i = 1; i <= N; i++){
      st = new StringTokenizer(br.readLine(), " ");
      xcor[i] = Double.parseDouble(st.nextToken());
      ycor[i] = Double.parseDouble(st.nextToken());
    }

    // make edges
    for (int i = 1; i < N; i++){
      for (int j = 2; j <= N; j++){
        edgeList.add(new Edge(i, xcor[i], ycor[i], j, xcor[j], ycor[j]));
      }
    }
    Collections.sort(edgeList);

    // get connected edges
    for (int i = 0; i < M; i++){
      st = new StringTokenizer(br.readLine(), " ");
      f = Integer.parseInt(st.nextToken());
      t = Integer.parseInt(st.nextToken());
      union(f, t);
    }

    // do KruskalMST
    for (int i = 0; i < edgeList.size(); i++){
      Edge e = edgeList.get(i);

      // check if edge creates cycle
      if (find(e.from) != find(e.to)){
        count++;
        len += e.distance;
        union(e.from, e.to);
        if (count == ((N-1) - M)) break;
      }
    }

    // print answer and end program
    System.out.printf("%.2f\n", len);
    br.close();
    return;
  }

  // find function for KruskalMST
  private static int find(int x){
    if (parent[x] == x) return x;
    return parent[x] = find(parent[x]);
  }

  // union function for KruskalMST
  private static void union(int a, int b){
    a = find(a);
    b = find(b);
    if (a != b) parent[b] = a;
  }
}

// Edge class
class Edge implements Comparable<Edge>{
  // class variables
  int from;
  double fromx;
  double fromy;
  int to;
  double tox;
  double toy;
  double distance;
  // constructor
  public Edge (int from, double fromx, double fromy, 
  int to, double tox, double toy){
    this.from = from;
    this.fromx = fromx;
    this.fromy = fromy;
    this.to = to;
    this.tox = tox;
    this.toy = toy;
    this.distance = Math.sqrt(Math.pow(fromx-tox, 2) + Math.pow(fromy-toy, 2));
  }
  // Comparable
  @Override
  public int compareTo(Edge e){
    if (distance < e.distance) return -1;
    return 1;
  }
}
