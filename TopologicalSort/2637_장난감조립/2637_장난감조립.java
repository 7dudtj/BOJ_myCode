import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.List;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
  // set static variables
  static int N;
  static List<Integer>[] graph;
  static int[] indegree;
  static int[][] data;
  static boolean[] basic;

  public static void main(String[] args) throws IOException{
    // set needed variables
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;
    StringBuilder sb = new StringBuilder();
    N = Integer.parseInt(br.readLine());
    int M = Integer.parseInt(br.readLine());
    graph = new List[N];
    for (int i = 0; i < N; i++) graph[i] = new LinkedList<>();
    indegree = new int[N];
    data = new int[N][N];
    basic = new boolean[N];
    for (int i = 0; i < N; i++) basic[i] = false;
    int X, Y, K;

    // make graph
    for (int i = 0; i < M; i++){
      st = new StringTokenizer(br.readLine(), " ");
      X = Integer.parseInt(st.nextToken());
      Y = Integer.parseInt(st.nextToken());
      K = Integer.parseInt(st.nextToken());
      graph[Y-1].add(X-1);
      indegree[X-1]++;
      data[X-1][Y-1] = K;
    }

    // do topological sort
    ts();

    // make answer
    for (int i = 0; i < N; i++){
      if (basic[i]){
        sb.append(i+1).append(" ").append(data[N-1][i]).append('\n');
      }
    }

    // print answer and end program
    System.out.print(sb);
    br.close();
    return;
  }

  // topological sort function
  public static void ts(){
    // set function variables
    Queue<Integer> q = new LinkedList<>();

    // set Queue
    for (int i = 0; i < N; i++){
      if (indegree[i] == 0){
        basic[i] = true;
        q.add(i);
      }
    }

    // topological sort
    while (!q.isEmpty()){
      int node = q.poll();

      // for final
      if (node == N-1) return;
      // for basic 
      else if (basic[node]){
        for (int v: graph[node]){
          indegree[v]--;
          if (indegree[v] == 0) q. add(v);
        }
      }
      // for semi
      else{
        for (int v: graph[node]){
          for (int i = 0; i < N; i++){
            data[v][i] += data[node][i] * data[v][node];
          }
          indegree[v]--;
          if (indegree[v] == 0) q.add(v);
        }
      }
    }
  }
}
