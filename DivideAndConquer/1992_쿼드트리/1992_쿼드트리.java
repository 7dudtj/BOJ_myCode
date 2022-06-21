import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
  // set static variables
  static StringBuilder sb = new StringBuilder();
	public static void main(String args[]) throws IOException	{
    // set needed variables
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());
    char[][] map = new char[N][N];

    // get map
    for (int i = 0; i < N; i++){
      String s = br.readLine();
      for (int j = 0; j < N; j++){
        map[i][j] = s.charAt(j);
      }
    }

    // do main process
    dac(map, N);

    // print answer and end program
    System.out.print(sb);
    br.close();
    return;
  }

  // divide and conquer
  private static void dac(char[][] map, int n){
    char[][] newmap = new char[n/2][n/2];

    // if n == 1
    if (n == 1){
      if (map[0][0] == '0') sb.append("0");
      else sb.append("1");
      return;
    }

    // do search
    int a = search(map, n);
    if (a == 0) sb.append("0");
    else if (a == 1) sb.append("1");
    else{
      sb.append("(");

      // 1st
      for (int i = 0; i < n/2; i++){
        for (int j = 0; j < n/2; j++){
          newmap[i][j] = map[i][j];
        }
      }
      dac(newmap, n/2);

      // 2nd
      for (int i = 0; i < n/2; i++){
        for (int j = n/2; j < n; j++){
          newmap[i][j-n/2] = map[i][j];
        }
      }
      dac(newmap, n/2);

      // 3rd
      for (int i = n/2; i < n; i++){
        for (int j = 0; j < n/2; j++){
          newmap[i-n/2][j] = map[i][j];
        }
      }
      dac(newmap, n/2);

      // 4th
      for (int i = n/2; i < n; i++){
        for (int j = n/2; j < n; j++){
          newmap[i-n/2][j-n/2] = map[i][j];
        }
      }
      dac(newmap, n/2);

      sb.append(")");
    }
  }

  // search function
  // -1: diff, 0: 0, 1: 1
  private static int search(char[][] map, int n){
    int zero = 0;
    int one = 0;
    int total = n*n;

    for (int i = 0; i < n; i++){
      for (int j = 0; j < n; j++){
        if (map[i][j] == '0') zero++;
        else one++;
      }
    }

    if (one == total) return 1;
    else if (zero == total) return 0;
    else return -1;
  }
}