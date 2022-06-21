import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
  // set needed variables
  static int N;
  static int answer = 0;
  static int[][] map;

  public static void main(String[] args) throws IOException{
    // set needed components
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    N = Integer.parseInt(br.readLine());
    map = new int[N][N];
    
    // do backtracking
    bt(0);

    // print answer and and program
    System.out.print(answer);
    br.close();
    return;
  }

  // backtracking function
  private static void bt(int i){
    // check if backtracking is finish
    if (i == N-1){
      for (int j = 0; j < N; j++){
        if (map[i][j] == 0) answer++;
      }
      return;
    }

    // do backtracking
    for (int j = 0; j < N; j++){
      if (map[i][j] >= 1) continue;
      checkmap(i, j);

      // do backtracking at next depth
      bt(i + 1);

      // reset and prepare for next backtracking
      uncheckmap(i, j);
    }
  }

  // map checking function
  private static void checkmap(int iloc, int jloc){
    int i, j;
    for (i = 0; i < N; i++) map[i][jloc] += 1; // vertical
    for (j = 0; j < N; j++) map[iloc][j] += 1; // horizontal
    for (i = iloc, j = jloc; i >= 0 && j >= 0; i--, j--) map[i][j] += 1; // left-up
    for (i = iloc, j = jloc; i < N && j < N; i++, j++) map[i][j] += 1; // right-down
    for (i = iloc, j = jloc; i >= 0 && j < N; i--, j++) map[i][j] += 1; // right-up
    for (i = iloc, j = jloc; i < N && j >= 0; i++, j--) map[i][j] += 1; // left-down
  }
  
  // map unchecking function
  private static void uncheckmap(int iloc, int jloc){
    int i, j;
    for (i = 0; i < N; i++) map[i][jloc] -= 1; // vertical
    for (j = 0; j < N; j++) map[iloc][j] -= 1; // horizontal
    for (i = iloc, j = jloc; i >= 0 && j >= 0; i--, j--) map[i][j] -= 1; // left-up
    for (i = iloc, j = jloc; i < N && j < N; i++, j++) map[i][j] -= 1; // right-down
    for (i = iloc, j = jloc; i >= 0 && j < N; i--, j++) map[i][j] -= 1; // right-up
    for (i = iloc, j = jloc; i < N && j >= 0; i++, j--) map[i][j] -= 1; // left-down
  }
}
