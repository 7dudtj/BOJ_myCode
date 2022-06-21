import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.Queue;
import java.util.LinkedList;

public class Main {
  // set static variables
  static int n, m;
  static int[][] map;
  static StringBuilder sb = new StringBuilder();
  static int[] id;
  static int[] od;
  static int[] ol;
  static int[][] cl;

  public static void main(String[] args) throws IOException{
    // set needed variables
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;
    int T = Integer.parseInt(br.readLine());

    // do T times
    for (int times = 0; times < T; times++){
      // get data
      n = Integer.parseInt(br.readLine());
      map = new int[n][n];
      id = new int[n];
      od = new int[n];
      ol = new int[n];
      st = new StringTokenizer(br.readLine(), " ");
      for (int i = 0; i < n; i++) 
        ol[i] = Integer.parseInt(st.nextToken()) - 1;
      m = Integer.parseInt(br.readLine());
      cl = new int[m][2];
      for (int i = 0; i < m; i++){
        st = new StringTokenizer(br.readLine(), " ");
        cl[i][0] = Integer.parseInt(st.nextToken()) - 1;
        cl[i][1] = Integer.parseInt(st.nextToken()) - 1;
      }

      // make map
      for (int i = 0; i < n-1; i++){
        for (int j = i+1; j < n; j++){
          map[ol[i]][ol[j]] = 1;
          od[ol[i]]++;
          id[ol[j]]++;
        }
      }

      // change map
      for (int i = 0; i < m; i++){
        // ai >> bi
        if (map[cl[i][0]][cl[i][1]] == 1){
          map[cl[i][0]][cl[i][1]] = 0;
          map[cl[i][1]][cl[i][0]] = 1;
          id[cl[i][0]]++;
          od[cl[i][0]]--;
          id[cl[i][1]]--;
          od[cl[i][1]]++;
        }
        // ai << bi
        else{
          map[cl[i][0]][cl[i][1]] = 1;
          map[cl[i][1]][cl[i][0]] = 0;
          id[cl[i][0]]--;
          od[cl[i][0]]++;
          id[cl[i][1]]++;
          od[cl[i][1]]--;
        }
      }

      // do topological sort
      ts();
    }

    // print answer and end program
    System.out.print(sb);
    br.close();
    return;
  }

  // topological sort function
  public static void ts(){
    // set function variables
    Queue<Integer> q = new LinkedList<>();
    boolean imp = true;
    int[] nl = new int[n];
    int count = 0;

    // check IMPOSSIBLE - 모든 indegree가 0 초과
    for (int i = 0; i < n; i++){
      if (id[i] == 0) {
        imp = false;
        q.add(i);
      }  
    }
    if (imp) {
      sb.append("IMPOSSIBLE").append('\n');
      return;
    }

    // topological sort
    while (!q.isEmpty()){
      int node = q.poll();
      nl[count] = node;
      count++;
      od[node] = 0;

      for (int i = 0; i < n; i++){
        if (map[node][i] == 1){
          map[node][i] = 0;
          id[i]--;
          if (id[i] == 0) q.add(i);
        }
      }
    }

    // check IMPOSSIBLE - 모든 indegree가 0 초과
    if (count < n) sb.append("IMPOSSIBLE").append('\n');
    // print answer
    else{
      for (int i = 0; i < n; i++) sb.append(nl[i]+1).append(" ");
      sb.append('\n');
    }
  }
}