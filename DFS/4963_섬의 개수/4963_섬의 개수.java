import java.util.Scanner;
import java.util.List;
import java.util.LinkedList;


public class Main {
  public static void main(String[] args) {
    // set needed components
    Scanner read = new Scanner(System.in);
    String s;
    int h, w, pos;
    int[][] map;
    String[] shuttle;
    int[] dx = {-1,-1,0,1,1,1,0,-1};
    int[] dy = {0,1,1,1,0,-1,-1,-1};

    // do process
    s = read.nextLine();
    while (!s.equals("0 0")){
      // get w and h
      pos = s.indexOf(" ");
      w = Integer.parseInt(s.substring(0,pos));
      h = Integer.parseInt(s.substring(pos+1));
      // set map
      map = new int[h][w];
      shuttle = new String[w];
      // get map
      for (int i = 0; i < h; i++){
        s = read.nextLine();
        shuttle = s.split(" ");
        for (int j = 0; j < w; j++){
          map[i][j] = Integer.parseInt(shuttle[j]);
        }
      }
      // process map
      int size = h*w;
      List<Edge>[] adjList = new List[size];
      for (int i = 0; i < size; i++)
        adjList[i] = new LinkedList<>();
      for (int i = 0; i < h; i++){
        for (int j = 0; j < w; j++){
          if (map[i][j] == 1){
            int code = w*i + j;
            for (int k = 0; k < 8; k++){
              if (inRange(i+dx[k], j+dy[k], h, w)){
                Edge e = new Edge(w*(i+dx[k]) + (j+dy[k]));
                adjList[code].add(e);
              }
            }
          }
        }
      }

      // call DFS
      DFS myDFS = new DFS(adjList, map, h, w);

      // print answer
      System.out.println(myDFS.answer);

      // get next input
      s = read.nextLine();
    }

    // end program
    read.close();
  }

  public static boolean inRange(int i, int j, int h, int w){
    if (i < 0 || i >= h || j < 0 || j >= w)
      return false;
    return true;
  }
}

class Edge{
  int adjvertex; // 간선의 다른쪽 code값
  // 생성자
  public Edge(int v){
    adjvertex = v;
  }
}

class DFS{
  int N; // 그래프 정점의 수
  int h, w;
  int[][] map;
  int answer = 0;
  List<Edge>[] graph;
  private boolean[] visited; // DFS 수행 중 방문한 정점을 true로 만든다
  private boolean[] land;
  // 생성자
  public DFS(List<Edge>[] adjList, int[][] mymap, int hh, int ww){
    N = adjList.length;
    graph = adjList;
    map = mymap;
    h = hh;
    w = ww;
    visited = new boolean[N];
    land = new boolean[N];
    for (int i = 0; i < N; i++) visited[i] = false; // 배열 초기화
    for (int i = 0; i < N; i++) land[i] = false; // land 초기화
    // land와 sea 구분
    for (int i = 0; i < h; i++){
      for (int j = 0; j < w; j++){
        if (map[i][j] == 1){
          land[w*i + j] = true;
        }
      }
    }
    // dfs 시행
    for (int i = 0; i < N; i++) {
      if (!visited[i] && land[i]) {
        dfs(i);
        answer++;
      }  
    }
  }
  private void dfs(int i){
    visited[i] = true; // 정점 i가 방문되어 visited[i]를 true로
    for (Edge e: graph[i]){ // 정점 i에 인접한 각 정점에 대해
      if (!visited[e.adjvertex]){ // 정점 i에 인접한 정점이 방문 안되었으면 재귀호출
        dfs(e.adjvertex);
      }
    }
  }
}
