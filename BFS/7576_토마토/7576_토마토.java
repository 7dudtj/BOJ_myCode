import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.*;

public class Main {

  // set needed variables
  static int w, h;

  public static void main(String[] args) throws IOException{
    // set needed components
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int[][] map;
    StringTokenizer st;
    // left, down, right, up
    int[] dx = {-1, 0, 1, 0};
    int[] dy = {0, 1, 0, -1};
    int[] tomato;

    // get h and w
    st = new StringTokenizer(br.readLine(), " ");
    w = Integer.parseInt(st.nextToken());
    h = Integer.parseInt(st.nextToken());

    // get map and tomato info
    map = new int[h][w];
    tomato = new int[h*w];
    for (int i = 0; i < h; i++){
      st = new StringTokenizer(br.readLine(), " ");
      for (int j = 0; j < w; j++){
        map[i][j] = Integer.parseInt(st.nextToken());
        tomato[i*w+j] = map[i][j];
      }
    }

    // process map
    int size = w * h;
    List<Edge>[] adjList = new List[size];
    for (int i = 0; i < size; i++) adjList[i] = new LinkedList<>();
    for (int i = 0; i < h; i++){
      for (int j = 0; j < w; j++){
        int code;
        boolean raw;
        // i am not a tomato
        if (map[i][j] == -1){
          // do nothing
        }
        // i am a tomato
        else {
          code = w*i + j;
          for (int k = 0; k < 4; k++){
            if (inRange(i+dx[k], j+dy[k])){
              // if friend is raw tomato
              if (map[i+dx[k]][j+dy[k]] == 0) raw = true;
              // if friend is ripen tomato
              else raw = false;
              // make edge
              Edge e = new Edge(w*(i+dx[k]) + (j+dy[k]), raw);
              adjList[code].add(e);
            }
          }
        }
      }
    }

    // call BFS
    BFS myBFS = new BFS(adjList, tomato);
    myBFS.checkfail();
    myBFS.findanswer();

    // print answer
    System.out.print(myBFS.answer);

    // end program
    br.close();
    return;
  }

  // check if box is in range
  public static boolean inRange(int i, int j){
    if (i < 0 || i >= h || j < 0 || j >= w)
      return false;
    return true;
  }
}

class Edge{
  int adjvertex; // 간선의 다른쪽 code값
  boolean raw;
  // 생성자
  public Edge(int v, boolean r){
    adjvertex = v;
    raw = r;
  }
}

class BFS{
  int N; // 그래프 정점의 수
  int count = 0;
  int answer = 0;
  List<Edge>[] graph;
  public boolean[] visited; // BFS 수행 중 방문한 정점의 원소를 true로 만든다
  public int[] tomato;
  public int[] ripeday;
  // 생성자
  public BFS(List<Edge>[] adjList, int[] t){
    N = adjList.length;
    graph = adjList;
    tomato = t;
    visited = new boolean[N];
    ripeday = new int[N];
    setripeday();
    for (int i = 0; i < N; i++) visited[i] = false; // 배열 초기화
    bfs();
  }
  // bfs function
  public void bfs(){
    // make queue
    Queue<Integer> q = new LinkedList<Integer>(); // 큐 선언

    // put ripe tomatos to queue
    for (int i = 0; i < N; i++){
      if (!visited[i] && ripeday[i] == 0){
        visited[i] = true;
        q.add(i);
      }
    }

    // do process using queue
    while (!q.isEmpty()){
      int j = q.remove(); // 큐에서 정점 j를 가져옴
      for (Edge e: graph[j]){ // 정점 j에 인접한 정점들 중 방문안된 정점 하나씩 방문
        if (!visited[e.adjvertex] && tomato[e.adjvertex] == 0){
          visited[e.adjvertex] = true;
          tomato[e.adjvertex] = 1;
          e.raw = true;
          ripeday[e.adjvertex] = ripeday[j] + 1;
          q.add(e.adjvertex); // 새로이 방문된 정점을 큐에 삽입
        }
      }
    }
  }
  // find out if not ripen tomato exists
  public void checkfail(){
    for (int i = 0; i < N; i++){
      if (!visited[i] && tomato[i] == 0){
        answer = -1;
        break;
      }
    }
  }
  // set ripeday
  public void setripeday(){
    for (int i = 0; i < N; i++){
      // no tomato: max value
      if (tomato[i] == -1) ripeday[i] = Integer.MAX_VALUE;
      // raw tomato: min value
      else if (tomato[i] == 0) ripeday[i] = Integer.MIN_VALUE;
      // ripen tomato: 0
      else ripeday[i] = 0;
    }
  }
  // find answer
  public void findanswer(){
    // check fail
    if (answer == -1) return;
    // preset data
    for (int i = 0; i < N; i++){
      if (ripeday[i] == Integer.MAX_VALUE) ripeday[i] = Integer.MIN_VALUE;
    }
    Arrays.sort(ripeday);
    answer = ripeday[N-1];
  }
}
