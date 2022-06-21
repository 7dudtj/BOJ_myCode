import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
public class Main {

  // set needed variables
  static int N;
  static int[][] map;
  static boolean[] visited;
  static int min = Integer.MAX_VALUE;

  public static void main(String[] args) throws IOException{
    // set needed components
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    N = Integer.parseInt(br.readLine());
    map = new int[N][N];
    visited = new boolean[N];
    StringTokenizer st;

    // get map
    for (int i = 0; i < N; i++){
      st = new StringTokenizer(br.readLine(), " ");
      for (int j = 0; j < N; j++){
        map[i][j] = Integer.parseInt(st.nextToken());
      }
    }

    // do backtracking
    comb(0, 0);

    // print answer and end program
    System.out.print(min);
    br.close();
    return;
  }

  // comb function
  private static void comb(int idx, int count){
    // get all member
    if (count == N/2){
      calc();
      return;
    }

    // get member
    for (int i = idx; i < N; i++){
      if (!visited[i]){
        visited[i] = true;
        comb(i + 1, count + 1);
        visited[i] = false;
      }
    }
  }

  // calculate function
  private static void calc(){
    int start = 0;
    int link = 0;

    // do calculation
    for (int i = 0; i < N-1; i++){
      for (int j = i + 1; j < N; j++){
        // team start
        if (visited[i] && visited[j]){
          start += (map[i][j] + map[j][i]);
        }
        // team link
        else if (!visited[i] && !visited[j]){
          link += (map[i][j] + map[j][i]);
        }
      }
    }

    int diff = Math.abs(start - link);

    // if diff == 0
    if (diff == 0){
      System.out.print(0);
      System.exit(0);
    }

    // renew min value
    min = Math.min(diff, min);
  }
}