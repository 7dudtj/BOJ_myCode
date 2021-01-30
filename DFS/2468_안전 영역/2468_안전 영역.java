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
    StringTokenizer st;
    int[][] map;
    int[] dx = {0,1,0,-1};
    int[] dy = {-1,0,1,0};
    int[] mapdata;

    // get n
    n = Integer.parseInt(br.readLine());

    // set map
    mapdata = new int[n*n];
    map = new int[n][n];
    adjList = new List[n*n];
    for (int i = 0; i < n*n; i++)
      adjList[i] = new LinkedList<>();

    // get map
    for (int i = 0; i < n; i++){
      st = new StringTokenizer(br.readLine(), " ");
      for (int j = 0; j < n; j++){
        mapdata[n*i+j] = Integer.parseInt(st.nextToken());
        map[i][j] = mapdata[n*i+j];
      }
    }

    // process map
    for (int i = 0; i < n; i++){
      for (int j = 0; j < n; j++){
        for (int k = 0; k < 4; k++){
          if (inRange(i+dx[k], j+dy[k])){
            Edge e = new Edge(n*(i+dx[k]) + (j+dy[k]), mapdata[n*(i+dx[k]) + (j+dy[k])]);
            adjList[n*i+j].add(e);
          }
        }
      }
    }

    // call DFS
    DFS dfs = new DFS(adjList, mapdata);
    dfs.sortmapdata();
    dfs.findSafe();

    // print answer and end program
    dfs.showAnswer();
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
  int high; // 상대방의 높이
  // 생성자
  public Edge(int v, int h){
    adjvertex = v;
    high = h;
  }
}

// DFS class
class DFS{
  int N;
  int start, end;
  int[] mapdata;
  int[] safeArea;
  List<Edge>[] graph;
  private boolean[] visited; // DFS 수행 중 방문한 정점을 true로 만든다
  private boolean[] land;
  // 생성자
  public DFS(List<Edge>[] adjList, int[] md){
    N = adjList.length;
    graph = adjList;
    mapdata = md;
    visited = new boolean[N];
    land = new boolean[N];
  }
  public void sortmapdata(){
    int[] a = new int[N];
    for (int i = 0; i < N; i++) a[i] = mapdata[i];
    Arrays.sort(a);
    start = a[0]-1;
    end = a[N-1]-1;
    safeArea = new int[end-start+1];
  }
  public void findSafe(){
    for (int i = start; i <= end; i++){
      for (int m = 0; m < N; m++){
        visited[m] = false;
        land[m] = true;
      }
      for (int m = 0; m < N; m++){
        if (mapdata[m] <= i){
          land[m] = false;
        }
      }
    
      int count = 0;
      for (int j = 0; j < N; j++){
        if (!visited[j] && land[j]){
          count++;
          dfs(j);
        }
      }
      safeArea[i-start] = count;
    }
  }
  public void dfs(int i){
    visited[i] = true; // 정점 i가 방문되어 visited[i]를 true로
    for (Edge e: graph[i]){ // 정점 i에 인접한 각 정점에 대해
      if (!visited[e.adjvertex] && land[e.adjvertex]){ // 정점 i에 인접한 정점이 방문 안되었으면 재귀호출
        dfs(e.adjvertex);
      }
    }
  }
  public void showAnswer(){
    Arrays.sort(safeArea);
    System.out.print(safeArea[end-start]);
  }
}
