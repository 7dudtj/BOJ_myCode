import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.*;

public class Main {
  // set needed variables
  static int N, M;
  static int[] dx = {-1, 0, 1, 0};
  static int[] dy = {0, 1, 0, -1};
  static List<Edge>[] adjList;
  static int[][] map;
  static int[][] newmap;
  static int[] mapinfo;
  static int[] newmapinfo;

  public static void main(String[] args) throws IOException{
    // set needed components
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;   
    int[] safeZone;
    int count = -1;
    int nmC3;

    // get N and M
    st = new StringTokenizer(br.readLine(), " ");
    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());

    // get nmC3
    nmC3 = comb(N, M);

    // get map and mapinfo
    map = new int[N][M];
    newmap = new int[N][M];
    mapinfo = new int[N*M];
    newmapinfo = new int[N*M];
    for (int i = 0; i < N; i++){
      st = new StringTokenizer(br.readLine(), " ");
      for (int j = 0; j < M; j++){
        map[i][j] = Integer.parseInt(st.nextToken());
        mapinfo[i*M+j] = map[i][j];
      }
    }
    
    // set safeZone
    safeZone = new int[nmC3];
    for (int i = 0; i < nmC3; i++) safeZone[i] = Integer.MIN_VALUE;

    // set BFS
    BFS myBFS;

    // put extra wall
    for (int i = 0; i < N*M-2; i++){
      for (int j = i+1; j < N*M-1; j++){
        for (int k = j+1; k < N*M; k++){
          count++;
          newmap = mapcopy();
          newmapinfo = mapinfocopy();
          if (newmapinfo[i] == 0 && newmapinfo[j] == 0 && newmapinfo[k] == 0){
            newmapinfo[i] = newmapinfo[j] = newmapinfo[k] = 1;
            newmap[i/M][i%M] = newmap[j/M][j%M] = newmap[k/M][k%M] = 1;
            resetadjList(newmap);
            myBFS = new BFS(adjList, newmapinfo);
            myBFS.countArea();
            safeZone[count] = myBFS.safearea;
          }
        }
      }
    }
    
    // print answer and end program
    Arrays.sort(safeZone);
    System.out.println(safeZone[nmC3-1]);
    br.close();
    return;
  }

  // check if box is in range
  public static boolean inRange(int i, int j){
    if (i < 0 || i >= N || j < 0 || j >= M)
      return false;
    return true;
  }

  // reset adjList by using map
  public static void resetadjList(int[][] map){
    int size = N*M;
    adjList = new List[size];
    for (int i = 0; i < size; i++) adjList[i] = new LinkedList<>();
    for (int i = 0; i < N; i++){
      for (int j = 0; j < M; j++){
        int code = M*i + j;
        for (int k = 0; k < 4; k++){
          if (inRange(i+dx[k], j+dy[k])){
            Edge e;
            if (map[i+dx[k]][j+dy[k]] == 0){
              e = new Edge(M*(i+dx[k]) + (j+dy[k]), 0);
            }else if (map[i+dx[k]][j+dy[k]] == 1){
              e = new Edge(M*(i+dx[k]) + (j+dy[k]), 1);
            }else{
              e = new Edge(M*(i+dx[k]) + (j+dy[k]), 2);
            }
            adjList[code].add(e);
          }
        }
      }
    }
  }

  // map copy function
  public static int[][] mapcopy(){
    int[][] answer = new int[N][M];

    for (int i = 0; i < N; i++){
      for (int j = 0; j < M; j++){
        answer[i][j] = map[i][j];
      }
    }

    return answer;
  }

  // mapinfo copy function
  public static int[] mapinfocopy(){
    int[] answer = new int[N*M];

    for (int i = 0; i < N*M; i++) answer[i] = mapinfo[i];

    return answer;
  }

  // nmC3 function
  public static int comb(int n, int m){
    int size = n*m;
    int answer = 1;

    for (int i = 0; i < 3; i++){
      answer *= size;
      answer /= i+1;
      size--;
    }

    return answer;
  }
}

// Edge class
class Edge{
  int adjvertex;
  int value;
  // 생성자
  public Edge(int a, int v){
    adjvertex = a;
    value = v;
  }
}

// BFS class
class BFS{
  int N;
  int safearea = 0;
  int[] info;
  List<Edge>[] graph;
  private boolean[] visited;
  public BFS(List<Edge>[] adjList, int[] mapinfo){
    N = adjList.length;
    graph = adjList;
    info = mapinfo;
    visited = new boolean[N];
    for (int i = 0; i < N; i++) visited[i] = false;
    for (int i = 0; i < N; i++) {
      if (!visited[i] && info[i] == 2) bfs(i);
    }  
  }
  private void bfs(int i){
    Queue<Integer> q = new LinkedList<Integer>();
    visited[i] = true;
    q.add(i);
    while (!q.isEmpty()){
      int j = q.remove(); 
      for (Edge e: graph[j]){
        if (!visited[e.adjvertex] && info[e.adjvertex] == 0){
          visited[e.adjvertex] = true;
          info[e.adjvertex] = 2;
          q.add(e.adjvertex);
        }
      }
    }
  }
  public void countArea(){
    for (int i = 0; i < info.length; i++){
      if (info[i] == 0) safearea++;
    }
  }
}
