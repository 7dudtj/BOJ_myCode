import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.List;
import java.util.LinkedList;

public class Main {
  public static void main(String[] args) throws IOException{
    // set needed components
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;
    int a, b;
    int[] answer;
    int N = Integer.parseInt(br.readLine());
    List<Edge>[] adjList = new List[N+1];
    for (int i = 0; i <= N; i++) adjList[i] = new LinkedList<>();

    // get map
    for (int i = 0; i < N-1; i++){
      st = new StringTokenizer(br.readLine(), " ");
      a = Integer.parseInt(st.nextToken());
      b = Integer.parseInt(st.nextToken());
      Edge e1 = new Edge(b); adjList[a].add(e1);
      Edge e2 = new Edge(a); adjList[b].add(e2);
    }

    // call DFS
    DFS mydfs = new DFS(adjList);
    answer = mydfs.parent;

    // print answer and end program
    for (int i = 2; i <= N; i++) System.out.println(answer[i]);
    br.close();
    return;
  }
}

// Edge class
class Edge{
  int adjvertex;
  // 생성자
  public Edge(int v){
    adjvertex = v;
  }
}

// DFS class
class DFS{
  int N;
  int[] parent;
  List<Edge>[] graph;
  private boolean[] visited;
  // 생성자
  public DFS(List<Edge>[] adjList){
    N = adjList.length;
    graph = adjList;
    visited = new boolean[N+1];
    parent = new int[N+1];
    parent[1] = 1;
    for (int i = 1; i <= N; i++) visited[i] = false;
    dfs(1);
  }
  private void dfs(int i){
    visited[i] = true;
    for (Edge e: graph[i]){
      if (!visited[e.adjvertex]){
        parent[e.adjvertex] = i;
        dfs(e.adjvertex);
      }
    }
  }
}
