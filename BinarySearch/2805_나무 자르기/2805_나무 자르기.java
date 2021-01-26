import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
  public static void main(String[] args) throws IOException{
    // set needed components
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N;
    long M;
    int[] trees;
    StringTokenizer st;

    // get N and M
    st = new StringTokenizer(br.readLine(), " ");
    N = Integer.parseInt(st.nextToken());
    M = Long.parseLong(st.nextToken());

    // get trees
    trees = new int[N];
    st = new StringTokenizer(br.readLine(), " ");
    for (int i = 0; i < N; i++){
      trees[i] = Integer.parseInt(st.nextToken());
    }
    Arrays.sort(trees);

    // find answer
    long start = 0;
    long end = trees[N-1];
    while (start <= end){
      long mid = (start + end)/2;
      long sum = 0;
      for (int i = 0; i < N; i++){
        if (trees[i] > mid){
          sum += (trees[i] - mid);
        }
      }
      if (sum >= M){
        start = mid+1;
      }else{
        end = mid-1;
      }
    }

    // print answer and end program
    System.out.print(end);
    br.close();
    return;
  }
}
