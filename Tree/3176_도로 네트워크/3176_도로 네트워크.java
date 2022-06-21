import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.List;
import java.util.LinkedList;

public class Main {
  // set static variables
  static int data[][][], depth[];
  static boolean visited[];
  static List<Edge>[] adjList;
  static int k = 0, N, sd, ld;

	public static void main(String args[]) throws Exception	{
    // set needed variables
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;
    StringBuilder sb = new StringBuilder();
    N = Integer.parseInt(br.readLine());
    int tmp = 1, a, b, c;

    // get tree depth
    while (tmp <= N){
      tmp <<= 1;
      k++;
    }

    // set variables
    data = new int[3][N+1][k]; // 0: parent, 1: short, 2: long
    depth = new int[N+1];
    visited = new boolean[N+1];
    adjList = new List[N+1];
    for (int i = 1; i <= N; i++) adjList[i] = new LinkedList<>();

    // get map
    for (int i = 0; i < N-1; i++){
      st = new StringTokenizer(br.readLine(), " ");
      a = Integer.parseInt(st.nextToken());
      b = Integer.parseInt(st.nextToken());
      c = Integer.parseInt(st.nextToken());
      adjList[a].add(new Edge(b, c));
      adjList[b].add(new Edge(a, c));
    }

    // get depth
    depth[1] = 1;
    dfs(1);

    // get parent, short, and long
    getData();

    // get K query
    int K = Integer.parseInt(br.readLine());
    for (int i = 0; i < K; i++){
      st = new StringTokenizer(br.readLine(), " ");
      a = Integer.parseInt(st.nextToken());
      b = Integer.parseInt(st.nextToken());
      int sRoad = getShort(a, b);
      int lRoad = getLong(a, b);
      sb.append(sRoad+" "+lRoad+"\n");
    }

    // print answer and end program
    System.out.print(sb);
    br.close();
    return;
  }
  
  // get short road function
  private static int getShort(int a, int b){
    sd = Integer.MAX_VALUE;
    // depth: a > b
    if (depth[a] < depth[b]){
      int tmp = a;
      a = b;
      b = tmp;
    }

    // set same depth
    for (int i = k-1; i >= 0; i--){
      if (Math.pow(2, i) <= depth[a] - depth[b]){
        sd = Math.min(sd, data[1][a][i]);
        a = data[0][a][i];
      }
    }

    // same depth >> if a == b
    if (a == b) return sd;

    // find lowest common ancestor, and calculate short distance
    for (int i = k-1; i >= 0; i--){
      if (data[0][a][i] != data[0][b][i]){
        sd = Math.min(sd, data[1][a][i]);
        a = data[0][a][i];
        sd = Math.min(sd, data[1][b][i]);
        b = data[0][b][i];
      }
    }
    sd = Math.min(sd, data[1][a][0]);
    sd = Math.min(sd, data[1][b][0]);

    return sd;
  }

  // get long road function
  private static int getLong(int a, int b){
    ld = Integer.MIN_VALUE;
    // depth: a > b
    if (depth[a] < depth[b]){
      int tmp = a;
      a = b;
      b = tmp;
    }

    // set same depth
    for (int i = k-1; i >= 0; i--){
      if (Math.pow(2, i) <= depth[a] - depth[b]){
        ld = Math.max(ld, data[2][a][i]);
        a = data[0][a][i];
      }
    }

    // same depth >> if a == b
    if (a == b) return ld;

    // find lowest common ancestor, and calculate long distance
    for (int i = k-1; i >= 0; i--){
      if (data[0][a][i] != data[0][b][i]){
        ld = Math.max(ld, data[2][a][i]);
        a = data[0][a][i];
        ld = Math.max(ld, data[2][b][i]);
        b = data[0][b][i];
      }
    }
    ld = Math.max(ld, data[2][a][0]);
    ld = Math.max(ld, data[2][b][0]);

    return ld;
  }

  // get parent, short, and long function
  private static void getData(){
    for (int i = 1; i < k; i++){
      for (int j = 1; j <= N; j++){
        data[0][j][i] = data[0][data[0][j][i-1]][i-1];
        data[1][j][i] = Math.min(data[1][j][i-1], data[1][data[0][j][i-1]][i-1]);
        data[2][j][i] = Math.max(data[2][j][i-1], data[2][data[0][j][i-1]][i-1]);
      }
    }
  }

  // dfs function
  private static void dfs(int v){
    visited[v] = true;
    for (Edge e: adjList[v]){
      if (!visited[e.adj]){
        data[0][e.adj][0] = v;
        data[1][e.adj][0] = e.w;
        data[2][e.adj][0] = e.w;
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