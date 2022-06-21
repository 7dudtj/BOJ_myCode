import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {
  // set static variables
  static int N, M;
  static int[] list;

	public static void main(String args[]) throws Exception	{
    // set needed variables
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    N = Integer.parseInt(br.readLine());
    M = Integer.parseInt(br.readLine());
    list = new int[N];
    for (int i = 0; i < N; i++) list[i] = i;
    StringTokenizer st;
    boolean possible = true;
    int val;

    // make map
    for (int i = 0; i < N; i++){
      st = new StringTokenizer(br.readLine(), " ");
      for (int j = 0; j < N; j++){
        val = Integer.parseInt(st.nextToken());
        if (j > i){
          if (val == 1) {
            union(find(i), find(j));
          }
        }
      }
    }

    // check possible
    if (M >= 1){
      st = new StringTokenizer(br.readLine(), " ");
      val = find(Integer.parseInt(st.nextToken()) - 1);
      for (int i = 1; i < M; i++){
        if (val != find(Integer.parseInt(st.nextToken()) - 1)){
          possible = false;
        }
      }
    }    

    // print answer and end program
    if (possible) System.out.print("YES");
    else System.out.print("NO");
    br.close();
    return;
  }

  // union function
  private static void union(int a, int b){
    if (a < b) list[b] = a;
    else list[a] = b;
  }

  // find function
  private static int find(int v){
    if (list[v] == v) return v;

    return list[v] = find(list[v]);
  }
}