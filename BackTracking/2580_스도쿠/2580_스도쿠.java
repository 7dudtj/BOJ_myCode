import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {
  // set needed variables
  static int[][] map = new int[9][9];
  static StringBuilder sb = new StringBuilder();

  public static void main(String[] args) throws IOException{
    // set needed components
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;

    // get map
    for (int i = 0; i < 9; i++){
      st = new StringTokenizer(br.readLine(), " ");
      for (int j = 0; j < 9; j++)
        map[i][j] = Integer.parseInt(st.nextToken());
    }

    // do sudoku
    sudoku(0,0);
  }

  // sudoku function using backtracking
  private static void sudoku(int row, int col){
    // end of col
    if (col == 9){
      sudoku(row+1, 0);
      return;
    }

    // end of row: finish << 여기서 출력하고 프로그램 끝내야함
    if (row == 9) {
      // make answer
      for (int i = 0; i < 9; i++){
        for (int j = 0; j < 9; j++)
          sb.append(map[i][j]).append(" ");
        sb.append('\n');
      }

      // print answer and exit program
      System.out.print(sb);
      System.exit(0);
    }

    // main process
    if (map[row][col] == 0){
      for (int i = 1; i <= 9; i++){
        if (possible(row, col, i)){
          map[row][col] = i;
          sudoku(row, col+1);
        }
      }
      map[row][col] = 0;
      return;
    }

    sudoku(row, col + 1);
  }

  // checking possibility function
  private static boolean possible(int row, int col, int value){
    // check horizontal line
    for (int j = 0; j < 9; j++)
      if (map[row][j] == value) return false;

    // check vertical line
    for (int i = 0; i < 9; i++)
      if (map[i][col] == value) return false;

    // check 3x3 square
    int start_row = (row / 3) * 3;
    int start_col = (col / 3) * 3;
    for (int i = start_row; i < start_row + 3; i++){
      for (int j = start_col; j < start_col + 3; j++)
        if (map[i][j] == value) return false;
    }

    // value is possible answer
    return true;
  }
}
