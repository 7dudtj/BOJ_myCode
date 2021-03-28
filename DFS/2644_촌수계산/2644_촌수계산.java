import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.List;
import java.util.LinkedList;

public class Main {
  // set needed static variables
  static int[] distance;
  static boolean[] visited;
  static List<Edge>[] adjList;

  public static void main(String[] args) throws IOException{
    // set needed variables
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;
    int n = Integer.parseInt(br.readLine());
    st = new StringTokenizer(br.readLine(), " ");
    int from = Integer.parseInt(st.nextToken());
    int to = Integer.parseInt(st.nextToken());
    int m = Integer.parseInt(br.readLine());
    int x, y;
    adjList = new List[n+1];
    for (int i = 1; i <= n; i++) adjList[i] = new LinkedList<>();
    distance = new int[n+1];
    for (int i = 1; i <= n; i++) distance[i] = 0;
    visited = new boolean[n+1];

    // get map
    for (int i = 0; i < m; i++){
      st = new StringTokenizer(br.readLine(), " ");
      x = Integer.parseInt(st.nextToken());
      y = Integer.parseInt(st.nextToken());
      adjList[x].add(new Edge(y));
      adjList[y].add(new Edge(x));
    }

    // do dfs
    dfs(from);

    // print answer and end program
    if (distance[to] == 0) System.out.println(-1);
    else System.out.println(distance[to]);
    br.close();
    return;
  }

  // dfs function
  private static void dfs(int s){
    visited[s] = true;

    for (Edge e: adjList[s]){
      if (!visited[e.to]){
        distance[e.to] = distance[s] + 1;
        dfs(e.to);
      }
    }
  }
}

// Edge class
class Edge{
  int to;
  public Edge(int t){
    to = t;
  }
}
