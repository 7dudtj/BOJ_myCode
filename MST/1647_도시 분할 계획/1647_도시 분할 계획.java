import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.PriorityQueue;

// Kruskal MST
public class Main {
  // set needed variables
  static int n, m;
  static int[] parent;
  static int answer = 0;
  static PriorityQueue<Node> pq = new PriorityQueue<Node>();

  public static void main(String[] args) throws IOException{
    // set needed components
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;

    // get N and M
    st = new StringTokenizer(br.readLine(), " ");
    n = Integer.parseInt(st.nextToken());
    m = Integer.parseInt(st.nextToken());

    // set parent
    parent = new int[n+1];
    for (int i = 1; i <= n; i++) parent[i] = i;

    // get edges
    for (int i = 0; i < m; i++){
      st = new StringTokenizer(br.readLine(), " ");
      int v1 = Integer.parseInt(st.nextToken());
      int v2 = Integer.parseInt(st.nextToken());
      int len = Integer.parseInt(st.nextToken());
      pq.add(new Node(v1, v2, len));
    }

    // do count
    int count = 0;
    while (count < n-2){
      Node a = pq.poll();
      if (check(a.v1, a.v2)){
        merge(a.v1, a.v2);
        answer += a.len;
        count++;
      }
    }

    // print answer and end program
    System.out.println(answer);
    br.close();
    return;
  }

  // check if v1 and v2 are in same tree
  public static boolean check(int v1, int v2){
    return (find(v1) != find(v2));
  }

  // find tree's root
  public static int find(int v){
    if (v == parent[v]) return v;
    parent[v] = find(parent[v]);
    return parent[v];
  }

  // merge two tree
  public static void merge(int v1, int v2){
    int a = find(v1);
    int b = find(v2);

    if (a != b) parent[b] = a;
  }
}

// Node class
class Node implements Comparable<Node>{
  int v1, v2, len;
  Node (int v11, int v22, int lenn){
    v1 = v11;
    v2 = v22;
    len = lenn;
  }
  public int compareTo(Node o){
    return this.len-o.len;
  }
}
