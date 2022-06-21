import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.ArrayList;
import java.util.Collections;

public class Main {
  // set static variables
  static int[] elec;

	public static void main(String args[]) throws Exception	{
    // set needed variables
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine(), " ");
    int N = Integer.parseInt(st.nextToken());
    int M = Integer.parseInt(st.nextToken());
    int K = Integer.parseInt(st.nextToken());
    elec = new int[N+1];
    for (int i = 0; i <= N; i++) elec[i] = i;
    ArrayList<Edge> edgeList = new ArrayList<>();
    int u, v, w, a, b;
    int powerOn = K, cost = 0;

    // get electric power station
    st = new StringTokenizer(br.readLine(), " ");
    for (int i = 0; i < K; i++){
      elec[Integer.parseInt(st.nextToken())] = 0;
    }

    // make edgeList
    for (int i = 0; i < M; i++){
      st = new StringTokenizer(br.readLine(), " ");
      u = Integer.parseInt(st.nextToken());
      v = Integer.parseInt(st.nextToken());
      w = Integer.parseInt(st.nextToken());
      edgeList.add(new Edge(u, v, w));
    }
    Collections.sort(edgeList);

    // calculate cost
    for (int i = 0; i < M; i++){
      Edge e = edgeList.get(i);
      a = find(e.u);
      b = find(e.v);

      if (a == b) continue;

      union(a, b);
      cost += e.w;

      if (a == 0 || b == 0) powerOn++;

      if (powerOn == N) break;
    }

    // print answer and end program
    System.out.print(cost);
    br.close();
    return;
  }

  // find function
  private static int find(int v){
    if (elec[v] == v) return v;

    return elec[v] = find(elec[v]);
  }

  // union function
  private static void union(int a, int b){
    if (a < b) elec[b] = a;
    else elec[a] = b;
  }
}

// Edge class
class Edge implements Comparable<Edge>{
  // class variables
  int u;
  int v;
  int w;
  // constructor
  public Edge(int u, int v, int w){
    this.u = u;
    this.v = v;
    this.w = w;
  }
  // comparable
  @Override
  public int compareTo(Edge e){
    return w - e.w;
  }
}