import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.ArrayList;
import java.util.Arrays;
import java.lang.Math;
import java.util.Collections;

public class Main {
  // set needed variables
  static int[] parent;
  static ArrayList<Edge> edgeList;

  public static void main(String[] args) throws IOException{
    // set needed components
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());
    int x, y, z;
    StringTokenizer st;
    Planet[] p = new Planet[N];
    edgeList = new ArrayList<>();
    parent = new int[N];
    for (int i = 0; i < N; i++) parent[i] = i;
    int answer = 0;

    // get planets
    for (int i = 0; i < N; i++){
      st = new StringTokenizer(br.readLine(), " ");
      x = Integer.parseInt(st.nextToken());
      y = Integer.parseInt(st.nextToken());
      z = Integer.parseInt(st.nextToken());

      p[i] = new Planet(i, x, y, z);
    }

    // sort data
    // 1. sort by x
    Arrays.sort(p, (p1, p2) -> p1.x - p2.x);
    for (int i = 0; i < N-1; i++){
      int w = Math.abs(p[i].x - p[i+1].x);

      edgeList.add(new Edge(p[i].num, p[i+1].num, w));
    }
    // 2. sort by y
    Arrays.sort(p, (p1, p2) -> p1.y - p2.y);
    for (int i = 0; i < N-1; i++){
      int w = Math.abs(p[i].y - p[i+1].y);

      edgeList.add(new Edge(p[i].num, p[i+1].num, w));
    }
    // 3. sort by z
    Arrays.sort(p, (p1, p2) -> p1.z - p2.z);
    for (int i = 0; i < N-1; i++){
      int w = Math.abs(p[i].z - p[i+1].z);

      edgeList.add(new Edge(p[i].num, p[i+1].num, w));
    }

    // sort edgeList
    Collections.sort(edgeList);

    // do KruskalMST
    for (int i = 0; i < edgeList.size(); i++){
      Edge e = edgeList.get(i);

      // delete cycle edge
      if (find(e.from) != find(e.to)){
        answer += e.weight;
        union(e.from, e.to);
      }
    }

    // print answer and end program
    System.out.println(answer);
    br.close();
    return;
  }

  // find function
  private static int find(int x){
    if (x == parent[x]) return x;
    return parent[x] = find(parent[x]);
  }

  // union function
  private static void union(int x, int y){
    x = find(x);
    y = find(y);

    if (x != y) parent[y] = x;
  }
}

// Planet class
class Planet{
  int num;
  int x;
  int y;
  int z;
  public Planet(int num, int x, int y, int z){
    this.num = num;
    this.x = x;
    this.y = y;
    this.z = z;
  }
}

// Edge class
class Edge implements Comparable<Edge>{
  int from;
  int to;
  int weight;
  public Edge(int from, int to, int weight){
    this.from = from;
    this.to = to;
    this.weight = weight;
  }

  @Override
  public int compareTo(Edge e){
    return weight - e.weight;
  }
}
