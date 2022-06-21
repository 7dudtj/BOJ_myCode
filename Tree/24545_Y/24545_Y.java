import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.List;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
  static List<Integer>[] adjList;
  static int N;
  public static void main(String[] args) throws IOException{
    // set needed components
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    N = Integer.parseInt(br.readLine());
    adjList = new List[N+1];
    for (int i = 1; i <= N; i++) adjList[i] = new LinkedList<>();
    StringTokenizer st;
    int u, v, tmp, answer = 0;
    Queue<Integer> test = new LinkedList<>();
    Queue<Integer> diameter = new LinkedList<>();
    boolean[] visited = new boolean[N+1];

    // make map
    for (int i = 0; i < N-1; i++){
      st = new StringTokenizer(br.readLine(), " ");
      u = Integer.parseInt(st.nextToken());
      v = Integer.parseInt(st.nextToken());
      adjList[u].add(v);
      adjList[v].add(u);
    }

    // find diameter
    int from = findLong(1);
    int to = findLong(from);
    int[] prev = new int[N+1];
    prev = bfs(from, to);

    // make queue
    test.add(to); diameter.add(to);
    while (prev[to] != 0){
      test.add(prev[to]); diameter.add(prev[to]);
      to = prev[to];
    }

    // find exception
    int max = Integer.MIN_VALUE;
    while (!test.isEmpty()){
      tmp = test.remove();
      visited[tmp] = true;
      int count = 0;
      for (Integer i: adjList[tmp]){
        count++;
      }
      if (max < count) max = count;
    }
    // exception handling
    if (max < 3){
      System.out.print(0);
      br.close();
      return;
    }

    // find maximum length way
    max = Integer.MIN_VALUE;
    int cur;
    while (!diameter.isEmpty()){
      tmp = diameter.remove();
      answer++;
      cur = maxLevel(tmp, visited);
      //System.out.println("from: "+tmp+", level: "+cur); // for test
      if (max < cur) max = cur;
    }
    //System.out.println("max: "+max); // for test

    // get answer
    answer += max;

    // print answer and end program
    System.out.print(answer);
    br.close();
    return;
  }

  // bfs function
  private static int[] bfs(int from, int to){
    Queue<Integer> q = new LinkedList<>();
    boolean[] visited = new boolean[N+1];
    visited[from] = true;
    int[] prev = new int[N+1];

    // do bfs
    q.add(from);
    visited[from] = true;
    while (!q.isEmpty()){
      int j = q.remove();
      for (Integer i: adjList[j]){
        if (!visited[i]){
          visited[i] = true;
          prev[i] = j;
          q.add(i);
        }
      }
    }

    return prev;
  }

  // find vertex which has longest distance
  private static int findLong(int v){
    Queue<Edge> q = new LinkedList<>();
    boolean[] visited = new boolean[N+1];
    visited[v] = true;
    q.add(new Edge(v, 0));
    Edge tmp = null;
    while (!q.isEmpty()){
      tmp = q.remove();
      for (Integer i: adjList[tmp.adj]){
        if (!visited[i]){
          visited[i] = true;
          q.add(new Edge(i, tmp.level+1));
        }
      }
    }

    return tmp.adj;
  } 

  // find maximum level function
  private static int maxLevel(int v, boolean[] visited){
    Queue<Edge> q = new LinkedList<>();
    q.add(new Edge(v, 0));
    Edge tmp = null;
    while (!q.isEmpty()){
      tmp = q.remove();
      for (Integer i: adjList[tmp.adj]){
        if (!visited[i]){
          visited[i] = true;
          q.add(new Edge(i, tmp.level+1));
        }
      }
    }

    return tmp.level;
  }
}

// Edge class
class Edge{
  int adj;
  int level;
  public Edge(int a, int l){
    adj = a;
    level = l;
  }
}