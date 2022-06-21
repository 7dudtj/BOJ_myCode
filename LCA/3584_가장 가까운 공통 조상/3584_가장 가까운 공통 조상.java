import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {
  // set static variables
  static int depth[], parent[];

	public static void main(String args[]) throws Exception	{
    // set needed variables
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();
    StringTokenizer st;
    int T = Integer.parseInt(br.readLine());
    int N, p, c, one, two;

    // do main process
    for (int times = 0; times < T; times++){
      // get N
      N = Integer.parseInt(br.readLine());

      // make tree
      parent = new int[N+1];
      for (int i = 1; i <= N; i++) parent[i] = i;
      depth = new int[N+1];
      for (int i = 1; i <= N; i++) depth[i] = 1;
      for (int i = 0; i < N-1; i++){
        st = new StringTokenizer(br.readLine(), " ");
        p = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        parent[c] = p;
      }

      // find depth
      for (int i = 1; i <= N; i++){
        int tmp = i;
        while (parent[tmp] != tmp){
          tmp = parent[tmp];
          depth[i]++;
        }
      }

      // get two nodes
      st = new StringTokenizer(br.readLine());
      one = Integer.parseInt(st.nextToken());
      two = Integer.parseInt(st.nextToken());

      // set same depth
      if (depth[one] > depth[two]){
        one = setdepth(one, depth[two]);
      } else if (depth[one] < depth[two]){
        two = setdepth(two, depth[one]);
      }

      // find common parent
      while (one != two){
        one = parent[one];
        two = parent[two];
      }

      // log answer
      sb.append(one).append('\n');
    }

    // print answer and end program
    System.out.print(sb);
    br.close();
    return;
  }

  // set depth function
  private static int setdepth(int v, int d){
    while (depth[v] != d){
      v = parent[v];
    }
    return v;
  }
}