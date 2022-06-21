import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
  // set static variables
  static char[][] map;
	public static void main(String args[]) throws IOException	{
    // set needed variables
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();
    int N = Integer.parseInt(br.readLine());
    map = new char[N][N];

    // set default map
    for (int i = 0; i < N; i++){
      for (int j = 0; j < N; j++){
        map[i][j] = ' ';
      }
    }

    // fill map
    fill(N, 0, 0);

    // get answer
    for (int i = 0; i < N; i++){
      for (int j = 0; j < N; j++){
        sb.append(map[i][j]);
      } sb.append('\n');
    }

    // print answer and end program
    System.out.print(sb);
    br.close();
    return;
  }

  // fill map function
  private static void fill(int N, int i, int j){
    // N == 3
    if (N == 3){
      f3(i, j);
    }else{
      int a = 0;
      for (int b = 0; b < 3; b++){
        fill(N/3, i + (N/3)*b, j + (N/3)*a);
      }
      a = 1;
      for (int b = 0; b < 3; b += 2){
        fill(N/3, i + (N/3)*b, j + (N/3)*a);
      }
      a = 2;
      for (int b = 0; b < 3; b++){
        fill(N/3, i + (N/3)*b, j + (N/3)*a);
      }
    }
  }

  // function of N = 3
  private static void f3(int i, int j){
    for (int k = 0; k < 3; k++) map[i][j+k] = '*';
    map[i+1][j] = '*';
    map[i+1][j+1] = ' ';
    map[i+1][j+2] = '*';
    for (int k = 0; k < 3; k++) map[i+2][j+k] = '*';
  }
}