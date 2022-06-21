import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
  // set static variables
  static int N, M;
  static boolean[] visited;
  static int[] cnt;
  static ArrayList<Integer>[] map;

  public static void main(String[] args) throws IOException{
    // set needed components
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    StringTokenizer st = new StringTokenizer(br.readLine(), " ");
    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());
    map = new ArrayList[N];
    cnt = new int[N];
    for (int i = 0; i < N; i++) map[i] = new ArrayList<>();
    int A, B;

    // make map
    for (int i = 0; i < M; i++){
      st = new StringTokenizer(br.readLine(), " ");
      A = Integer.parseInt(st.nextToken()) - 1;
      B = Integer.parseInt(st.nextToken()) - 1;
      map[A].add(B);
    }

    // do bfs
    for (int i = 0; i < N; i++){
      visited = new boolean[N];
      bfs(i);
    }

    // get answer
    int max = 0;
    for (int i = 0; i < N; i++) max = Math.max(max, cnt[i]);
    StringBuffer sb = new StringBuffer();
    for (int i = 0; i < N; i++){
      if (cnt[i] == max) sb.append((i+1)+" ");
    }

    // print answer and end program
    System.out.print(sb.toString());
    br.close();
    bw.close();
    return;
  }

  // bfs function
  public static void bfs(int i){
    // set function variables
    Queue<Integer> q = new LinkedList<Integer>();
    q.add(i);
    visited[i] = true;

    // do bfs
    while (!q.isEmpty()){
      int node = q.poll();
      for (int v: map[node]){
        if (!visited[v]){
          visited[v] = true;
          cnt[v]++;
          q.add(v);
        }
      }
    }
  }
}