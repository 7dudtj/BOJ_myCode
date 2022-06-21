import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.List;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
  // set static variables
  static int n, m, max = 0, cnt = 0;
  static int[] od, d;
  static boolean[] visited;
  static List<Road>[] list;
  static List<Road>[] relist;
  static class Road{
    int start, time;

    public Road(int s, int t){
      start = s;
      time = t;
    }
  }

  public static void main(String[] args) throws IOException{
    // set needed variables
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;
    n = Integer.parseInt(br.readLine());
    m = Integer.parseInt(br.readLine());

    // set data
    od = new int[n];
    d = new int[n];
    visited = new boolean[n];
    list = new List[n];
    relist = new List[n];
    for (int i = 0; i < n; i++){
      list[i] = new LinkedList<>();
      relist[i] = new LinkedList<>();
    }

    // get Roads
    for (int i = 0; i < m; i++){
      st = new StringTokenizer(br.readLine(), " ");
      int s = Integer.parseInt(st.nextToken()) - 1;
      int e = Integer.parseInt(st.nextToken()) - 1;
      int t = Integer.parseInt(st.nextToken());

      list[e].add(new Road(s, t));
      relist[s].add(new Road(e, t));
      od[s]++;
    }

    // get start, and end
    st = new StringTokenizer(br.readLine(), " ");
    int start = Integer.parseInt(st.nextToken()) - 1;
    int end = Integer.parseInt(st.nextToken()) - 1;

    // find max and cnt
    max = solve(start, end);

    // print answer and end program
    System.out.println(max+"\n"+cnt);
    br.close();
    return;
  }

  // solve function
  public static int solve(int start, int end){
    Queue<Integer> q = new LinkedList<>();
    q.add(end);

    while (!q.isEmpty()){
      int cur = q.poll();

      for (Road r: list[cur]){
        int s = r.start;
        int t = r.time;

        od[s]--;
        if (od[s] == 0) q.add(s);

        if (d[s] < d[cur] + t) d[s] = d[cur] + t;
      }
    }

    dfs(start);

    return d[start];
  }

  // dfs function
  public static void dfs(int start){
    if (visited[start]) return;
    visited[start] = true;

    for (Road r: relist[start]){
      int s = r.start;
      int t = r.time;

      if (d[start] == d[s] + t){
        cnt++;
        dfs(s);
      }
    }
  }
}