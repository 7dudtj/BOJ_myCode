import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {
  // set static variables
  static int n, m, signal, a, b;
  static int[] list;

	public static void main(String args[]) throws Exception	{
    // set needed variables
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();
    StringTokenizer st = new StringTokenizer(br.readLine(), " ");
    n = Integer.parseInt(st.nextToken());
    m = Integer.parseInt(st.nextToken());
    list = new int[n+1];
    for (int i = 0; i <= n; i++) list[i] = i;

    // do main process
    for (int i = 0; i < m; i++){
      st = new StringTokenizer(br.readLine(), " ");
      signal = Integer.parseInt(st.nextToken());
      a = Integer.parseInt(st.nextToken());
      b = Integer.parseInt(st.nextToken());

      a = find(a);
      b = find(b);
      // union
      if (signal == 0){
        union(a, b);
      }
      // find
      else{
        if (a == b) sb.append("YES").append('\n');
        else sb.append("NO").append('\n');
      }
    }

    // print answer and end program
    System.out.print(sb);
    br.close();
    return;
  }

  // union function
  private static void union(int a, int b){
    // a == b
    if (a == b) return;

    // a != b
    if (a < b) list[b] = a;
    else list[a] = b;
  }

  // find function
  private static int find(int v){
    // find
    if (list[v] == v) return v;

    // not find
    // return find(list[v]); << 이렇게 하면 시간초과 났음
    return list[v] = find(list[v]);
  }
}
