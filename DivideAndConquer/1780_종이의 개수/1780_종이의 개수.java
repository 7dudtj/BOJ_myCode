import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {
  // set static variables
  static int m1 = 0;
  static int zero = 0;
  static int p1 = 0;
	public static void main(String args[]) throws IOException	{
    // set needed variables
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;
    int N = Integer.parseInt(br.readLine());
    int[][] map = new int[N][N];

    // get map
    for (int i = 0; i < N; i++){
      st = new StringTokenizer(br.readLine(), " ");
      for (int j = 0; j < N; j++){
        map[i][j] = Integer.parseInt(st.nextToken());
      }
    }

    // do main process
    dac(map, N);

    // print answer and end program
    System.out.println(m1);
    System.out.println(zero);
    System.out.println(p1);
    br.close();
    return;
  }

  // divide and conquer function
  private static void dac(int[][] map, int N){
    int[][] newmap = new int[N/3][N/3];
    int a;

    // exception
    if (N == 1){
      if(map[0][0] == -1) m1++;
      else if (map[0][0] == 0) zero++;
      else p1++;
      return;
    }

    // search itself
    a = search(map, N);
    if (a == -1) {
      m1++;
      return;
    }
    else if (a == 0){
      zero++;
      return;
    }
    else if (a == 1){
      p1++;
      return;
    }

    // 1st
    for (int i = 0; i < N/3; i++){
      for (int j = 0; j < N/3; j++){
        newmap[i][j] = map[i][j];
      }
    }
    a = search(newmap,N/3);
    if (a == -1) m1++;
    else if (a == 0) zero++;
    else if (a == 1) p1++;
    else{
      dac(newmap, N/3);
    }

    // 2nd
    for (int i = 0; i < N/3; i++){
      for (int j = N/3; j < (N/3)*2; j++){
        newmap[i][j-N/3] = map[i][j];
      }
    }
    a = search(newmap,N/3);
    if (a == -1) m1++;
    else if (a == 0) zero++;
    else if (a == 1) p1++;
    else{
      dac(newmap, N/3);
    }

    // 3rd
    for (int i = 0; i < N/3; i++){
      for (int j = (N/3)*2; j < N; j++){
        newmap[i][j-(N/3)*2] = map[i][j];
      }
    }
    a = search(newmap,N/3);
    if (a == -1) m1++;
    else if (a == 0) zero++;
    else if (a == 1) p1++;
    else{
      dac(newmap, N/3);
    }

    // 4th
    for (int i = N/3; i < (N/3)*2; i++){
      for (int j = 0; j < N/3; j++){
        newmap[i-N/3][j] = map[i][j];
      }
    }
    a = search(newmap,N/3);
    if (a == -1) m1++;
    else if (a == 0) zero++;
    else if (a == 1) p1++;
    else{
      dac(newmap, N/3);
    }

    // 5th
    for (int i = N/3; i < (N/3)*2; i++){
      for (int j = N/3; j < (N/3)*2; j++){
        newmap[i-N/3][j-N/3] = map[i][j];
      }
    }
    a = search(newmap,N/3);
    if (a == -1) m1++;
    else if (a == 0) zero++;
    else if (a == 1) p1++;
    else{
      dac(newmap, N/3);
    }

    // 6th
    for (int i = N/3; i < (N/3)*2; i++){
      for (int j = (N/3)*2; j < N; j++){
        newmap[i-N/3][j-(N/3)*2] = map[i][j];
      }
    }
    a = search(newmap,N/3);
    if (a == -1) m1++;
    else if (a == 0) zero++;
    else if (a == 1) p1++;
    else{
      dac(newmap, N/3);
    }

    // 7th
    for (int i = (N/3)*2; i < N; i++){
      for (int j = 0; j < N/3; j++){
        newmap[i-(N/3)*2][j] = map[i][j];
      }
    }
    a = search(newmap,N/3);
    if (a == -1) m1++;
    else if (a == 0) zero++;
    else if (a == 1) p1++;
    else{
      dac(newmap, N/3);
    }

    // 8th
    for (int i = (N/3)*2; i < N; i++){
      for (int j = N/3; j < (N/3)*2; j++){
        newmap[i-(N/3)*2][j-N/3] = map[i][j];
      }
    }
    a = search(newmap,N/3);
    if (a == -1) m1++;
    else if (a == 0) zero++;
    else if (a == 1) p1++;
    else{
      dac(newmap, N/3);
    }

    // 9th
    for (int i = (N/3)*2; i < N; i++){
      for (int j = (N/3)*2; j < N; j++){
        newmap[i-(N/3)*2][j-(N/3)*2] = map[i][j];
      }
    }
    a = search(newmap,N/3);
    if (a == -1) m1++;
    else if (a == 0) zero++;
    else if (a == 1) p1++;
    else{
      dac(newmap, N/3);
    }
  }

  // search function
  // -1: m1, 0: zero, 1: p1, 2: diff
  private static int search(int[][] map, int n){
    int total = n*n;
    int tmpm1 = 0;
    int tmpzero = 0;
    int tmpp1 = 0;
    for (int i = 0; i < n; i++){
      for (int j = 0; j < n; j++){
        if (map[i][j] == -1) tmpm1++;
        else if (map[i][j] == 0) tmpzero++;
        else tmpp1++;
      }
    }

    if (tmpm1 == total) return -1;
    else if (tmpzero == total) return 0;
    else if (tmpp1 == total) return 1;
    else return 2;
  }
}