import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {
  // set needed variables
  public static void main(String[] args) throws IOException{
    // set needed components
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());
    int max = Integer.MAX_VALUE, start = 0, end = N-1, re1 = 0, re2 = 0;
    int[] list = new int[N];
    StringTokenizer st = new StringTokenizer(br.readLine(), " ");
    for (int i = 0; i < N; i++) list[i] = Integer.parseInt(st.nextToken());

    // find result by two pointer
    while (start < end){
      // get two data
      int y1 = list[start];
      int y2 = list[end];

      // check max
      if (Math.abs(y1+y2) < max){
        max = Math.abs(y1+y2);
        re1 = start;
        re2 = end; 
      }

      // adjust pointer
      if (y1+y2 < 0) start++;
      else end--;
    }

    // print answer and end program
    System.out.println(list[re1]+" "+list[re2]);
    br.close();
    return;
  }
}
