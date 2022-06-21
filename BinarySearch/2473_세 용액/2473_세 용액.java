import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.Arrays;
import java.lang.Math;

public class Main {
  // set needed variables
  static int N, idx1, idx2, idx3;
  static long[] arr;
  static long minValue = Long.MAX_VALUE;

  public static void main(String[] args) throws IOException{
    // set needed components
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    N = Integer.parseInt(br.readLine());
    arr = new long[N];
    StringTokenizer st = new StringTokenizer(br.readLine(), " ");
    for (int i = 0; i < N; i++) arr[i] = Long.parseLong(st.nextToken());
    Arrays.sort(arr);

    // solve: O(N^2)
    solve();

    // print answer and end program
    System.out.println(arr[idx1]+" "+arr[idx2]+" "+arr[idx3]);
    br.close();
    return;
  }

  // solve function
  private static void solve(){
    // time: O(N)
    for (int i = 0; i < N; i++){
      // time: O(N)
      int j = i+1;
      int k = N-1;
      while (j < k){
        long sum = arr[i] + arr[j] + arr[k];
        if (Math.abs(sum) < minValue){
          idx1 = i;
          idx2 = j;
          idx3 = k;
          minValue = Math.abs(sum);
        }
        // sum < 0
        if (sum < 0) j++;
        // sum > 0
        else k--;
      }
    }
  }
}
