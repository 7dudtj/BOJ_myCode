import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {
  // set static variables
  static int n, m, count = 0, a, b;
  static int[] list;

	public static void main(String args[]) throws Exception	{
    // set needed variables
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine(), " ");
    n = Integer.parseInt(st.nextToken());
    m = Integer.parseInt(st.nextToken());
    list = new int[n];
    for (int i = 0; i < n; i++) list[i] = i;
    boolean find = false;

    // find answer
    for (int i = 0; i < m; i++){
      // get data
      st = new StringTokenizer(br.readLine(), " ");
      count++;
      a = Integer.parseInt(st.nextToken());
      b = Integer.parseInt(st.nextToken());

      // find cycle
      a = find(a);
      b = find(b);
      if (a == b){
        find = true;
        break;
      }
      // union nodes
      else{
        union(a, b);
      }
    }

    // print answer and end program
    if (find) System.out.print(count);
    else System.out.print(0);
    br.close();
    return;
  }

  // find function
  private static int find(int v){
    if (list[v] == v) return v;
    else return find(list[v]);
  }

  // union function
  private static void union(int a, int b){
    if (a < b) list[b] = a;
    else list[a] = b;
  }
}