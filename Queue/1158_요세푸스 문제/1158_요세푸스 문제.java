import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.Queue;
import java.util.LinkedList;
import java.lang.StringBuilder;

public class Main {
  // set needed variables
  public static void main(String[] args) throws IOException{
    // set needed components
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine(), " ");
    StringBuilder sb = new StringBuilder();
    int N = Integer.parseInt(st.nextToken());
    int K = Integer.parseInt(st.nextToken());
    Queue<Integer> q = new LinkedList<>();
    int[] man = new int[N+1];
    for (int i = 0; i <= N; i++) man[i] = i;
    int point = 0;
    int[] answer = new int[N];

    // do process
    while (q.size() != N){
      int count = 0;
      while (true){
        point++;
        if (point > N) point = 1;
        if (man[point] != 0){
          count++;
        }
        if (count == K){
          q.add(man[point]);
          man[point] = 0;
          break;
        }
      }
    }

    // set answer
    for (int i = 0; i < N; i++) answer[i] = q.poll();

    // print answer and end program
    sb.append("<");
    for (int i = 0; i < N-1; i++) sb.append(answer[i]).append(", ");
    sb.append(answer[N-1]).append(">");
    System.out.print(sb);
    br.close();
    return;
  }
}
