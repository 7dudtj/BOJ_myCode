import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.List;
import java.util.LinkedList;
import java.util.Queue; // for test

public class Main {
  public static void main(String[] args) throws IOException{
    // set needed variables
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int T = Integer.parseInt(br.readLine());
    StringTokenizer st;
    int n, k, x, y, w, answer;
    int[] D, indegree;
    List<Integer>[] graph;

    // do process for T times
    for (int times = 0; times < T; times++){
      // get n and k
      st = new StringTokenizer(br.readLine(), " ");
      n = Integer.parseInt(st.nextToken());
      k = Integer.parseInt(st.nextToken());

      // get D
      D = new int[n];
      st = new StringTokenizer(br.readLine(), " ");
      for (int i = 0; i < n; i++){
        D[i] = Integer.parseInt(st.nextToken());
      }

      // make graph
      graph = new List[n];
      for (int i = 0; i < n; i++){
        graph[i] = new LinkedList<>();
      }

      // fill graph
      indegree = new int[n];
      for (int i = 0; i < k; i++){
        st = new StringTokenizer(br.readLine(), " ");
        x = Integer.parseInt(st.nextToken()) - 1;
        y = Integer.parseInt(st.nextToken()) - 1;
        graph[x].add(y);
        indegree[y]++;
      }

      // get w
      w = Integer.parseInt(br.readLine()) - 1;

      // do topological sort
      ts(graph, w, n, D, indegree);
    }

    // print answer and end program
    br.close();
    return;
  }

  // topological sort function
  public static void ts(List<Integer>[] graph, int w, int n, int[] D, int[] indegree){
    Queue<Integer> q = new LinkedList<>();
    int[] result = new int[n];

    for (int i = 0; i < n; i++){
      result[i] = D[i];
      if (indegree[i] == 0){
        q.offer(i);
      }
    }

    while (!q.isEmpty()){
      int node = q.poll();

      for (int v: graph[node]){
        result[v] = Math.max(result[v], result[node] + D[v]);
        indegree[v]--;

        if (indegree[v] == 0) q.offer(v);
      }
    }

    System.out.println(result[w]);
  }
}
