import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.List;
import java.util.LinkedList;
import java.util.Arrays;

public class Main {
  // set needed variables
  static int n;
  static List<Edge>[] adjList;
  static int a, b, c, one, answer;
  static boolean[] visited;
  static int[] distance;

  public static void main(String[] args) throws IOException{
    // set needed components
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;
    n = Integer.parseInt(br.readLine());
    adjList = new List[n+1];
    for (int i = 1; i <= n; i++) adjList[i] = new LinkedList<>();

    // get edges
    for (int i = 0; i < n-1; i++){
      st = new StringTokenizer(br.readLine(), " ");
      a = Integer.parseInt(st.nextToken());
      b = Integer.parseInt(st.nextToken());
      c = Integer.parseInt(st.nextToken());

      adjList[a].add(new Edge(b, c));
      adjList[b].add(new Edge(a, c));
    }
    
    // print answer and end program
    System.out.println(dodfs());
    br.close();
    return;
  }

  // do DFS function
  private static int dodfs(){
    visited = new boolean[n+1];
    distance = new int[n+1];
    dfs(1);
    one = findpoint();
    visited = new boolean[n+1];
    distance = new int[n+1];
    dfs(one);
    Arrays.sort(distance);
    return distance[n];
  }

  // DFS function
  private static void dfs(int s){
    visited[s] = true;

    for (Edge e: adjList[s]){
      if (!visited[e.adj]){
        distance[e.adj] = distance[s] + e.w;
        dfs(e.adj);
      }
    }
  }

  // find point function
  private static int findpoint(){
    int idx = 0;
    int max = Integer.MIN_VALUE;

    for (int i = 1; i <= n; i++){
      if (distance[i] >= max){
        max = distance[i];
        idx = i;
      }
    }

    return idx;
  }
}

// Edge class
class Edge{
  int adj;
  int w;
  public Edge (int adj, int w){
    this.adj = adj;
    this.w = w;
  }
}
