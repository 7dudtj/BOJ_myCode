import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.Queue;
import java.util.LinkedList;

public class Main {
  // set static variables
  static int[][] before;
  static int[][] after;
  static int M, N;
  static boolean[][] visited;
  static int[] dx = {0,1,0,-1};
  static int[] dy = {-1,0,1,0};

	public static void main(String args[]) throws Exception	{
    // set needed variables
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine(), " ");
    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());
    before = new int[N][M];
    after = new int[N][M];
    visited = new boolean[N][M];
    int iloc = -1;
    int jloc = -1;
    boolean find = false;

    // get before map
    for (int i = 0; i < N; i++){
      st = new StringTokenizer(br.readLine(), " ");
      for (int j = 0; j < M; j++){
        before[i][j] = Integer.parseInt(st.nextToken());
      }
    }

    // get after map
    for (int i = 0; i < N; i++){
      st = new StringTokenizer(br.readLine(), " ");
      for (int j = 0; j < M; j++){
        after[i][j] = Integer.parseInt(st.nextToken());
      }
    }

    // find diff point
    for (int i = 0; i < N; i++){
      for (int j = 0; j < M; j++){
        if (before[i][j] != after[i][j]){
          iloc = i;
          jloc = j;
          find = true;
          break;
        }
      }
      if (find) break;
    }

    // not find diff point
    if (!find){
      System.out.print("YES");
      br.close();
      return;
    }

    // do dfs
    Queue<Node> q = new LinkedList<>();
    q.add(new Node(iloc, jloc));
    int color = after[iloc][jloc];

    while (!q.isEmpty()){
      Node tmp = q.poll();
      int i = tmp.i;
      int j = tmp.j;

      visited[i][j] = true;

      for (int k = 0; k < 4; k++){
        int ni = i + dx[k];
        int nj = j + dy[k];
        if (ni<0 || nj<0 || ni>=N || nj>=M) continue;
        if (visited[ni][nj]) continue;
        if (before[i][j] == before[ni][nj]){
          q.add(new Node(ni, nj));
        }
      }
      before[i][j] = color;
    }

    // find answer, print answer, and end program
    for (int i = 0; i < N; i++){
      for (int j = 0; j < M; j++){
        if (before[i][j] != after[i][j]){
          System.out.print("NO");
          br.close();
          return;
        }
      }
    }
    System.out.print("YES");
    br.close();
    return;
  }
}

// Node class
class Node{
  int i;
  int j;
  public Node(int i, int j){
    this.i = i;
    this.j = j;
  }
}