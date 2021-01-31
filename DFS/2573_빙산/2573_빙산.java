import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.io.IOException;
import java.util.List;
import java.util.LinkedList;
import java.util.Arrays;

public class Main {
  // set needed variables
  static int N, M, size;
  static int year = 0;
  static int[] mapinfo;
  static int[][] map, numofSea;
  static int[] dx = {0,1,0,-1}, dy = {-1,0,1,0};

  public static void main(String[] args) throws IOException{
    // set needed components
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;
    List<Edge>[] adjList;
    boolean thaw = false, two = false;
    
    // get N and M
    st = new StringTokenizer(br.readLine(), " ");
    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());

    // set map
    size = N * M;
    adjList = new List[size];
    for (int i = 0; i < size; i++) adjList[i] = new LinkedList<>();
    mapinfo = new int[size];
    map = new int[N][M];


    // get map
    for (int i = 0; i < N; i++){
      st = new StringTokenizer(br.readLine(), " ");
      for (int j = 0; j < M; j++){
        map[i][j] = Integer.parseInt(st.nextToken());
        mapinfo[code(i,j)] = map[i][j];
      }
    }

    // process map for DFS
    for (int i = 0; i < N; i++){
      for (int j = 0; j < M; j++){
        for (int k = 0; k < 4; k++){
          if (inRange(i+dx[k], j+dy[k])){
            Edge e = new Edge(M*(i+dx[k]) + (j+dy[k]), map[i+dx[k]][j+dy[k]]);
            adjList[M*i+j].add(e);
          }
        }
      }
    }

    // do process
    while (true){
      // do main process
      findSea();
      thawIce();
      thaw = allThaw();
      year++;

      // check if all ice thaw
      if (thaw){
        System.out.println(0);
        br.close();
        return;
      }

      // check number of icebergs
      DFS dfs = new DFS(adjList, mapinfo);
      dfs.doDFS();
      if (dfs.num >= 2) two = true;

      // check if ice goes more than 2
      if (two){
        System.out.println(year);
        br.close();
        return;
      }
    }
  }

  // code generation function
  public static int code(int i, int j){
    return M*i+j;
  }
  // set numofSea function
  public static void findSea(){
    // reset numofSea
    numofSea = new int[N][M];
    for (int i = 0; i < N; i++){
      for (int j = 0; j < M; j++){
        numofSea[i][j] = 0;
      }
    }
    // do process
    for (int i = 0; i < N; i++){
      for (int j = 0; j < M; j++){
        for (int k = 0; k < 4; k++){
          // if map[i][j] is sea
          if (map[i][j] == 0) numofSea[i][j] = -1;
          // if map[i][j] is ice
          else{
            // there are sea nearby
            if (map[i+dx[k]][j+dy[k]] == 0) numofSea[i][j]++;
          }
        }
      }
    }
  }
  // thaw ice function
  public static void thawIce(){
    for (int i = 1; i < N-1; i++){
      for (int j = 1; j < M-1; j++){
        // if map[i][j] is sea, pass
        if (map[i][j] == 0){
          // do nothing
        }
        // if map[i][j] is ice
        else{
          // if ice is all thaw
          if (map[i][j] - numofSea[i][j] < 0) {
            map[i][j] = 0;
            mapinfo[M*i+j] = 0;
          }  
          // if ice is left
          else {
            map[i][j] -= numofSea[i][j];
            mapinfo[M*i+j] -= numofSea[i][j];
          }  
        }
      }
    }
  }
  // check all-thaw function
  public static boolean allThaw(){
    boolean thaw = true;
    for (int i = 1; i < N-1; i++){
      for (int j = 1; j < M-1; j++){
        if (map[i][j] != 0){
          thaw = false;
          break;
        }
      }
      if (!thaw) break;
    }
    return thaw;
  }
  // checking range function
  public static boolean inRange(int i, int j){
    if (i < 0 || i >= N || j < 0 || j >= M)
      return false;
    return true;
  }
}

// Edge class
class Edge{
  int adjvertex; // 간선의 다른쪽 정점
  int high;
  // 생성자
  public Edge(int v, int h){
    adjvertex = v;
    high = h;
  }
}

// DFS class
class DFS{
  int N; // 그래프 정점의 수
  int num;
  List<Edge>[] graph;
  private boolean[] visited; // DFS 수행 중 방문한 정점을 true로 만든다
  private int[] mapinfo;
  // 생성자
  public DFS(List<Edge>[] adjList, int[] map){
    N = adjList.length;
    graph = adjList;
    mapinfo = map;
    visited = new boolean[N];
  }
  public void doDFS(){
    num = 0;
    for (int i = 0; i < N; i++) visited[i] = false;
    for (int i = 0; i < N; i++) {
      if (!visited[i] && (mapinfo[i] != 0)) {
        num++;
        dfs(i);
      }  
    } 
  }
  private void dfs(int i){
    visited[i] = true; // 정점 i가 방문되어 visited[i]를 true로
    for (Edge e: graph[i]){ // 정점 i에 인접한 각 정점에 대해
      if (!visited[e.adjvertex] && (mapinfo[e.adjvertex] != 0)){ // 정점 i에 인접한 정점이 방문 안되었으면 재귀호출
        dfs(e.adjvertex);
      }
    }
  }
}
