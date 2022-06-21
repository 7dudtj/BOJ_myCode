import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.List;
import java.util.LinkedList;

public class Main {
  // set static variables
  static int depth[], parent[];
  static List<Integer>[] adjList;
  static boolean visited[];

	public static void main(String args[]) throws Exception	{
    // set needed variables
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;
    StringBuilder sb = new StringBuilder();
    int N = Integer.parseInt(br.readLine());
    adjList = new List[N+1];
    for (int i = 1; i <= N; i++) adjList[i] = new LinkedList<>();
    depth = new int[N+1];
    for (int i = 1; i <= N; i++) depth[i] = 1;
    parent = new int[N+1];
    for (int i = 1; i <= N; i++) parent[i] = i;
    visited = new boolean[N+1];
    int a, b;

    // get tree
    for (int i = 0; i < N-1; i++){
      st = new StringTokenizer(br.readLine(), " ");
      a = Integer.parseInt(st.nextToken());
      b = Integer.parseInt(st.nextToken());
      adjList[a].add(b);
      adjList[b].add(a);
    }

    // find parent and depth
    dfs(1);

    // find answer
    int M = Integer.parseInt(br.readLine());
    for (int i = 0; i < M; i++){
      st = new StringTokenizer(br.readLine(), " ");
      a = Integer.parseInt(st.nextToken());
      b = Integer.parseInt(st.nextToken());
      sb.append(findLca(a,b)).append('\n');
    }

    // print answer and end program
    System.out.print(sb);
    br.close();
    return;
  }

  // find lowest common ancestor function
  private static int findLca(int a, int b){
    // set same depth
    if (depth[a] > depth[b]){
      a = setdepth(a, depth[b]);
    } else if (depth[a] < depth[b]){
      b = setdepth(b, depth[a]);
    }

    // find Lowest Common Ancestor
    while (a != b){
      a = parent[a];
      b = parent[b];
    }

    return a;
  }

  // set same depth function
  private static int setdepth(int v, int d){
    while (depth[v] != d) v = parent[v];
    return v;
  }

  // dfs function
  private static void dfs(int v){
    visited[v] = true;
    for (int k: adjList[v]){
      if (!visited[k]){
        parent[k] = v;
        depth[k] = depth[v] + 1;
        dfs(k);
      }
    }
  }
}