import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.Arrays;

public class Main {
  public static void main(String[] args) throws IOException{
    // set needed components
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine(), " ");
    int N = Integer.parseInt(st.nextToken());
    int M = Integer.parseInt(st.nextToken());
    String[] d = new String[N];
    String[] b = new String[M];
    int answer = 0;
    StringBuilder sb = new StringBuilder();

    // get and sort d&b
    for (int i = 0; i < N; i++) d[i] = br.readLine();
    for (int i = 0; i < M; i++) b[i] = br.readLine();
    Arrays.sort(d);
    Arrays.sort(b);

    // find answer
    for (int i = 0; i < N; i++){
      int start = 0;
      int end = M-1;
      int mid;

      while (start <= end){
        mid = (start + end) / 2;
        // 값을 찾음
        if (b[mid].compareTo(d[i]) == 0){
          answer++;
          sb.append(d[i]).append('\n');
          break;
        }
        // 찾는 값이 작음
        else if (b[mid].compareTo(d[i]) > 0){
          end = mid - 1;
        }
        // 찾는 값이 큼
        else{
          start = mid + 1;
        }
      }
    }

    // print answer and end program
    System.out.println(answer);
    System.out.print(sb);
    br.close();
    return;
  }
}
