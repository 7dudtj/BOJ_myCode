import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.List;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
	public static void main(String args[]) throws IOException	{
    // set needed variables
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
    StringTokenizer st;
    Queue<Integer> q = new LinkedList<>();
    int N = Integer.parseInt(br.readLine());
    int M = Integer.parseInt(br.readLine());
    List<Edge>[] adjList = new List[N+1];
    for (int i = 1; i <= N; i++) adjList[i] = new LinkedList<>();
    boolean[] visited = new boolean[N+1];
    int infection = 0, from, to;

    // make graph
    for (int i = 0; i < M; i++){
      st = new StringTokenizer(br.readLine(), " ");
      from = Integer.parseInt(st.nextToken());
      to = Integer.parseInt(st.nextToken());
      adjList[from].add(new Edge(to));
      adjList[to].add(new Edge(from));
    }

    // do bfs
    q.add(1);
    visited[1] = true;
    while (!q.isEmpty()){
      int cur = q.poll();
      for (Edge e: adjList[cur]){
        if (!visited[e.adj]){
          q.add(e.adj);
          visited[e.adj] = true;
          infection++;
        }
      }
    }

    // print answer and end program
    System.out.println(infection);
    br.close();
    return;
  }
}

// Edge class
class Edge{
  int adj; // adjacent vertex number
  public Edge(int a){
    adj = a;
  }
}