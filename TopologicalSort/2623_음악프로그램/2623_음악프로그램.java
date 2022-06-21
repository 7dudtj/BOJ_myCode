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
  static int[] indegree;
  static boolean exception = false;

  public static void main(String[] args) throws IOException{
    // set needed variables
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine(), " ");
    N = Integer.parseInt(st.nextToken());
    int M = Integer.parseInt(st.nextToken());
    graph = new List[N];
    for (int i = 0; i < N; i++) graph[i] = new LinkedList<>();
    indegree = new int[N];
    int p, from, to;

    // get PD's choice
    for (int i = 0; i < M; i++){
      st = new StringTokenizer(br.readLine(), " ");
      p = Integer.parseInt(st.nextToken());
      if (p >= 2){
        from = Integer.parseInt(st.nextToken());
        for (int j = 0; j < p-1; j++){
          to = Integer.parseInt(st.nextToken());
          graph[from-1].add(to-1);
          indegree[to-1]++;
          from = to;
        }
      }
    }

    // do topological sort
    ts();

    // print answer and end program
    if (!exception) System.out.print(sb);
    else System.out.print("0");
    br.close();
    return;
  }

  // topological sort function
  public static void ts(){
    // set function variables
    Queue<Integer> q = new LinkedList<>();
    int count = 0;

    // set Queue
    for (int i = 0; i < N; i++){
      if (indegree[i] == 0) q.add(i);
    }

    // topological sort
    while (!q.isEmpty()){
      int node = q.poll();

      for (int v: graph[node]){
        indegree[v]--;
        if (indegree[v] == 0) q.add(v);
      }

      sb.append(node + 1).append('\n');
      count++;
    }

    // check exception
    if (count != N) exception = true;
  }
}
