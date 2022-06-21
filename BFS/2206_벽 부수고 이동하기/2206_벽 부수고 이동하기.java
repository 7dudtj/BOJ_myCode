import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
  // set needed variables
  static int N, M, answer;
  static int[][] map, visited;
  static int[] dx = {0, 1, 0, -1};
  static int[] dy = {-1, 0, 1, 0};

  public static void main(String[] args) throws IOException{
    // set needed components
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine(), " ");
    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());
    map = new int[N][M];
    visited = new int[N][M];
    String s;

    // get map
    for (int i = 0; i < N; i++){
      s = br.readLine();
      for (int j = 0; j < M; j++){
        map[i][j] = Integer.parseInt(s.substring(j,j+1));
        visited[i][j] = Integer.MAX_VALUE;
      }
    }
    answer = Integer.MAX_VALUE;

    // do bfs
    bfs(0, 0);

    // print answer and end program
    if (answer == Integer.MAX_VALUE) System.out.println(-1);
    else System.out.println(answer);
    br.close();
    return;
  }

  // bfs function
  public static void bfs(int y, int x){
    Queue<Location> q = new LinkedList<>();
    q.add(new Location(y, x, 1, 0));
    visited[y][x] = 0;

    while (!q.isEmpty()){
      Location loc = q.poll();

      // end when finish
      if (loc.y == N-1 && loc.x == M-1){
        answer = loc.distance;
        break;
      }

      // do process
      for (int i = 0; i < 4; i++){
        int ny = loc.y + dy[i];
        int nx = loc.x + dx[i];

        if (ny < 0 || ny >= N || nx < 0 || nx >= M) continue;
        if (visited[ny][nx] <= loc.drill) continue;

        // not wall
        if (map[ny][nx] == 0){
          visited[ny][nx] = loc.drill;
          q.add(new Location(ny, nx, loc.distance + 1, loc.drill));
        }
        // wall
        else{
          if (loc.drill == 0){
            visited[ny][nx] = loc.drill + 1;
            q.add(new Location(ny, nx, loc.distance + 1, loc.drill + 1));
          }
        }
      }
    }
  }
}

// Location class
class Location{
  int y;
  int x;
  int distance;
  int drill;
  public Location(int y, int x, int dis, int drill){
    this.y = y;
    this.x = x;
    this.distance = dis;
    this.drill = drill;
  }
}
