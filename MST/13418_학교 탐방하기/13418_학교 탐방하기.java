import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.ArrayList;
import java.util.Collections;

public class Main {
  static int[] parent;
  static int N;
	public static void main(String args[]) throws IOException	{
    // set needed variables
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine(), " ");
    N = Integer.parseInt(st.nextToken());
    int M = Integer.parseInt(st.nextToken());
    long k1 = 0, k2 = 0;
    ArrayList<Edge> edgeList = new ArrayList<>();

    // get map
    int A, B, C;
    for (int i = 0; i <= M; i++){
      st = new StringTokenizer(br.readLine(), " ");
      A = Integer.parseInt(st.nextToken());
      B = Integer.parseInt(st.nextToken());
      C = Integer.parseInt(st.nextToken());
      edgeList.add(new Edge(A, B, C));
    }
    Collections.sort(edgeList);

    // find k1 and k2
    k1 = mst(edgeList, true);
    k2 = mst(edgeList, false);

    // get answer, print answer, and end program
    k1 = (k1+k2)*(k1-k2);
    System.out.println(k1);
    br.close();
    return;
  }

  // mst function
  private static long mst(ArrayList<Edge> list, boolean min){
    // set needed variables
    long answer = 0;
    parent = new int[N+1];
    for (int i = 0; i <= N; i++) parent[i] = i;

    // do KruskalMST
    int loc;
    for (int i = 0; i < list.size(); i++){
      if (min) loc = i;
      else loc = list.size()-i-1;
      Edge e = list.get(loc);

      if (find(e.from) != find(e.to)){
        if (e.weight == 0) answer++;
        union(e.from, e.to);
      }
    }
    
    return answer;
  }

  // union function
  private static void union(int a, int b){
    a = find(a);
    b = find(b);
    if (a != b) parent[b] = a;
  }

  // find function
  private static int find(int x){
    if (parent[x] == x) return x;
    return parent[x] = find(parent[x]);
  }
}

// Edge class
class Edge implements Comparable<Edge>{
  // class variables
  int from;
  int to;
  int weight;
  // constructor
  public Edge(int f, int t, int w){
    from = f;
    to = t;
    weight = w;
  }
  // Comparable
  @Override
  public int compareTo(Edge e){
    return weight - e.weight;
  }
}