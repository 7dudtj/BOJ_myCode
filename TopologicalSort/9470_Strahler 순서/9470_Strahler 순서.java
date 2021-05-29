import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.List;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
  // set static variables
  static StringBuilder sb = new StringBuilder();

  public static void main(String[] args) throws IOException{
    // set needed variables
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;
    int T = Integer.parseInt(br.readLine());
    int K, M, P, A, B;
    List<Integer>[] graph;
    List<Integer>[] regraph;
    int[] strahler, indegree;

    // do main process for T times
    for (int times = 0; times < T; times++){
      // get K, M, and P
      st = new StringTokenizer(br.readLine(), " ");
      K = Integer.parseInt(st.nextToken());
      M = Integer.parseInt(st.nextToken());
      P = Integer.parseInt(st.nextToken());

      // set map
      graph = new List[M];
      regraph = new List[M];
      for (int i = 0; i < M; i++) {
        graph[i] = new LinkedList<>();
        regraph[i] = new LinkedList<>();
      }
      strahler = new int[M];
      indegree = new int[M];

      // get map
      for (int i = 0; i < P; i++){
        st = new StringTokenizer(br.readLine(), " ");
        A = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());
        graph[A-1].add(B-1);
        regraph[B-1].add(A-1);
        indegree[B-1]++;
      }

      // do topological sort
      ts(M, indegree, graph, regraph, K);
    }

    // print answer and end program
    System.out.print(sb);
    br.close();
    return;
  }

  // topological sort function
  public static void ts(int M, int[] indegree, List<Integer>[] graph, 
  List<Integer>[] regraph, int K){
    // set function variables
    Queue<Integer> q = new LinkedList<>();
    int[] result = new int[M];

    // set Queue
    for (int i = 0; i < M; i++){
      if (indegree[i] == 0){
        q.offer(i);
        result[i] = 1;
      }
    }

    // do topological sort
    while (!q.isEmpty()){
      int node = q.poll();
      //System.out.println("node: "+node); // for test

      for (int v: graph[node]){
        boolean allcheck = true;
        int max = Integer.MIN_VALUE;
        int maxcount = 0;
        indegree[v]--;

        for (int i: regraph[v]){
          if (result[i] == 0){
            allcheck = false;
            break;
          }else{
            if (max < result[i]) max = result[i];
          }
        }

        if (allcheck){
          for (int i: regraph[v]){
            if (result[i] == max) maxcount++;
          }
        }

        if (maxcount >= 2){
          result[v] = max + 1;
        }else{
          result[v] = max;
        }

        if (indegree[v] == 0) q.offer(v);
      }
    }

    // get answer
    sb.append(K).append(" ").append(result[M-1]).append('\n');
    // for test
    //for (int i = 0; i < M; i++){
    //  System.out.println("result["+i+"]: "+result[i]);
    //}
  }
}
