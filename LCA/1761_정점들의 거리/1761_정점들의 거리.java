import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.List;
import java.util.LinkedList;

public class Main {
  // set static variables
  static int parent[], depth[], pd[];
  static boolean visited[];
  static List<Edge>[] adjList;
  static int answer;

	public static void main(String args[]) throws Exception	{
    // set needed variables
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;
    StringBuilder sb = new StringBuilder();
    int N = Integer.parseInt(br.readLine());
    parent = new int[N+1];
    for (int i = 1; i <= N; i++) parent[i] = i;
    depth = new int[N+1];
    for (int i = 1; i <= N; i++) depth[i] = 1;
    pd = new int[N+1];
    for (int i = 1; i <= N; i++) pd[i] = 0;
    visited = new boolean[N+1];
    adjList = new List[N+1];
    for (int i = 1; i <= N; i++) adjList[i] = new LinkedList<>();
    int a, b, d, answer;

    // get map
    for (int i = 0; i < N-1; i++){
      st = new StringTokenizer(br.readLine(), " ");
      a = Integer.parseInt(st.nextToken());
      b = Integer.parseInt(st.nextToken());
      d = Integer.parseInt(st.nextToken());
      adjList[a].add(new Edge(b, d));
      adjList[b].add(new Edge(a, d));
    }

    // find parent and depth
    dfs(1);

    // get answer
    int M = Integer.parseInt(br.readLine());
    for (int i = 0; i < M; i++){
      st = new StringTokenizer(br.readLine(), " ");
      a = Integer.parseInt(st.nextToken());
      b = Integer.parseInt(st.nextToken());
      sb.append(findDistance(a,b)).append('\n');
    }

    // print answer and end program
    System.out.print(sb);
    br.close();
    return;
  }
  
  // find distance function
  private static int findDistance(int a, int b){
    answer = 0;
    // set same depth
    if (depth[a] > depth[b]){
      a = setdepth(a, depth[b]);
    } else if (depth[a] < depth[b]){
      b = setdepth(b, depth[a]);
    }

    // find Lowest Common Ancestor
    while (a != b){
      answer += pd[a];
      a = parent[a];
      answer += pd[b];
      b = parent[b];
    }

    return answer;
  }

  // set same depth function
  private static int setdepth(int v, int d){
    while (depth[v] != d) {
      answer += pd[v];
      v = parent[v];
    }
    return v;
  }

  // dfs function
  private static void dfs(int v){
    visited[v] = true;
    for (Edge e: adjList[v]){
      if (!visited[e.adjvertex]){
        parent[e.adjvertex] = v;
        pd[e.adjvertex] = e.distance;
        depth[e.adjvertex] = depth[v] + 1;
        dfs(e.adjvertex);
      }
    }
  }
}

// Edge class
class Edge{
  int adjvertex;
  int distance;
  public Edge(int a, int d){
    adjvertex = a;
    distance = d;
  }
}