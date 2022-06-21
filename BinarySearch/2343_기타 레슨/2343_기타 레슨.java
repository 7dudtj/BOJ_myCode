import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {
  public static void main(String[] args) throws IOException{
    // set needed components
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine(), " ");
    int N = Integer.parseInt(st.nextToken());
    int M = Integer.parseInt(st.nextToken());
    int[] list = new int[N];
    int max = Integer.MIN_VALUE, sum = 0, mid = 0, psum = 0, count = 0;

    // get data
    st = new StringTokenizer(br.readLine(), " ");
    for (int i = 0; i < N; i++){
      list[i] = Integer.parseInt(st.nextToken());
      max = Math.max(list[i], max);
      sum += list[i];
    }

    // do binary search
    int start = max;
    int end = sum;

    while (start <= end){
      mid = (start + end) / 2;
      psum = 0; count = 0;

      for (int i = 0; i < N; i++){
        psum += list[i];

        if (psum < mid){
          continue;
        }
        else if (psum == mid){
          psum = 0;
          count++;
        }
        else{
          psum = list[i];
          count++;
        }
      }
      if (psum != 0) count++;

      if (M < count){
        start = mid + 1;
      }
      else if (M > count){
        end = mid - 1;
      }
      else{
        break;
      }
    }

    // check answer
    int ans = mid;
    psum = 0; count = 0;
    while (true){
      psum = 0; count = 0;
      ans--;
      if (ans < max){
        ans++;
        break;
      }

      for (int i = 0; i < N; i++){
        psum += list[i];

        if (psum < ans){
          continue;
        }
        else if (psum == ans){
          psum = 0;
          count++;
        }
        else{
          psum = list[i];
          count++;
        }
      }
      if (psum != 0) count++;

      if (count > M){
        ans++;
        break;
      }
    }

    // print answer and end program
    System.out.print(ans);
    br.close();
    return;
  }
}