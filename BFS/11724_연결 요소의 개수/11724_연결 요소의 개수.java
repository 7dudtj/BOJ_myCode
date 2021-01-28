import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.*;

public class Main {
  public static void main(String[] args) throws IOException{
    // set needed components
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n, m, u, v;
    StringTokenizer st;

    // get n and m
    st = new StringTokenizer(br.readLine(), " ");
    n = Integer.parseInt(st.nextToken());
    m = Integer.parseInt(st.nextToken());

    // set map
    List<Edge>[] adjList = new List[n];
    for (int i = 0; i < n; i++){
      adjList[i] = new LinkedList<>();
    }

    // get map
    for (int i = 0; i < m; i++){
      st = new StringTokenizer(br.readLine(), " ");
      u = Integer.parseInt(st.nextToken());
      v = Integer.parseInt(st.nextToken());
      Edge e1 = new Edge(v-1); adjList[u-1].add(e1);
      Edge e2 = new Edge(u-1); adjList[v-1].add(e2);
    }

    // do BFS
    BFS myBFS = new BFS(adjList);

    // print answer and end program
    System.out.print(myBFS.connected);
    br.close();
    return;
  }
}

class Edge{
  int adjvertex; // 간선의 다른쪽 정점
  // 생성자
  public Edge(int v){
    adjvertex = v;
  }
}

class BFS{
  int N; // 그래프 정점의 수
  int connected = 0;
  List<Edge>[] graph;
  private boolean[] visited; // BFS 수행 중 방문한 정점의 원소를 true로 만든다
  // 생성자
  public BFS(List<Edge>[] adjList){
    N = adjList.length;
    graph = adjList;
    visited = new boolean[N];
    for (int i = 0; i < N; i++) visited[i] = false; // 배열 초기화
    for (int i = 0; i < N; i++) {
      if (!visited[i]) {
        connected++;
        bfs(i);
      }  
    }
  }
  private void bfs(int i){
    Queue<Integer> q = new LinkedList<Integer>(); // 큐 선언
    visited[i] = true;
    q.add(i); // 큐에 시작 정점 삽입
    while (!q.isEmpty()){
      int j = q.remove(); // 큐에서 정점 j를 가져옴
      for (Edge e: graph[j]){ // 정점 j에 인접한 정점들 중 방문안된 정점 하나씩 방문
        if (!visited[e.adjvertex]){
          visited[e.adjvertex] = true;
          q.add(e.adjvertex); // 새로이 방문된 정점을 큐에 삽입
        }
      }
    }
  }
}
