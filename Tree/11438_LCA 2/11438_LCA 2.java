import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.List;
import java.util.LinkedList;

public class Main {
  // set static variables
  static int parent[][], depth[];
  static boolean visited[];
  static List<Integer>[] adjList;
  static int k = 0, N;

	public static void main(String args[]) throws Exception	{
    // set needed variables
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;
    StringBuilder sb = new StringBuilder();
    N = Integer.parseInt(br.readLine());
    int tmp = 1, a, b;

    // get tree depth
    while (tmp <= N){
      tmp <<= 1;
      k++;
    }

    // set variables
    parent = new int[N+1][k];
    depth = new int[N+1];
    visited = new boolean[N+1];
    adjList = new List[N+1];
    for (int i = 1; i <= N; i++) adjList[i] = new LinkedList<>();

    // get map
    for (int i = 0; i < N-1; i++){
      st = new StringTokenizer(br.readLine(), " ");
      a = Integer.parseInt(st.nextToken());
      b = Integer.parseInt(st.nextToken());
      adjList[a].add(b);
      adjList[b].add(a);
    }

    // get depth
    depth[1] = 1;
    dfs(1);
    
    // get parent
    getParent();

    // get M query
    int M = Integer.parseInt(br.readLine());
    for (int i = 0; i < M; i++){
      st = new StringTokenizer(br.readLine(), " ");
      a = Integer.parseInt(st.nextToken());
      b = Integer.parseInt(st.nextToken());
      int answer = getLca(a, b);
      sb.append(answer).append('\n');
    }

    // print answer and end program
    System.out.print(sb);
    br.close();
    return;
  }

  // get Lowest Common Ancestor
  private static int getLca(int a, int b){
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

  // get parent function
  private static void getParent(){
    for (int i = 1; i < k; i++){
      for (int j = 1; j <= N; j++){
        parent[j][i] = parent[parent[j][i-1]][i-1];
      }
    }
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