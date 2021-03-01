import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.Arrays;

public class Main {
  // set needed variables
  static int[] answer = new int[9];
  static int[] number = new int[9];
  static int N, M;

  public static void main(String[] args) throws IOException{
    // set needed components
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine(), " ");
    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());

    // get numbers and sort
    st = new StringTokenizer(br.readLine(), " ");
    for (int i = 1; i <= N; i++) number[i] = Integer.parseInt(st.nextToken());
    for (int i = N+1; i <= 8; i++) number[i] = Integer.MAX_VALUE;
    Arrays.sort(number);

    // do backtracking
    bt(1);

    // end program
    br.close();
    return;
  }

  // backtracking function
  public static void bt(int depth){
    // check if backtracking is finish
    if (depth == M+1){
      for (int i = 1; i <= M; i++) System.out.print(answer[i]+" ");
      System.out.println();
      return;
    }

    // do backtracking
    for (int i = 1; i <= N; i++){
      // visit i at depth
      if (number[i] < answer[depth-1]) continue;
      answer[depth] = number[i];

      // do backtracking at next depth
      bt(depth + 1);
    }
  }
}

