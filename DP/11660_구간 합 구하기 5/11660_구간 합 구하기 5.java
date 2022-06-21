import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {
  public static void main(String[] args) throws IOException{
    // set needed components
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine(), " ");
    StringBuilder sb = new StringBuilder();
    int N = Integer.parseInt(st.nextToken());
    int M = Integer.parseInt(st.nextToken());
    int[][] map = new int[N+1][N+1];

    // get and make map
    for (int i = 1; i <= N; i++){
      st = new StringTokenizer(br.readLine(), " ");
      for (int j = 1; j <= N; j++){
        map[i][j] = map[i][j-1] + Integer.parseInt(st.nextToken());
      }
    }

    // get query and save answer
    int x1, y1, x2, y2, answer;
    for (int i = 0; i < M; i++){
      // get query
      st = new StringTokenizer(br.readLine(), " ");
      x1 = Integer.parseInt(st.nextToken());
      y1 = Integer.parseInt(st.nextToken());
      x2 = Integer.parseInt(st.nextToken());
      y2 = Integer.parseInt(st.nextToken());

      // get answer
      answer = 0;
      for (int x = x1; x <= x2; x++){
        answer += (map[x][y2]-map[x][y1-1]);
      }
      sb.append(answer).append('\n');
    }

    // print answer and end program
    System.out.print(sb);
    br.close();
    return;
  }
}