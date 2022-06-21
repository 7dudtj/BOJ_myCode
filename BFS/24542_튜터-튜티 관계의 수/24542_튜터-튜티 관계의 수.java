import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.List;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
  static boolean[] visited;
  static List<Integer>[] adjList;
  public static void main(String[] args) throws IOException{
    // set needed components
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine(), " ");
    int N = Integer.parseInt(st.nextToken());
    int M = Integer.parseInt(st.nextToken());
    adjList = new List[N+1];
    for (int i = 1; i <= N; i++) adjList[i] = new LinkedList<>();
    long answer = 0;
    Queue<Integer> q = new LinkedList<>();
    int number = 0;
    visited = new boolean[N+1];

    // get map
    int u, v;
    for (int i = 0; i < M; i++){
      st = new StringTokenizer(br.readLine(), " ");
      u = Integer.parseInt(st.nextToken());
      v = Integer.parseInt(st.nextToken());
      adjList[u].add(v);
      adjList[v].add(u);
    }

    // do bfs
    for (int i = 1; i <= N; i++){
      if (!visited[i]){
        number = bfs(i);
        q.add(number);
      }
    }

    // calculate answer
    long tmp;
    answer = q.remove();
    while (!q.isEmpty()){
      tmp = q.remove();
      answer = (answer * tmp) % 1000000007;
    }

    // print answer and end program
    System.out.print(answer);
    br.close();
    return;
  }

  // bfs function
  private static int bfs(int i){
    Queue<Integer> q = new LinkedList<>();
    int count = 1;
    visited[i] = true;
    q.add(i);
    while (!q.isEmpty()){
      int j = q.remove();
      for (Integer v: adjList[j]){
        if (!visited[v]){
          visited[v] = true;
          count++;
          q.add(v);
        }
      }
    }

    return count;
  }
}