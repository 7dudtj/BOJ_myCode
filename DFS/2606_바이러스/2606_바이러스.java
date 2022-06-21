import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.List;
import java.util.LinkedList;

public class Main {
  static boolean[] visited;
  static List<Edge>[] adjList;
  static int infection = 0;
	public static void main(String args[]) throws IOException	{
    // set needed variables
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
    StringTokenizer st;
    int N = Integer.parseInt(br.readLine());
    int M = Integer.parseInt(br.readLine());
    adjList = new List[N+1];
    for (int i = 1; i <= N; i++) adjList[i] = new LinkedList<>();
    visited = new boolean[N+1];
    int from, to;

    // make graph
    for (int i = 0; i < M; i++){
      st = new StringTokenizer(br.readLine(), " ");
      from = Integer.parseInt(st.nextToken());
      to = Integer.parseInt(st.nextToken());
      adjList[from].add(new Edge(to));
      adjList[to].add(new Edge(from));
    }

    // do dfs
    dfs(1);

    // print answer and end program
    System.out.println(infection-1);
    br.close();
    return;
  }

  // dfs function
  private static void dfs(int v){
    visited[v] = true;
    infection++;
    for (Edge e: adjList[v]){
      if (!visited[e.adj]) dfs(e.adj);
    }
  }
}

// Edge class
class Edge{
  int adj; // adjacent vertex number
  public Edge(int a){
    adj = a;
  }
}
