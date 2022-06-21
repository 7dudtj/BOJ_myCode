import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.IOException;

public class Main {
  // set needed variables
  static char[][] map;

  public static void main(String[] args) throws IOException{
    // set needed components
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    int N = Integer.parseInt(br.readLine());
    map = new char[N][2*N-1];
    for (int i = 0; i < N; i++){
      for (int j = 0; j < 2*N-1; j++){
        map[i][j] = ' ';
      }
    }

    // pointing start
    ps(0, N-1, N);

    // print answer and end program
    for (int i = 0; i < N; i++){
      for (int j = 0; j < 2*N-1; j++){
        bw.write(map[i][j]);
      } bw.newLine();
    }
    bw.flush();
    br.close();
    bw.close();
    return;
  }

  // pointing start function
  private static void ps(int x, int y, int n){
    if (n == 3){
      map[x][y] = '*';
      map[x+1][y-1] = map[x+1][y+1] = '*';
      map[x+2][y-2] = map[x+2][y-1] = map[x+2][y] = map[x+2][y+1] = map[x+2][y+2] = '*';
      return;
    }

    ps(x, y, n/2);
    ps(x + n/2, y - n/2, n/2);
    ps(x + n/2, y + n/2, n/2);
  }
}