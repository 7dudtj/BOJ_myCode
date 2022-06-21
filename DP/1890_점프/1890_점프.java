import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {
  public static void main(String[] args) throws IOException{
    // set needed components
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());
    int[][] map = new int[N][N];
    boolean[][] wait = new boolean[N][N];
    long[][] way = new long[N][N];
    StringTokenizer st;

    // get map
    for (int i = 0; i < N; i++){
      st = new StringTokenizer(br.readLine(), " ");
      for (int j = 0; j < N; j++){
        map[i][j] = Integer.parseInt(st.nextToken());
      }
    }

    // do dp
    wait[0][0] = true;
    way[0][0] = 1;
    for (int i = 0; i < N; i++){
      for (int j = 0; j < N; j++){
        // do process at (i, j)
        if (wait[i][j]){
          // no dp
          if (map[i][j] == 0) continue;
          // move right
          if (j + map[i][j] < N){
            way[i][j+map[i][j]] += way[i][j];
            wait[i][j+map[i][j]] = true;
          }
          // move down
          if (i + map[i][j] < N){
            way[i+map[i][j]][j] += way[i][j];
            wait[i+map[i][j]][j] = true;
          }
        }
      }
    }

    // print answer and end program
    System.out.println(way[N-1][N-1]);
    br.close();
    return;
  }
}