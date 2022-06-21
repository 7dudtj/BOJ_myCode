import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.List;
import java.util.LinkedList;
import java.util.Queue;
import java.util.ArrayList;
import java.util.Collections;

public class Main {
  public static void main(String args[]) throws IOException  {
    // set needed variables
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());
    int M = Integer.parseInt(br.readLine());
    List<Edge>[] adjList = new List[N+1];
    for (int i = 0; i <= N; i++) adjList[i] = new LinkedList<>();
    int[] indegree = new int[N+1];
    int[] previous = new int[N+1];
    int[] distance = new int[N+1];
    ArrayList<Integer> path = new ArrayList<>();
    StringTokenizer st;
    int p, q, r, cur;
    Queue<Integer> queue = new LinkedList<>();
    StringBuilder sb = new StringBuilder();

    // get map
    for (int i = 0; i < M; i++){
      st = new StringTokenizer(br.readLine(), " ");
      p = Integer.parseInt(st.nextToken());
      q = Integer.parseInt(st.nextToken());
      r = Integer.parseInt(st.nextToken());
      if (q == 1) q = 0; // destination: 1 >> 0
      adjList[p].add(new Edge(q, r));
      indegree[q]++;
    }

    // exception handling
    if (N == 1){
      System.out.print("0\n1");
      br.close();
      return;
    }

    // do topological sort
    for (int i = 0; i <= N; i++){
      if (indegree[i] == 0) queue.add(i);
    }
    while (!queue.isEmpty()){
      cur = queue.poll();
      for (Edge e: adjList[cur]){
        if (distance[e.adj] <= distance[cur] + e.weight){
          distance[e.adj] = distance[cur] + e.weight;
          previous[e.adj] = cur;
        }
        indegree[e.adj]--;
        if (indegree[e.adj] == 0) queue.add(e.adj);
      }
    }

    // find path
    cur = 0;
    path.add(1);
    while (cur != 1){
      cur = previous[cur];
      path.add(cur);
    }
    Collections.reverse(path);

    // print answer and end program
    System.out.println(distance[0]);
    for (Integer i: path) sb.append(i).append(" ");
    System.out.print(sb);
    br.close();
    return;
  }
}

// Edge class
class Edge{
  int adj;
  int weight;
  public Edge(int a, int w){
    adj = a;
    weight = w;
  }
}