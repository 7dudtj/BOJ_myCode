import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {
  // set needed variables
  private static int r, c, max = Integer.MIN_VALUE;
  private static int[][] map;
  private static boolean[] visited = new boolean[26];
  private static int[] dx = {0,1,0,-1};
  private static int[] dy = {-1,0,1,0};

  public static void main(String[] args) throws IOException{
    // set needed components
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine(), " ");
    r = Integer.parseInt(st.nextToken());
    c = Integer.parseInt(st.nextToken());
    map = new int[r][c];
    String s;

    // get map
    for (int i = 0; i < r; i++){
      s = br.readLine();
      for (int j = 0; j < c; j++){
        map[i][j] = s.charAt(j) - 'A';
      }
    }
    visited[map[0][0]] = true;

    // do dfs
    dfs(0,0,1);

    // print answer and end program
    System.out.println(max);
    br.close();
    return;
  }

  // dfs function
  private static void dfs(int x, int y, int count){
    if (max < count) max = count;
    int nx, ny;

    for (int i = 0; i < 4; i++){
      nx = x + dx[i];
      ny = y + dy[i];
      if (inRange(nx, ny)){
        int num = map[nx][ny];
        if (!visited[num]){
          visited[num] = true;
          dfs(nx, ny, count + 1);
          visited[num] = false;
        }
      }
    }
  }

  // check in-range function
  private static boolean inRange(int i, int j){
    if (i < 0 || i >= r || j < 0 || j >= c) return false;
    return true;
  }
}
