import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {
  // set needed variables
  static int[] answer = new int[9];
  static int N, M;

  public static void main(String[] args) throws IOException{
    // set needed components
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine(), " ");
    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());

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
      if (i < answer[depth-1]) continue;
      answer[depth] = i;

      // do backtracking at next depth
      bt(depth + 1);
    }
  }
}
