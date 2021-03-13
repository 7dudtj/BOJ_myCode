import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.ArrayList;
import java.util.Collections;

public class Main{
  // set needed static components
  static int[] parent;

  public static void main(String[] args) throws IOException{
    // set needed components
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine(), " ");
    int N = Integer.parseInt(st.nextToken());
    int M = Integer.parseInt(st.nextToken());
    parent = new int[N];
    for (int i = 0; i < N; i++) parent[i] = i;
    String[] univ = new String[N];
    ArrayList<Edge> edgeList = new ArrayList<>();
    int len = 0, count = 0, u, v, d;

    // get univ data
    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < N; i++) univ[i] = st.nextToken();

    // make edgeList
    for (int i = 0; i < M; i++){
      st = new StringTokenizer(br.readLine(), " ");
      u = Integer.parseInt(st.nextToken());
      v = Integer.parseInt(st.nextToken());
      d = Integer.parseInt(st.nextToken());

      if (!univ[u-1].equals(univ[v-1])){
        edgeList.add(new Edge(u-1, v-1, d));
      }
    }
    Collections.sort(edgeList);

    // do KruskalMST
    for (int i = 0; i < edgeList.size(); i++){
      Edge e = edgeList.get(i);

      // check if edge creates cycle
      if (find(e.from) != find(e.to)){
        count++;
        len += e.weight;
        union(e.from, e.to);
      }
    }

    // print answer and end program
    if (count == N-1) System.out.println(len);
    else System.out.println(-1);
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
  int to;
  int weight;
  // constuctor
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
