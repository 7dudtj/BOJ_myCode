import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {
  // set static variables
  static int N, M, k;
  static int list[], cost[];

	public static void main(String args[]) throws Exception	{
    // set needed variables
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine(), " ");
    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());
    k = Integer.parseInt(st.nextToken());
    list = new int[N+1];
    for (int i = 1; i <= N; i++) list[i] = i;
    cost = new int[N+1]; 
    int v, w, sum = 0;

    // get friend cost
    st = new StringTokenizer(br.readLine(), " ");
    for (int i = 1; i <= N; i++) cost[i] = Integer.parseInt(st.nextToken());

    // make friend list
    for (int i = 0; i < M; i++){
      st = new StringTokenizer(br.readLine(), " ");
      v = find(Integer.parseInt(st.nextToken()));
      w = find(Integer.parseInt(st.nextToken()));
      union(v, w);
    }

    // calculate friend cost
    for (int i = 1; i <= N; i++){
      if (list[i] == i) sum += cost[i];
    }

    // print answer and end program
    if (sum > k) System.out.print("Oh no");
    else System.out.print(sum);
    br.close();
    return;
  }

  // find function
  private static int find(int v){
    if (list[v] == v) return v;

    return list[v] = find(list[v]);
  }

  // union function
  private static void union(int a, int b){
    if (a < b){
      list[b] = a;
      if (cost[b] < cost[a]) cost[a] = cost[b];
    }else{
      list[a] = b;
      if (cost[a] < cost[b]) cost[b] = cost[a];
    }
  }
}