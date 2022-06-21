import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.io.IOException;
import java.util.List;
import java.util.LinkedList;

class Main {
  // set needed variables
  static int N;

  public static void main(String[] args) throws IOException{
    // set needed components
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    N = Integer.parseInt(br.readLine());
    StringTokenizer st;
    int[] dx = {0,1,0,-1};
    int[] dy = {-1,0,1,0};
    int count = 0;

    // do process
    while (N != 0){
      // set needed variables
      int[] answer = new int[N*N];
      List<Edge>[] adjList = new List[N*N];
      for (int i = 0; i < N*N; i++) adjList[i] = new LinkedList<>();
      int[] mapinfo = new int[N*N];
      int[][] map = new int[N][N];
      int from = 0, to = N*N-1;
      count++;

      // get map
      for (int i = 0; i < N; i++){
        st = new StringTokenizer(br.readLine(), " ");
        for (int j = 0; j < N; j++){
          mapinfo[i*N+j] = Integer.parseInt(st.nextToken());
          map[i][j] = mapinfo[i*N+j];
        }
      }

      // process map
      for (int i = 0; i < N; i++){
        for (int j = 0; j < N; j++){
          for (int k = 0; k < 4; k++){
            if (inRange(i+dx[k], j+dy[k])){
              Edge e = new Edge(N*i+j, N*(i+dx[k])+(j+dy[k]), mapinfo[N*(i+dx[k])+(j+dy[k])]);
              adjList[N*i+j].add(e);
            }
          }
        }
      }

      // do Dijkstra
      DijkstraSP dsp = new DijkstraSP(adjList);
      answer = dsp.shortestPath(from);

      // print answer
      System.out.println("Problem "+count+": "+(answer[to]+mapinfo[from]));


      /*
      // for test
      for (int i = 0; i < N*N; i++){
        System.out.println("answer["+i+"]: "+answer[i]);
      }
      for (int i = 0; i < N; i++){
        for (int j = 0; j < N; j++){
          System.out.print(map[i][j]+" ");
        }
        System.out.println();
      }
      */
      


      // finish cycle and get next N
      N = Integer.parseInt(br.readLine());
    }

    // end program
    br.close();
    return;
  }

  // checking range function
  public static boolean inRange(int i, int j){
    if (i < 0 || i >= N || j < 0 || j >= N)
      return false;
    return true;
  }
}

// Edge class
class Edge{
  int vertex; // 간선의 한쪽 끝 정점
  int adjvertex; // 간선의 다른쪽 끝 정점
  int weight; // 간선의 가중치
  public Edge(int u, int v, int wt){
    vertex = u;
    adjvertex = v;
    weight = wt;
  }
}

// Dijsktra class
class DijkstraSP{
  public int N; // 그래프 정점의 수
  List<Edge>[] graph;
  public int[] previous; // 최단경로상 이전 정점을 기록하기 위해
  public DijkstraSP(List<Edge>[] adjList){
    N = adjList.length;
    previous = new int[N];
    graph = adjList;
  }
  public int[] shortestPath(int s){
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
      if (minVertex == -1) break; // 그래프가 전부 연결되어있지 않을수도 있음
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
    return D;
  }
}
