import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.Arrays;

public class Main {
  // set needed variables
  static int L, C;
  static int[] list, answer;
  static boolean[] visited;

  public static void main(String[] args) throws IOException{
    // set needed components
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine(), " ");
    L = Integer.parseInt(st.nextToken());
    C = Integer.parseInt(st.nextToken());
    list = new int[C+1];
    visited = new boolean[C+1];
    answer = new int[L+1];

    // get alphabets
    st = new StringTokenizer(br.readLine(), " ");
    list[0] = 0;
    for (int i = 1; i <= C; i++) list[i] = (int)st.nextToken().charAt(0) - 96;
    Arrays.sort(list);

    // do backtracking
    bt(1);

    // end program
    br.close();
    return;
  }

  // backtracking function
  public static void bt(int depth){
    // check if backtracking is finish
    if (depth == L+1){
      // set variables
      int mo = 0;
      int ja = 0;

      // check
      for (int i = 1; i <= L; i++){
        if (answer[i] == 1 || answer[i] == 5 || answer[i] == 9 || 
        answer[i] == 15 || answer[i] == 21) mo++;
        else ja++;
      }

      // if right, print answer
      if (mo >= 1 && ja >= 2){
        Arrays.sort(answer);
        for (int j = 1; j <= L; j++) System.out.print((char)(answer[j]+96));
        System.out.println();
      }
      return;
    }

    // do backtracking
    for (int k = 1; k <= C; k++){
      // visit i at depth
      if (visited[k]) continue;
      if (list[k] <= answer[depth-1]) continue;
      visited[k] = true;
      answer[depth] = list[k];

      // do backtracking at next depth
      bt(depth + 1);

      // reset and prepare for next backtracking
      visited[k] = false;
    }
  }
}

