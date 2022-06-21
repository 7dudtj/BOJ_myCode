import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.List;
import java.util.LinkedList;

public class Main {
  // set static variables
  static int depth[], parent[][];
  static boolean visited[];
  static List<Integer>[] adjList;
  static int k = 0, N;

	public static void main(String args[]) throws Exception	{
    // set needed variables
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;
    StringBuilder sb = new StringBuilder();
    N = Integer.parseInt(br.readLine());
    int tmp = 1, r, u, v, ru, uv, rv, answer;

    // get tree depth
    while (tmp <= N){
      tmp <<= 1;
      k++;
    }

    // set variables
    depth = new int[N+1];
    parent = new int[N+1][k];
    visited = new boolean[N+1];
    adjList = new List[N+1];
    for (int i = 1; i <= N; i++) adjList[i] = new LinkedList<>();

    // get map
    for (int i = 0; i < N-1; i++){
      st = new StringTokenizer(br.readLine(), " ");
      u = Integer.parseInt(st.nextToken());
      v = Integer.parseInt(st.nextToken());
      adjList[u].add(v);
      adjList[v].add(u);
    }

    // get depth
    depth[1] = 1;
    dfs(1);

    // get parent
    for (int i = 1; i < k; i++){
      for (int j = 1; j <= N; j++){
        parent[j][i] = parent[parent[j][i-1]][i-1];
      }
    }

    // get M query
    int M = Integer.parseInt(br.readLine());
    for (int i = 0; i < M; i++){
      st = new StringTokenizer(br.readLine(), " ");
      r = Integer.parseInt(st.nextToken());
      u = Integer.parseInt(st.nextToken());
      v = Integer.parseInt(st.nextToken());
      answer = 0;

      ru = lca(r, u);
      uv = lca(u, v);
      rv = lca(r, v);

      answer = depth[ru] >= depth[uv] ? ru : uv;
      answer = depth[answer] >= depth[rv] ? answer : rv;

      sb.append(answer).append('\n');
    }

    // print answer and end program
    System.out.print(sb);
    br.close();
    return;
  }

  // get lowest common ancestor function
  private static int lca(int a, int b){
    // depth: a > b
    if (depth[a] < depth[b]){
      int tmp = a;
      a = b;
      b = tmp;
    }

    // set same depth
    for (int i = k-1; i >= 0; i--){
      if (Math.pow(2, i) <= depth[a] - depth[b]){
        a = parent[a][i];
      }
    }

    // same depth >> if a == b
    if (a == b) return a;

    // find lowest common ancestor
    for (int i = k-1; i >= 0; i--){
      if (parent[a][i] != parent[b][i]){
        a = parent[a][i];
        b = parent[b][i];
      }
    }

    return parent[a][0];
  }

  // dfs function
  private static void dfs(int v){
    visited[v] = true;
    for (int i: adjList[v]){
      if (!visited[i]){
        parent[i][0] = v;
        depth[i] = depth[v] + 1;
        dfs(i);
      }
    }
  }
}