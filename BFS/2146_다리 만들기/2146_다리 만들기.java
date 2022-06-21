import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.Queue;
import java.util.LinkedList;

public class Main {
  static int N;
  static int[][] map;
  static boolean[][] visited;
  static int[] dx = {0, 1, 0, -1};
  static int[] dy = {-1, 0, 1, 0};
  static int minD = Integer.MAX_VALUE;
	public static void main(String args[]) throws IOException	{
    // set needed variables
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    N = Integer.parseInt(br.readLine());
    map = new int[N][N];
    visited = new boolean[N][N];
    StringTokenizer st;
    int islandNum = 0;

    // get map
    for (int i = 0; i < N; i++){
      st = new StringTokenizer(br.readLine());
      for (int j = 0; j < N; j++){
        map[i][j] = Integer.parseInt(st.nextToken());
      }
    }

    // check island
    for (int i = 0; i < N; i++){
      for (int j = 0; j < N; j++){
        if (map[i][j] == 1 && !visited[i][j]){
          islandNum++;
          bfs(i, j, islandNum);
        }
      }
    }

    // find minimum distance
    for (int i = 0; i < N; i++){
      for (int j = 0; j < N; j++){
        if (map[i][j] != 0){
          findSP(i, j, map[i][j]);
        }
      }
    }

    // print answer and end program
    System.out.println(minD);
    br.close();
    return;
  }

  // bfs function for checking island
  private static void bfs(int i, int j, int isNum){
    Queue<Loc> q = new LinkedList<>();
    q.add(new Loc(i, j));
    visited[i][j] = true;
    Loc l;

    while (!q.isEmpty()){
      l = q.poll();
      map[l.i][l.j] = isNum;

      for (int n = 0; n < 4; n++){
        if (0<=l.i+dx[n] && l.i+dx[n]<N && 0<=l.j+dy[n] && l.j+dy[n]<N){
          if (map[l.i+dx[n]][l.j+dy[n]] == 1 && !visited[l.i+dx[n]][l.j+dy[n]]){
            q.add(new Loc(l.i+dx[n], l.j+dy[n]));
            visited[l.i+dx[n]][l.j+dy[n]] = true;
          }
        }        
      }
    }
  }

  // find shortest path by bfs
  private static void findSP(int i, int j, int island){
    Queue<Dis> q = new LinkedList<>();
    q.add(new Dis(i, j, 0));
    Dis d;
    for (int a = 0; a < N; a++){
      for (int b = 0; b < N; b++){
        visited[a][b] = false;
      }
    }
    visited[i][j] = true;

    while (!q.isEmpty()){
      d = q.poll();
      if (map[d.i][d.j] != 0 && map[d.i][d.j] != island){
        if (d.distance-1 < minD) minD = d.distance-1;
        return;
      }

      for (int n = 0; n < 4; n++){
        int ni = d.i+dx[n];
        int nj = d.j+dy[n];
        if (0<=ni && ni<N && 0<=nj && nj<N){
          if (map[ni][nj] != island && !visited[ni][nj]){
            q.add(new Dis(ni, nj, d.distance + 1));
            visited[ni][nj] = true;
          }
        }  
      }
    }
  }
}

// Location class
class Loc {
  int i;
  int j;
  public Loc(int i, int j){
    this.i = i;
    this.j = j;
  }
}

// Distance class
class Dis {
  int i;
  int j;
  int distance;
  public Dis(int i, int j, int d){
    this.i = i;
    this.j = j;
    this.distance = d;
  }
}