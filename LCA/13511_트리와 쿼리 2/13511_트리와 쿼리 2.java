import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.List;
import java.util.LinkedList;

public class Main {
  // set static variables
  static int parent[][], depth[];
  static long distance[][];
  static boolean visited[];
  static int N, K = 0;
  static List<Edge>[] adjList;

	public static void main(String args[]) throws Exception	{
    // set needed variables
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;
    StringBuilder sb = new StringBuilder();
    N = Integer.parseInt(br.readLine());
    int tmp = 1, u, v, w, code, k;

    // get tree depth
    while (tmp <= N){
      tmp <<= 1;
      K++;
    }

    // set variables
    parent = new int[N+1][K];
    distance = new long[N+1][K];
    depth = new int[N+1];
    visited = new boolean[N+1];
    adjList = new List[N+1];
    for (int i = 1; i <= N; i++) adjList[i] = new LinkedList<>();

    // get map
    for (int i = 0; i < N-1; i++){
      st = new StringTokenizer(br.readLine(), " ");
      u = Integer.parseInt(st.nextToken());
      v = Integer.parseInt(st.nextToken());
      w = Integer.parseInt(st.nextToken());
      adjList[u].add(new Edge(v, w));
      adjList[v].add(new Edge(u, w));
    }
    
    // get depth
    depth[1] = 1;
    dfs(1);

    // get parent, and distance
    getData();

    // get M query
    int M = Integer.parseInt(br.readLine());
    for (int i = 0; i < M; i++){
      st = new StringTokenizer(br.readLine(), " ");
      code = Integer.parseInt(st.nextToken());
      u = Integer.parseInt(st.nextToken());
      v = Integer.parseInt(st.nextToken());

      // query 1: cost
      if (code == 1){
        sb.append(getCost(u, v)).append('\n');
      }
      // query 2: k-th node
      else{
        k = Integer.parseInt(st.nextToken());
        sb.append(getKnode(u, v, k)).append('\n');
      }
    }

    // print answer and end program
    System.out.print(sb);
    br.close();
    return;
  }

  // get k-th node function
  private static int getKnode(int a, int b, int k){
    int lca = getLca(a, b);
    int a_lca = depth[a] - depth[lca] + 1;
    int lca_b = depth[b] - depth[lca];
    int d;
    int knode;

    // k-th >> a side
    if (k <= a_lca){
      d = k-1;
      for (int i = K-1; i >= 0; i--){
        if (Math.pow(2, i) <= d){
          a = parent[a][i];
          d -= Math.pow(2, i);
        }
      }
      knode = a;
    }
    // k-th >> b size
    else{
      d = a_lca + lca_b - k;
      for (int i = K-1; i >= 0; i--){
        if (Math.pow(2, i) <= d){
          b = parent[b][i];
          d -= Math.pow(2, i);
        }
      }
      knode = b;
    }

    return knode;
  }

  // get lowest common ancestor
  private static int getLca(int a, int b){
    // depth: a > b
    if (depth[a] < depth[b]){
      int tmp = a;
      a = b;
      b = tmp;
    }

    // set same depth
    for (int i = K-1; i >= 0; i--){
      if (Math.pow(2, i) <= depth[a] - depth[b]){
        a = parent[a][i];
      }
    }

    // same depth >> if a == b
    if (a == b) return a;

    // find lowest common ancestor
    for (int i = K-1; i >= 0; i--){
      if (parent[a][i] != parent[b][i]){
        a = parent[a][i];
        b = parent[b][i];
      }
    }

    return parent[a][0];
  }

  // get cost function
  private static long getCost(int a, int b){
    long cost = 0;

    // depth: a > b
    if (depth[a] < depth[b]){
      int tmp = a;
      a = b;
      b = tmp;
    }

    // set same depth
    for (int i = K-1; i >= 0; i--){
      if (Math.pow(2, i) <= depth[a] - depth[b]){
        cost += distance[a][i];
        a = parent[a][i];
      }
    }

    // same depth >> if a == b
    if (a == b) return cost;

    // calculate cost
    for (int i = K-1; i >= 0; i--){
      if (parent[a][i] != parent[b][i]){
        cost += distance[a][i];
        a = parent[a][i];
        cost += distance[b][i];
        b = parent[b][i];
      }
    }
    cost += distance[a][0];
    cost += distance[b][0];

    return cost;
  }

  // get parent function
  private static void getData(){
    for (int i = 1; i < K; i++){
      for (int j = 1; j <= N; j++){
        parent[j][i] = parent[parent[j][i-1]][i-1];
        distance[j][i] = distance[j][i-1] + distance[parent[j][i-1]][i-1];
      }
    }
  }

  // dfs function
  private static void dfs(int v){
    visited[v] = true;
    for (Edge e: adjList[v]){
      if (!visited[e.adj]){
        parent[e.adj][0] = v;
        distance[e.adj][0] = e.w;
        depth[e.adj] = depth[v] + 1;
        dfs(e.adj);
      }
    }
  }
}

// Edge class
class Edge{
  int adj;
  int w;
  public Edge(int adj, int w){
    this.adj = adj;
    this.w = w;
  }
}