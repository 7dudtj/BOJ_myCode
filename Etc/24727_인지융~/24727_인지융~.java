import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.Queue;
import java.util.LinkedList;

public class Main {
  public static void main(String[] args) throws IOException{
    // set needed components
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());
    StringTokenizer st = new StringTokenizer(br.readLine(), " "); br.close();
    int C = Integer.parseInt(st.nextToken());
    int E = Integer.parseInt(st.nextToken());
    int B = N*N-C-E;
    boolean possible = true;
    int[] dx = {0,1,0,-1};
    int[] dy = {-1,0,1,0};
    int[][] map = new int[N][N];
    boolean[][] visited = new boolean[N][N];

    // exception handling
    if (N==1 || C > N*N-3 || E > N*N-3){
      System.out.print(-1);
      return;
    }

    // fill map
    for (int s = 0; s <= N-1; s++){
      for (int k = 0; k <= s; k++){
        int j = k;
        int i = s-k;
        if (C > 0){
          map[i][j] = 1;
          C--;
        }else if (B > 0){
          map[i][j] = 0;
          B--;
        }else{
          map[i][j] = 2;
          E--;
        }
      }
    }
    for (int s = N; s <= (N-1)*2; s++){
      int k = (N-1)*2-s;
      for (int m = 0; m <= k; m++){
        int i = N-1-m;
        int j = s-i;
        if (C > 0){
          map[i][j] = 1;
          C--;
        }else if (B > 0){
          map[i][j] = 0;
          B--;
        }else{
          map[i][j] = 2;
          E--;
        }
      }
    }

    // check possibility
    // set bfs
    Queue<Loc> q = new LinkedList<>();
    q.add(new Loc(0,0));
    visited[0][0] = true;

    // do bfs
    while (!q.isEmpty()){
      Loc tmp = q.poll();
      if (map[tmp.i][tmp.j] == 1){
        for (int k = 0; k < 4; k++){
          int ni = tmp.i+dx[k];
          int nj = tmp.j+dy[k];
          if (0<=ni&&ni<N && 0<=nj&&nj<N && !visited[ni][nj]){
            visited[ni][nj] = true;
            q.add(new Loc(ni, nj));
          }
        }
      }else if (map[tmp.i][tmp.j] == 2){
        possible = false;
        break;
      }
    }

    // print answer and end program
    if (possible){
      System.out.println(1);
      for (int i = 0; i < N; i++){
        for (int j = 0; j < N; j++){
          System.out.print(map[i][j]);
        } System.out.println();
      }
    }else System.out.print(-1);
    return;
  }
}

// Loc class
class Loc{
  int i;
  int j;
  public Loc(int i, int j){
    this.i = i;
    this.j = j;
  }
}