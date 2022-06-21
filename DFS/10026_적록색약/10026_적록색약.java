import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.io.IOException;
import java.util.List;
import java.util.LinkedList;
import java.util.Arrays;

public class Main {
  // set needed variables
  static int n;

  public static void main(String[] args) throws IOException{
    // set needed components
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    List<Edge>[] adjList;
    String[][] map;
    int[] dx = {0,1,0,-1};
    int[] dy = {-1,0,1,0};
    String[] mapdata;

    // get n
    n = Integer.parseInt(br.readLine());

    // set map
    mapdata = new String[n*n];
    map = new String[n][n];
    adjList = new List[n*n];
    for (int i = 0; i < n*n; i++)
      adjList[i] = new LinkedList<>();

    // get map
    for (int i = 0; i < n; i++){
      String s = br.readLine();
      for (int j = 0; j < n; j++){
        mapdata[n*i+j] = s.substring(j,j+1);
        map[i][j] = mapdata[n*i+j];
      }
    }

    // process map
    for (int i = 0; i < n; i++){
      for (int j = 0; j < n; j++){
        for (int k = 0; k < 4; k++){
          if (inRange(i+dx[k], j+dy[k])){
            Edge e = new Edge(n*(i+dx[k]) + (j+dy[k]));
            adjList[n*i+j].add(e);
          }
        }
      }
    }

    // call DFS
    DFS dfs = new DFS(adjList, mapdata);
    dfs.findNonweak();
    dfs.findWeak();
    dfs.showAnswer();

    // print answer and end program
    br.close();
    return;
  }

  // checking range function
  public static boolean inRange(int i, int j){
    if (i < 0 || i >= n || j < 0 || j >= n)
      return false;
    return true;
  }
}

// Edge class
class Edge{
  int adjvertex; // 간선의 다른쪽 정점
  // 생성자
  public Edge(int v){
    adjvertex = v;
  }
}

// DFS class
class DFS{
  int N;
  int nonweak = 0, weak = 0;
  String[] mapdata;
  List<Edge>[] graph;
  private boolean[] visited; // DFS 수행 중 방문한 정점을 true로 만든다
  // 생성자
  public DFS(List<Edge>[] adjList, String[] md){
    N = adjList.length;
    graph = adjList;
    mapdata = md;
    visited = new boolean[N];
  }
  public void findNonweak(){
    int count = 0;
    for (int i = 0; i < N; i++) visited[i] = false;
    for (int i = 0; i < N; i++){
      if (!visited[i]){
        count++;
        dfs(i);
      }
    }
    nonweak = count;
  }
  public void findWeak(){
    int count = 0;
    for (int i = 0; i < N; i++) visited[i] = false;
    for (int i = 0; i < N; i++){
      if (mapdata[i].equals("G")) mapdata[i] = "R";
    }
    for (int i = 0; i < N; i++){
      if (!visited[i]){
        count++;
        dfs(i);
      }
    }
    weak = count;
  }
  public void showAnswer(){
    System.out.print(nonweak+" "+weak);
  }
  public void dfs(int i){
    visited[i] = true; // 정점 i가 방문되어 visited[i]를 true로
    for (Edge e: graph[i]){ // 정점 i에 인접한 각 정점에 대해
      if (!visited[e.adjvertex] && (mapdata[i].equals(mapdata[e.adjvertex]))){ // 정점 i에 인접한 정점이 방문 안되었으면 재귀호출
        dfs(e.adjvertex);
      }
    }
  }
}
