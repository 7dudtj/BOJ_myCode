import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.ArrayList;

public class Main {
  // set needed variables
  static ArrayList<int[]> list;
  static char[][] map;

  public static void main(String[] args) throws IOException{
    // set needed components
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    map = new char[9][9];
    list = new ArrayList<int[]>();

    // get map
    for (int y = 0; y < 9; y++){
      map[y] = br.readLine().toCharArray();
      for (int x = 0; x < 9; x++){
        if (map[y][x] == '0') list.add(new int[] {y,x});
      }
    }
    br.close();

    // do sudoku using backtracking
    sudoku(0);
  }

  // sudoku function
  private static void sudoku(int idx){
    // find answer
    if (idx == list.size()){
      for (int y = 0; y < 9; y++){
        for (int x = 0; x < 9; x++){
          System.out.print(map[y][x]);
        }
        System.out.println();
      }
      System.exit(0);
    }

    // set needed variables
    int y = list.get(idx)[0];
    int x = list.get(idx)[1];
    int sy = (y/3)*3;
    int sx = (x/3)*3;
    boolean[] garo = new boolean[10];
    boolean[] sero = new boolean[10];
    boolean[] square = new boolean[10];

    // check garo, sero, and square
    for (int xx = 0; xx < 9; xx++) if (map[y][xx] != '0') garo[map[y][xx] - '0'] = true;
    for (int yy = 0; yy < 9; yy++) if (map[yy][x] != '0') sero[map[yy][x] - '0'] = true;
    for (int yy = sy; yy < sy+3; yy++){
      for (int xx = sx; xx < sx+3; xx++){
        if (map[yy][xx] != '0') square[map[yy][xx] - '0'] = true;
      }
    }

    // do backtracking
    for (int i = 1; i <= 9; i++){
      if (!garo[i] && !sero[i] && !square[i]){
        map[y][x] = (char) (i + '0');
        sudoku(idx + 1);
        map[y][x] = '0';
      }
    }
  }
}
