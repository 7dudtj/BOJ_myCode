import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.List;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
  public static void main(String[] args) throws IOException{
    // set needed components
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine(), " ");
    int N = Integer.parseInt(st.nextToken());
    int K = Integer.parseInt(st.nextToken());
    List<Edge>[] adjList = new List[100001];
    for (int i = 0; i <= 100000; i++) adjList[i] = new LinkedList<>();
    int[] answer;

    // make adjList
    for (int i = 0; i <= 100000; i++){
      if (inRange(i-1)){
        Edge e = new Edge(i-1);
        adjList[i].add(e);
      }
      if (inRange(i+1)){
        Edge e = new Edge(i+1);
        adjList[i].add(e);
      }
      if (inRange(i*2)){
        Edge e = new Edge(i*2);
        adjList[i].add(e);
      }
    }

    // call BFS
    BFS mybfs = new BFS(adjList, N, K);
    answer = mybfs.d;

    // print answer and end program
    System.out.println(answer[K]);
    br.close();
    return;
  }

  // check in-range function
  private static boolean inRange(int i){
    if (i < 0 || i > 100000) return false;
    return true;
  }
}

// Edge class
class Edge{
  int adjvertex;
  public Edge(int a){
    adjvertex = a;
  }
}

// BFS class
class BFS{
  int N;
  int from, to;
  int[] d;
  List<Edge>[] graph;
  private boolean[] visited;
  // 생성자
  public BFS(List<Edge>[] adjList, int f, int t){
    N = adjList.length;
    graph = adjList;
    from = f;
    to = t;
    d = new int[N];
    d[from] = 0;
    visited = new boolean[N];
    for (int i = 0; i < N; i++) visited[i] = false;
    bfs(from);
  }
  private void bfs(int i){
    Queue<Integer> q = new LinkedList<Integer>();
    visited[i] = true;
    q.add(i);
    while (!q.isEmpty()){
      int j = q.remove();
      for (Edge e: graph[j]){
        if (!visited[e.adjvertex]){
          visited[e.adjvertex] = true;
          d[e.adjvertex] = d[j] + 1;
          q.add(e.adjvertex);
        }
      }
    }
  }
}

