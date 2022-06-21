import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {
  public static void main(String[] args) throws IOException{
    // set needed components
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());
    int[] list = new int[N];
    int sum1 = 0;
    StringTokenizer st = new StringTokenizer(br.readLine(), " ");
    for (int i = 0; i < N; i++) {
      int tmp = Integer.parseInt(st.nextToken());
      sum1 += tmp;
      list[i] = tmp;
    }
    int sum2 = 0;
    st = new StringTokenizer(br.readLine(), " ");
    for (int i = 0; i < N; i++){
      int code = Integer.parseInt(st.nextToken());
      if (code == 0) sum2 += list[i];
    }

    // print answer and end program
    System.out.println(sum1);
    System.out.print(sum2);
    br.close();
    return;
  }
}