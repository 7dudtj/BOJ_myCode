import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.List;
import java.util.LinkedList;

public class Main {
  // set needed variables
  static int M, N;

  public static void main(String[] args) throws IOException{
    // set needed components
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;
    String s;
    int answer;
    int[] dx = {0,1,0,-1};
    int[] dy = {-1,0,1,0};
    int[][] map;
   

    // get M and N
    st = new StringTokenizer(br.readLine(), " ");
    M = Integer.parseInt(st.nextToken());
    N = Integer.parseInt(st.nextToken());

    // set map
    map = new int[N][M];
    List<Edge>[] adjList = new List[N*M];
    for (int i = 0; i < N*M; i++) adjList[i] = new LinkedList<>();

    // get map
    for (int i = 0; i < N; i++){
      s = br.readLine();
      for (int j = 0; j < M; j++) map[i][j] = Integer.parseInt(s.substring(j,j+1));
    }

    // make adjList
    for (int i = 0; i < N; i++){
      for (int j = 0; j < M; j++){
        for (int k = 0; k < 4; k++){
          if (inRange(i+dx[k], j+dy[k])){
            Edge e = new Edge((i+dx[k])*M+(j+dy[k]), map[i+dx[k]][j+dy[k]]);
            adjList[i*M+j].add(e);
          }
        }
      }
    }

    // do DijkstraSP
    DijkstraSP dsp = new DijkstraSP(adjList);
    answer = dsp.shortestPath(0);

    // print answer and end program
    System.out.println(answer);
    br.close();
    return;
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
  int adjvertex; // 간선의 다른쪽 끝 정점
  int weight; // 간선의 가중치
  public Edge(int v, int wt){
    adjvertex = v;
    weight = wt;
  }
}

// DijkstraSP class
class DijkstraSP{
  public int N; // 그래프 정점의 수
  List<Edge>[] graph;
  public int[] previous; // 최단경로상 이전 정점을 기록하기 위해
  public DijkstraSP(List<Edge>[] adjList){
    N = adjList.length;
    previous = new int[N];
    graph = adjList;
  }
  public int shortestPath(int s){
    boolean[] visited = new boolean[N];
    int[] D = new int[N];
    // 초기화
    for (int i = 0; i < N; i++){
      visited[i] = false;
      previous[i] = -1;
      D[i] = Integer.MAX_VALUE;
    }
    previous[s] = 0; // 시작점 s의 관련 정보 초기화
    D[s] = 0;
    for (int k = 0; k < N; k++){ // 방문 안된 정점들 중에서
      int minVertex = -1; // D원소 같이 최소인 minVertex 찾기
      int min = Integer.MAX_VALUE;
      for (int j = 0; j < N; j++){
        if ((!visited[j]) && (D[j] < min)){
          min = D[j];
          minVertex = j;
        }
      }
      visited[minVertex] = true;
      for (Edge e: graph[minVertex]){ // minVertex에 인접한 각 정점에 대해
        if (!visited[e.adjvertex]){ // 아직 방문 안된 정점에 대해 
          int currentDist = D[e.adjvertex];
          int newDist = D[minVertex] + e.weight;
          if (newDist < currentDist){
            D[e.adjvertex] = newDist; // 간선완화
            previous[e.adjvertex] = minVertex;
          }
        }
      }
    }
    return D[N-1];
  }
}
