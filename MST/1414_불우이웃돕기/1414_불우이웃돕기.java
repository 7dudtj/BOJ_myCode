import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

public class Main{
  // set needed static components
  static int[] parent;

  public static void main(String[] args) throws IOException{
    // set needed components
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());
    int sum = 0, mstcount = 0, mstlen = 0;;
    ArrayList<Edge> edgeList = new ArrayList<>();
    int[][] map = new int[N][N];
    String input;
    int d;
    parent = new int[N];
    for (int i = 0; i < N; i++) parent[i] = i;

    // get data
    for (int i = 0; i < N; i++){
      input = br.readLine();
      for (int j = 0; j < N; j++){
        d = (int) input.charAt(j);
        // input is upper case
        if (65 <= d && d <= 90){
          map[i][j] = d - 38;
        }
        // input is lower case
        else if (97 <= d && d <= 122){
          map[i][j] = d - 96;
        }
        // input is 0
        else{
          map[i][j] = 0;
        }
        // calculate sum
        sum += map[i][j];
      }
    }

    // process data
    for (int i = 0; i < N - 1; i++){
      for (int j = i + 1; j < N; j++){
        int a = map[i][j];
        int b = map[j][i];
        // a = b = 0 : pass
        // a or b = 0
        if (a == 0 || b == 0) {
          if (a == 0) map[i][j] = b;
        }  
        // a and b != 0
        else{
          if (b < a) map[i][j] = b;
        }
      }
    }

    // make edgeList
    for (int i = 0; i < N - 1; i++){
      for (int j = i + 1; j < N; j++){
        if (map[i][j] != 0) edgeList.add(new Edge(i, j, map[i][j]));
      }
    }
    Collections.sort(edgeList);

    // do KruskalMST
    for (int i = 0; i < edgeList.size(); i++){
      Edge e = edgeList.get(i);

      // check if cycle is created
      if (find(e.from) != find(e.to)){
        mstcount++;
        mstlen += e.weight;
        union(e.from, e.to);
      }
    }

    // print answer and end program
    if (mstcount != N-1) System.out.println(-1);
    else System.out.println(sum - mstlen);
    br.close();
    return;
  }

  // find function
  private static int find(int x){
    if (parent[x] == x) return x;
    return parent[x] = find(parent[x]);
  }

  // union function
  private static void union(int a, int b){
    a = find(a);
    b = find(b);
    if (a != b) parent[b] = a;
  }
}

// Edge class
class Edge implements Comparable<Edge>{
  int from;
  int to;
  int weight;
  // constructor
  public Edge(int from, int to, int weight){
    this.from = from;
    this.to = to;
    this.weight = weight;
  }

  @Override
  public int compareTo(Edge e){
    return weight - e.weight;
  }
}
