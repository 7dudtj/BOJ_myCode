import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {
  // set needed variables
  public static void main(String[] args) throws IOException{
    // set needed components
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;
    StringBuilder sb = new StringBuilder();
    int T = Integer.parseInt(br.readLine());
    int N, M;
    int[] q;
    int idx;
    int answer;
    boolean print;

    // do main process
    for (int times = 0; times < T; times++){
      // get variables
      st = new StringTokenizer(br.readLine(), " ");
      N = Integer.parseInt(st.nextToken());
      M = Integer.parseInt(st.nextToken());
      q = new int[N];
      st = new StringTokenizer(br.readLine(), " ");
      for (int i = 0; i < N; i++) q[i] = Integer.parseInt(st.nextToken());
      idx = M;
      answer = 0;

      // check if can be print
      while (true){
        // if 0 comes
        if (q[0] == 0) {
          for (int i = 1; i < N; i++) q[i-1] = q[i];
          q[N-1] = 0;
          idx--;
        }

        // check
        print = true;
        for (int i = 1; i < N; i++){
          // 출력 불가
          if (q[i] > q[0]){
            int tmp = q[0];
            for (int j = 1; j < N; j++) q[j-1] = q[j];
            q[N-1] = tmp;
            if (idx == 0) idx = N-1;
            else idx--;
            print = false;
            break;
          }
        }

        // 출력
        if (print){
          answer++;
          // print answer
          if (idx == 0){
            sb.append(answer).append('\n');
            break;
          }
          // not an answer
          else{
            for (int i = 1; i < N; i++) q[i-1] = q[i];
            q[N-1] = 0;
            idx--;
          }
        }
      }
    }

    // print answer and end program
    System.out.print(sb);
    br.close();
    return;
  }
}
