import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.ArrayList;
import java.util.Collections;

public class Main {
  // set needed variables
  static int M, N;
  static int number = 0;
  static int size;
  static int[][] map;
  static int[] dx = {0, 1, 0, -1};
  static int[] dy = {-1, 0, 1, 0};
  static ArrayList<Integer> list = new ArrayList<>();

  public static void main(String[] args) throws IOException{
    // set needed components
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine(), " ");
    M = Integer.parseInt(st.nextToken());
    N = Integer.parseInt(st.nextToken());
    int K = Integer.parseInt(st.nextToken());
    map = new int[M][N];
    int lx, ly, rx, ry;
    

    // get rectangular and process
    for (int i = 0; i < K; i++){
      st = new StringTokenizer(br.readLine(), " ");
      lx = Integer.parseInt(st.nextToken());
      ly = Integer.parseInt(st.nextToken());
      rx = Integer.parseInt(st.nextToken());
      ry = Integer.parseInt(st.nextToken());
      setRec(lx, ly, rx, ry);
    }

    // do dfs
    dodfs();

    // sort data
    Collections.sort(list);

    // print answer and end program
    System.out.println(number);
    for (Integer i: list) System.out.print(i+" ");
    br.close();
    return;
  }

  // dodfs function
  public static void dodfs(){
    for (int i = 0; i < M; i++){
      for (int j = 0; j < N; j++) {
        if (map[i][j] == 0) {
          number++;
          size = 0;
          dfs(i, j);
          list.add(size);
        }
      }
    }
  }

  // dfs function
  public static void dfs(int i, int j){
    // visit (i, j)
    size++;
    map[i][j] = 2;

    for (int k = 0; k < 4; k++){
      int ni = i + dx[k];
      int nj = j + dy[k];

      if (ni < 0 || nj < 0 || ni >= M || nj >= N) continue;
      if (map[ni][nj] == 0){
        dfs(ni, nj);
      }
    }
  }

  // set rectangular function
  public static void setRec(int lx, int ly, int rx, int ry){
    for (int j = lx; j < rx; j++){
      for (int i = M - ly - 1; i > M - ry - 1; i--) map[i][j] = 1;
    }
  }
}
