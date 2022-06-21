import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.ArrayList;
import java.util.Collections;

public class Main {
  static int[] parent;
  public static void main(String[] args) throws IOException{
    // set needed components
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine(), " ");
    int V = Integer.parseInt(st.nextToken());
    int E = Integer.parseInt(st.nextToken());
    parent = new int[V+1];
    for (int i = 1; i <= V; i++) parent[i] = i;
    ArrayList<Edge> list = new ArrayList<>();
    int A, B, C, count = 0;
    long sum = 0;

    // get edges
    for (int i = 0; i < E; i++){
      st = new StringTokenizer(br.readLine());
      A = Integer.parseInt(st.nextToken());
      B = Integer.parseInt(st.nextToken());
      C = Integer.parseInt(st.nextToken());
      list.add(new Edge(A, B, C));
    }
    Collections.sort(list);

    // find MST
    Edge tmp;
    for (int i = 0; i < E; i++){
      if (count == V-1) break; // finish

      tmp = list.get(i);
      if (find(tmp.from) != find(tmp.to)){
        count++;
        union(tmp.from, tmp.to);
        sum += tmp.weight;
      }
    }

    // print answer and end program
    System.out.print(sum);
    br.close();
    return;
  }

  // find function
  private static int find(int v){
    if (parent[v] == v) return v;
    
    return parent[v] = find(parent[v]);
  }

  // union function
  private static void union(int a, int b){
    a = find(a);
    b = find(b);
    parent[b] = a;
  }
}

// Edge class
class Edge implements Comparable<Edge>{
  // class variables
  int from;
  int to;
  int weight;
  // class constructor
  public Edge(int f, int t, int w){
    from = f;
    to = t;
    weight = w;
  }
  // comparable
  @Override
  public int compareTo(Edge e){
    return weight - e.weight;
  }
}
