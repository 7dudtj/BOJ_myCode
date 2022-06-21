import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.Queue;
import java.util.LinkedList;

public class Main {
  static int M;
  static int[] V;
  static boolean find;
  static boolean[] dp;
  static Queue<Integer> q = new LinkedList<>();
  public static void main(String[] args) throws IOException{
    // set needed components
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine(), " ");
    int N = Integer.parseInt(st.nextToken());
    int S = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());
    V = new int[N+1];
    st = new StringTokenizer(br.readLine(), " "); br.close();
    for (int i = 1; i <= N; i++) V[i] = Integer.parseInt(st.nextToken());
    dp = new boolean[M+1];
    dp[S] = true;
    find = false;
    int answer = 0;

    // do dp
    for (int i = 1; i <= N; i++){
      // do process
      find = false;
      for (int j = 0; j <= M; j++){
        if (dp[j]) finding(i, j);
      }
      // error catch
      if (!find){
        System.out.print(-1);
        return;
      }
      // reset dp
      for (int j = 0; j <= M; j++) dp[j] = false;
      // refill dp
      while (!q.isEmpty()) dp[q.poll()] = true;
    }

    // find answer
    for (int i = M; i >= 0; i--) {
      if (dp[i]){
        answer = i;
        break;
      }
    }

    // print answer and end program
    System.out.print(answer);
    return;
  }

  // finding function
  private static void finding(int i, int j){
    // out of range
    if (j-V[i] < 0 && j+V[i] > M) return;

    // main process
    find = true;
    if (j-V[i] >= 0) q.add(j-V[i]);
    if (j+V[i] <= M) q.add(j+V[i]);
  }
}