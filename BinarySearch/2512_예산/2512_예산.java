import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {
	public static void main(String args[]) throws IOException	{
    // set needed variables
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());
    int[] list = new int[N+1];
    StringTokenizer st = new StringTokenizer(br.readLine(), " ");
    int sum = 0;
    int M = Integer.parseInt(br.readLine());

    // get list
    for (int i = 1; i <= N; i++){
      list[i] = Integer.parseInt(st.nextToken());
      sum += list[i];
    }

    // if (sum <= M)
    if (sum <= M){
      int max = Integer.MIN_VALUE;
      for (int i = 1; i <= N; i++){
        if (list[i] > max) max = list[i];
      }
      System.out.println(max);
      return;
    }

    // do binary search
    int start = 0;
    int end = M;
    int mid = 0;
    while (start <= end){
      mid = (start + end)/2;
      sum = 0;
      for (int i = 1; i <= N; i++){
        if (list[i] >= mid) sum += mid;
        else sum += list[i];
      }
      if (sum > M) end = mid - 1;
      else start = mid + 1;
    }

    // print answer and end program
    System.out.println(end);
    br.close();
    return;
  }
}