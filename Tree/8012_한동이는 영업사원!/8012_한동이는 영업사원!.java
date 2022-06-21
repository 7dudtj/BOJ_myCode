import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.List;
import java.util.LinkedList;

public class Main {
  // set static variables
  static int parent[], depth[];
  static int n;
  static boolean visited[];
  static List<Integer>[] adjList;

	public static void main(String args[]) throws Exception	{
    // set needed variables
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;
    n = Integer.parseInt(br.readLine());
    parent = new int[n+1];
    for (int i = 1; i <= n; i++) parent[i] = i;
    depth = new int[n+1];
    visited = new boolean[n+1];
    adjList = new List[n+1];
    for (int i = 1; i <= n; i++) adjList[i] = new LinkedList<>();
    int a, b, answer = 0;

    // get map
    for (int i = 0; i < n-1; i++){
      st = new StringTokenizer(br.readLine(), " ");
      a = Integer.parseInt(st.nextToken());
      b = Integer.parseInt(st.nextToken());
      adjList[a].add(b);
      adjList[b].add(a);
    }

    // do dfs
    depth[1] = 1;
    dfs(1);

    // process m query
    int m = Integer.parseInt(br.readLine());
    a = Integer.parseInt(br.readLine());
    for (int i = 0; i < m-1; i++){
      b = Integer.parseInt(br.readLine());
      answer += (depth[a] + depth[b] - 2*depth[lca(a, b)]);
      a = b;
    }

    // print answer and end program
    System.out.println(answer);
    br.close();
    return;
  }

  // get lowest common ancestor function
  private static int lca(int a, int b){
    // set same depth
    if (depth[a] != depth[b]){
      // depth[a] < depth[b]
      if (depth[a] < depth[b]){
        int tmp = a;
        a = b;
        b = tmp;
      }
      // set same depth
      while (depth[a] != depth[b]){
        a = parent[a];
      }
    }

    // if a == b
    if (a == b) return a;

    // find lowest common ancestor
    while (a != b){
      a = parent[a];
      b = parent[b];
    }

    return a;
  }

  // dfs function
  private static void dfs(int v){
    visited[v] = true;
    for (int i: adjList[v]){
      if (!visited[i]){
        parent[i] = v;
        depth[i] = depth[v] + 1;
        dfs(i);
      }
    }
  }
}