import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.Queue;
import java.util.LinkedList;

public class Main {

  // set static variables

  public static void main(String[] args) throws IOException{

    // set needed variables
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine(), " ");
    int M = Integer.parseInt(st.nextToken());
    int N = Integer.parseInt(st.nextToken());
    boolean[] list = new boolean[1000001];
    Queue<Integer> q = new LinkedList<>();
    StringBuilder sb = new StringBuilder();

    // do main process
    for (int i = 2; i <= 1000000; i++){

      // find prime number
      if (!list[i]){

        q.add(i);
        for (int prime = i, times = 1; prime*times <= 1000000; times++){
          if (!list[prime*times]){
            list[prime*times] = true;
          }
        }
      }
    }

    // get answer
    while (!q.isEmpty()){
      int tmp = q.poll();
      if (tmp > N) break;
      if (M <= tmp && tmp <= N){
        sb.append(tmp).append('\n');
      }
    }

    // print answer and end program
    System.out.print(sb);
    br.close();
    return;
  }
}