import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {
  // set static variables
  static int white = 0;
  static int blue = 0;
	public static void main(String args[]) throws IOException	{
    // set needed variables
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;
    int N = Integer.parseInt(br.readLine());
    char[][] map = new char[N][N];

    // get map
    for (int i = 0; i < N; i++){
      st = new StringTokenizer(br.readLine(), " ");
      for (int j = 0; j < N; j++){
        map[i][j] = st.nextToken().charAt(0);
      }
    }

    // do main process
    dac(map, N);

    // print answer and end program
    System.out.println(white);
    System.out.println(blue);
    br.close();
    return;
  }

  // divide and conquer function
  private static void dac(char[][] map, int N){
    char[][] newmap = new char[N/2][N/2];
    int a;

    // exception
    if (N == 1){
      if(map[0][0] == '1') blue++;
      else white++;
      return;
    }

    // search itself
    a = search(map, N);
    if (a == 0) {
      white++;
      return;
    }
    else if (a == 1) {
      blue++;
      return;
    }

    // 1st
    for (int i = 0; i < N/2; i++){
      for (int j = 0; j < N/2; j++){
        newmap[i][j] = map[i][j];
      }
    }
    a = search(newmap,N/2);
    if (a == 0) white++;
    else if (a == 1) blue++;
    else{
      dac(newmap, N/2);
    }

    // 2nd
    for (int i = 0; i < N/2; i++){
      for (int j = N/2; j < N; j++){
        newmap[i][j-N/2] = map[i][j]; 
      }
    }
    a = search(newmap,N/2);
    if (a == 0) white++;
    else if (a == 1) blue++;
    else{
      dac(newmap, N/2);
    }

    // 3rd
    for (int i = N/2; i < N; i++){
      for (int j = 0; j < N/2; j++){
        newmap[i-N/2][j] = map[i][j];
      }
    }
    a = search(newmap,N/2);
    if (a == 0) white++;
    else if (a == 1) blue++;
    else{
      dac(newmap, N/2);
    }

    // 4th
    for (int i = N/2; i < N; i++){
      for (int j = N/2; j < N; j++){
        newmap[i-N/2][j-N/2] = map[i][j];
      }
    }
    a = search(newmap,N/2);
    if (a == 0) white++;
    else if (a == 1) blue++;
    else{
      dac(newmap, N/2);
    }
  }

  // search function
  // -1: diff, 0: white, 1: blue
  private static int search(char[][] map, int n){
    int total = n*n;
    int tmpwhite = 0;
    int tmpblue = 0;
    for (int i = 0; i < n; i++){
      for (int j = 0; j < n; j++){
        if (map[i][j] == '1') tmpblue++;
        else tmpwhite++;
      }
    }

    if (tmpblue == total) return 1;
    else if (tmpwhite == total) return 0;
    else return -1;
  }
}