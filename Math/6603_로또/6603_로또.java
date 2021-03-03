import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {
  // set needed variables
  static int len;
  static int[] list;
  static int[] answer = new int[7];
  static boolean[] visited;

  public static void main(String[] args) throws IOException{
    // set needed components
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;
    
    // do process
    while (true){
      // set needed variables
      String s = br.readLine();
      if (s.equals("0")) break;
      st = new StringTokenizer(s, " ");
      len = Integer.parseInt(st.nextToken());
      list = new int[len+1];
      visited = new boolean[len+1];
      for (int i = 1; i <= len; i++) list[i] = Integer.parseInt(st.nextToken());

      // do backtracing
      bt(1);
      System.out.println();
    }
    
    // end program
    br.close();
    return;
  }

  // backtracking function
  public static void bt(int depth){
    // check if backtracking is finish
    if (depth == 7){
      for (int i = 1; i <= 6; i++) System.out.print(answer[i]+" ");System.out.println();
      return;
    }

    // do backtracking
    for (int i = 1; i <= len; i++){
      // visit i at depth
      if (visited[i]) continue;
      if (list[i] <= answer[depth - 1]) continue;
      visited[i] = true;
      answer[depth] = list[i];

      // do backtracking at next depth
      bt(depth + 1);

      // reset and prepare for next backtracking
      visited[i] = false;
    }
    
  }
}

