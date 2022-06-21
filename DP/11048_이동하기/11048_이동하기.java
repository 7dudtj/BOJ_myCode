import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {
  public static void main(String[] args) throws IOException{
    // set needed components
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine(), " ");
    int N = Integer.parseInt(st.nextToken());
    int M = Integer.parseInt(st.nextToken());
    int[][] map = new int[N+1][M+1];

    // get map
    for (int i = 1; i <= N; i++){
      st = new StringTokenizer(br.readLine(), " ");
      for (int j = 1; j <= M; j++){
        map[i][j] = Integer.parseInt(st.nextToken());
      }
    }

    // do dp
    for (int i = 1; i <= N; i++){
      for (int j = 1; j <= M; j++){
        map[i][j] += Math.max(map[i-1][j-1], Math.max(map[i-1][j], map[i][j-1]));
      }
    }

    // print answer and end program
    System.out.print(map[N][M]);
    br.close();
    return;
  }
}