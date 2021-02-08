import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.Arrays;

public class Main {
  // set needed variables
  public static void main(String[] args) throws IOException{
    // set needed components
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine(), " ");
    int K = Integer.parseInt(st.nextToken());
    int N = Integer.parseInt(st.nextToken());
    int[] len = new int[K];
    long start, end, mid = 0;

    // get lens and sort
    for (int i = 0; i < K; i++){
      len[i] = Integer.parseInt(br.readLine());
    }
    Arrays.sort(len);

    // find answer
    start = 1; 
    end = len[K-1];
    while (start <= end){
      mid = (start+end)/2;
      long sum = 0;
      for (int i = 0; i < K; i++){
        sum += (len[i]/mid);
      }
      if (sum < N) end = mid - 1;
      else start = mid + 1;
    }

    // print answer and end program
    System.out.print(end);
    br.close();
    return;
  }
}
