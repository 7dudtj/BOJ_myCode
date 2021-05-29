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
  static StringBuilder sb = new StringBuilder();
  static int[] time, indegree;

  public static void main(String[] args) throws IOException{
    // set needed variables
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;
    N = Integer.parseInt(br.readLine());
    graph = new List[N];
    for (int i = 0; i < N; i++) graph[i] = new LinkedList<>();
    time = new int[N];
    indegree = new int[N];
    int b;

    // get data
    for (int i = 0; i < N; i++){
      st = new StringTokenizer(br.readLine(), " ");
      time[i] = Integer.parseInt(st.nextToken());
      while ((b = Integer.parseInt(st.nextToken())) != -1){
        graph[b-1].add(i);
        indegree[i]++;
      }
    }

    // do topological sort
    ts();

    // print answer and end porgram
    System.out.print(sb);
    br.close();
    return;
  }

  // topological sort function
  public static void ts(){
    Queue<Integer> q = new LinkedList<>();
    int[] result = new int[N];

    // set queue
    for (int i = 0; i < N; i++){
      result[i] = time[i];
      if (indegree[i] == 0) q.offer(i);
    }

    // do topological sort
    while (!q.isEmpty()){
      int node = q.poll();

      for (int v: graph[node]){
        result[v] = Math.max(result[v], result[node] + time[v]);
        indegree[v]--;

        if (indegree[v] == 0) q.offer(v);
      }
    }

    // get answer
    for (int i = 0; i < N; i++) sb.append(result[i]).append('\n');
  }
}
