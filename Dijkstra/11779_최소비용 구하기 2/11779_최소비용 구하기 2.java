import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.List;
import java.util.LinkedList;
import java.util.PriorityQueue;

public class Main {
  public static void main(String[] args) throws IOException{
    // set needed components
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;
    int n = Integer.parseInt(br.readLine());
    int m = Integer.parseInt(br.readLine());
    List<Edge>[] adjList = new List[n];
    for (int i = 0; i < n; i++) adjList[i] = new LinkedList<>();
    boolean[] visited = new boolean[n];
    int[] prev = new int[n];
    for (int i = 0; i < n; i++) prev[i] = i;
    int[] distance = new int[n];
    for (int i = 0; i < n; i++) distance[i] = Integer.MAX_VALUE;
    int count = 0;
    StringBuilder sb = new StringBuilder();
    int a, b, c, start, end;

    // get bus lines
    for (int i = 0; i < m; i++){
      st = new StringTokenizer(br.readLine(), " ");
      a = Integer.parseInt(st.nextToken()) - 1;
      b = Integer.parseInt(st.nextToken()) - 1;
      c = Integer.parseInt(st.nextToken());
      adjList[a].add(new Edge(a, b, c));
    }

    // get start and end
    st = new StringTokenizer(br.readLine(), " ");
    start = Integer.parseInt(st.nextToken()) - 1;
    end = Integer.parseInt(st.nextToken()) - 1;

    // do Dijkstra
    distance[start] = 0;
    PriorityQueue<Edge> pq = new PriorityQueue<>();
    pq.add(new Edge(start, start, 0));
    while (!pq.isEmpty()){
      Edge tmp = pq.poll();
      if (visited[tmp.to]) continue;
      visited[tmp.to] = true;
      prev[tmp.to] = tmp.from;
      for (Edge e: adjList[tmp.to]){
        if (!visited[e.to] && distance[tmp.to] + e.cost < distance[e.to]){
          distance[e.to] = distance[tmp.to] + e.cost;
          pq.add(new Edge(tmp.to, e.to, distance[e.to]));
        }
      }
    }

    // get count and ways
    int finish = end;
    while (true){
      // check end
      if (prev[end] == start){
        sb.insert(0, (start + 1) + " ");
        count++;
        break;
      }

      // do main process
      sb.insert(0, (prev[end] + 1) + " ");
      count++;
      end = prev[end];
    }
    count++;
    sb.append(finish + 1);

    // print answer and end program
    System.out.println(distance[finish]);
    System.out.println(count);
    System.out.println(sb);
    br.close();
    return;
  }
}

// Edge class
class Edge implements Comparable<Edge>{
  // class variables
  int from;
  int to;
  int cost;
  // constructor
  public Edge(int f, int t, int c){
    from = f;
    to = t;
    cost = c;
  }
  // comparable
  @Override
  public int compareTo(Edge e){
    return cost - e.cost;
  }
}