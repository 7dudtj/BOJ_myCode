import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.Queue;
import java.util.LinkedList;

public class Main {
  // set needed static variables
  static Queue<Loc> q;
  static int len;
  static boolean[][] visited;

  public static void main(String[] args) throws IOException{
    // set needed variables
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;
    int T = Integer.parseInt(br.readLine());
    int fi, fj, ti, tj;
    int[] di = {-2, -1, 1, 2, 2, 1, -1, -2};
    int[] dj = {1, 2, 2, 1, -1, -2, -2, -1};

    // do T times
    for (int times = 0; times < T; times++){
      // get map
      len = Integer.parseInt(br.readLine());
      visited = new boolean[len][len];

      // get start point
      st = new StringTokenizer(br.readLine(), " ");
      fi = Integer.parseInt(st.nextToken());
      fj = Integer.parseInt(st.nextToken());

      // get destination
      st = new StringTokenizer(br.readLine(), " ");
      ti = Integer.parseInt(st.nextToken());
      tj = Integer.parseInt(st.nextToken());    

      // set queue and bfs
      q = new LinkedList<>();  
      q.add(new Loc(fi, fj, 0));
      visited[fi][fj] = true;
      Loc tmp;

      // do bfs
      while (!q.isEmpty()){
        tmp = q.poll();

        // reach destination
        if ((tmp.i == ti) && (tmp.j == tj)){
          System.out.println(tmp.count);
          break;
        }

        // add to queue
        for (int i = 0; i < 8; i++){
          int ni = tmp.i + di[i];
          int nj = tmp.j + dj[i];

          if (ni < 0 || ni >= len || nj < 0 || nj >= len || visited[ni][nj]) continue;
          visited[ni][nj] = true;
          q.add(new Loc(ni, nj, tmp.count + 1));
        }
      }
    }

    // end program
    br.close();
    return;
  }
}

// Loc class
class Loc{
  int i;
  int j;
  int count;
  public Loc(int i, int j, int count){
    this.i = i;
    this.j = j;
    this.count = count;
  }
}
