import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {
  static int[] dx = {0,1,0,-1};
  static int[] dy = {-1,0,1,0};
  static int n, m;
  static boolean[][] visited;
  static int[][] map;
  static int size;
	public static void main(String args[]) throws IOException	{
    // set needed variables
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine(), " ");
    n = Integer.parseInt(st.nextToken());
    m = Integer.parseInt(st.nextToken());
    map = new int[n][m];
    visited = new boolean[n][m];
    int count = 0;
    size = 0;
    int maxSize = 0;

    // get map
    for (int i = 0; i < n; i++){
      st = new StringTokenizer(br.readLine(), " ");
      for (int j = 0; j < m; j++){
        map[i][j] = Integer.parseInt(st.nextToken());
      }
    }

    // do dfs
    for (int i = 0; i < n; i++){
      for (int j = 0; j < m; j++){
        if (!visited[i][j] && map[i][j] == 1) {
          count++;
          size = 0;
          dfs(i, j);
          if (maxSize < size) maxSize = size;
        }
      }
    }

    // print answer and end program
    System.out.println(count);
    System.out.println(maxSize);
    br.close();
    return;
  }

  // dfs function
  private static void dfs(int n, int m){
    visited[n][m] = true;
    size++;
    int nx, ny;
    for (int i = 0; i < 4; i++){
      nx = n+dx[i];
      ny = m+dy[i];
      if (inRange(nx, ny) && map[nx][ny] == 1 && !visited[nx][ny]){
        dfs(nx, ny);
      }
    }
  }

  // check in range function
  private static boolean inRange(int i, int j){
    return ((0 <= i && i < n) && (0 <= j && j < m));
  }
}