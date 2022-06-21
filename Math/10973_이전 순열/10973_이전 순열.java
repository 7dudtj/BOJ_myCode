import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.Arrays;
import java.util.Collections;

public class Main {
	public static void main(String args[]) throws IOException	{
    // set needed variables
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());
    int[] list = new int[N+1];
    StringBuilder sb = new StringBuilder();

    // get list
    StringTokenizer st = new StringTokenizer(br.readLine(), " ");
    for (int i = 1; i <= N; i++) list[i] = Integer.parseInt(st.nextToken());
    if (N == 1) {
      System.out.print(-1);
      return;
    }

    // do process
    int idx = 0;
    for (int i = N; i >= 2; i--){
      if (list[i] <= list[i-1]){
        idx = i-1;
        break;
      } 
    }
    if (idx == 0){
      System.out.print(-1);
      return;
    }
    int tidx = N;
    for (int i = N; i > idx; i--){
      if (list[tidx] > list[idx] && list[idx] > list[i]) tidx = i;
      if (list[i] < list[idx] && list[i] > list[tidx]) tidx = i;
    }
    
    // swap
    int tmp = list[idx];
    list[idx] = list[tidx];
    list[tidx] = tmp;

    // sort rest
    Integer[] copy = new Integer[N-idx];
    for (int i = idx+1; i <= N; i++) copy[i-idx-1] = list[i];
    Arrays.sort(copy, Collections.reverseOrder());
    for (int i = idx+1; i <= N; i++) list[i] = copy[i-idx-1];

    // print answer and end program
    for (int i = 1; i <= N; i++) sb.append(list[i]+" ");
    System.out.print(sb);
    br.close();
    return;
  }
}