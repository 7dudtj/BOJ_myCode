import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {
  // set static variables
  static int N;
  static int[][] map;
  static int answereven = 0, answerodd = 0;

	public static void main(String args[]) throws Exception	{
    // set needed variables
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    N = Integer.parseInt(br.readLine());
    map = new int[N][N];
    StringTokenizer st;

    // get map
    for (int i = 0; i < N; i++){
      st = new StringTokenizer(br.readLine(), " ");
      for (int j = 0; j < N; j++){
        if (st.nextToken().equals("0")){
          map[i][j] = -1;
        }
      }
    }

    // do backtracking
    backeven(0, 0);    
    if (N > 1) backodd(1, 0);

    // print answer and end program
    System.out.println(answereven + answerodd);
    br.close();
    return;
  }

  // backtracking function (even)
  private static void backeven(int num, int count){
    // do backtracking
    for (int a = num; a < N*N; a++){
      int i = a/N;
      int j = a%N;
      if ((i + j) % 2 == 1) continue;

      // get answer
      if (i == N-1 && j == N-1){
        if (map[i][j] == 0) count++;
        answereven = Math.max(answereven, count);
        return;
      }

      // not possible
      if (map[i][j] != 0) continue;

      // possible
      checkmap(i, j);
      backeven(a + 1, count + 1);
      uncheckmap(i, j);
    }
  }

  // backtracking function (odd)
  private static void backodd(int num, int count){
    // do backtracking
    for (int a = num; a < N*N; a++){
      int i = a/N;
      int j = a%N;
      if ((i + j) % 2 == 0) continue;

      // get answer
      if (i == N-1 && j == N-2){
        if (map[i][j] == 0) count++;
        answerodd = Math.max(answerodd, count);
        return;
      }

      // not possible
      if (map[i][j] != 0) continue;

      // possible
      checkmap(i, j);
      backodd(a + 1, count + 1);
      uncheckmap(i, j);
    }
  }

  // check map function
  private static void checkmap(int iloc, int jloc){
    int i, j;
    for (i = iloc, j = jloc; i >= 0 && j >= 0; i--, j--) 
      if (map[i][j] != -1) map[i][j] += 1; // left-up
    for (i = iloc, j = jloc; i < N && j < N; i++, j++)
      if (map[i][j] != -1) map[i][j] += 1; // right-down
    for (i = iloc, j = jloc; i >= 0 && j < N; i--, j++)
      if (map[i][j] != -1) map[i][j] += 1; // right-up
    for (i = iloc, j = jloc; i < N && j >= 0; i++, j--)
      if (map[i][j] != -1) map[i][j] += 1; // left-down
  }

  // uncheck map function
  private static void uncheckmap(int iloc, int jloc){
    int i, j;
    for (i = iloc, j = jloc; i >= 0 && j >= 0; i--, j--)
      if (map[i][j] != -1) map[i][j] -= 1; // left-up
    for (i = iloc, j = jloc; i < N && j < N; i++, j++)
      if (map[i][j] != -1) map[i][j] -= 1; // right-down
    for (i = iloc, j = jloc; i >= 0 && j < N; i--, j++)
      if (map[i][j] != -1) map[i][j] -= 1; // right-up
    for (i = iloc, j = jloc; i < N && j >= 0; i++, j--)
      if (map[i][j] != -1) map[i][j] -= 1; // left-down
  }
}