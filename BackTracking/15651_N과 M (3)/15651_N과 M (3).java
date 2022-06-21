import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {
  static int N, M;
  static StringBuilder sb = new StringBuilder();
  static int[] s;
	public static void main(String args[]) throws IOException	{
    // set needed variables
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());
    s = new int[M+1];

    // do main process
    bt(1);

    // print answer and end program
    System.out.print(sb);
    br.close();
    return;
  }

  // backtracking function
  private static void bt(int depth){
    // find answer
    if (depth == M+1){
      for (int i = 1; i <= M; i++){
        sb.append(s[i]+" ");
      } sb.append('\n');
      return;
    }

    // do process
    for (int i = 1; i <= N; i++){
      s[depth] = i;
      bt(depth + 1);
    }
  }
}