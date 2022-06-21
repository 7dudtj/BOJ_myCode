import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.Arrays;

public class Main {
  // set static variables
  static int N, M;
  static int[][] map;
  static boolean[][] wall;
  static boolean[][] visited;
  static int[] dx = {0, 1, 0, -1};
  static int[] dy = {-1, 0, 1, 0};
  static int[] group;
  static StringBuilder sb = new StringBuilder();

  public static void main(String[] args) throws IOException{
    // set needed components
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine(), " ");
    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());
    map = new int[N][M];
    wall = new boolean[N][M];
    visited = new boolean[N][M];

    // get wall
    for (int i = 0; i < N; i++){
      String s = br.readLine();
      for (int j = 0; j < M; j++){
        if (s.substring(j,j+1).equals("1")){
          wall[i][j] = true;
        }
      }
    }

    // find "0" group
    int groupIdx = 1;
    for (int i = 0; i < N; i++){
      for (int j = 0; j < M; j++){
        if (!wall[i][j] && !visited[i][j]){
          dfs(i, j, groupIdx);
          groupIdx++;
        }
      }  
    }

    // get group data
    group = new int[groupIdx];
    for (int i = 0; i < N; i++){
      for (int j = 0; j < M; j++){
        group[map[i][j]]++;
      }
    }

    // get answer
    for (int i = 0; i < N; i++){
      for (int j = 0; j < M; j++){
        if (!wall[i][j]) {
          sb.append("0");
        }
        else{
          int ans = count(i, j);
          sb.append((ans+1)%10);
        }
      } sb.append('\n');
    }

    // print answer and end program
    System.out.print(sb);
    br.close();
    return;
  }

  // dfs function
  private static void dfs(int i, int j, int groupIdx){
    map[i][j] = groupIdx;
    visited[i][j] = true;

    for (int k = 0; k < 4; k++){
      int ni = i + dx[k];
      int nj = j + dy[k];

      if (ni < 0 || nj < 0 || ni >= N || nj >= M) continue;
      if (!wall[ni][nj] && !visited[ni][nj]){
        dfs(ni, nj, groupIdx);
      }
    }
  }

  // count function
  private static int count(int i, int j){
    int[] list = new int[4];
    int result = 0;

    for (int k = 0; k < 4; k++){
      int ni = i + dx[k];
      int nj = j + dy[k];

      if (ni < 0 || nj < 0 || ni >= N || nj >= M) continue;
      list[k] = map[ni][nj];
    }

    Arrays.sort(list);

    int prev = 0;
    for (int k = 0; k < 4; k++){
      if (prev == list[k]) continue;
      if (list[k] != 0){
        result += group[list[k]];
        prev = list[k];
      }
    }

    return result;
  }
}