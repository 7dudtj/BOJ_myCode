import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.lang.Math;
import java.util.Arrays;

public class Main {
  // set needed variables
  public static void main(String[] args) throws IOException{
    // set needed components
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine(), " ");
    int N = Integer.parseInt(st.nextToken());
    int C = Integer.parseInt(st.nextToken());
    int[] house = new int[N];

    // get houses
    for (int i = 0; i < N; i++) house[i] = Integer.parseInt(br.readLine());
    Arrays.sort(house);

    // do binary search
    int answer = 1;
    int start = 1;
    int end = house[N-1] - house[0];
    while (start <= end){
      int mid = (start + end) / 2;

      boolean pos = search(house, C, mid);

      if (pos) {
        start = mid + 1;
        answer = Math.max(answer, mid);
      }  
      else end = mid - 1;
    }

    // print answer and end program
    System.out.print(answer);
    br.close();
    return;
  }

  // search function
  public static boolean search(int[] h, int c, int m){
    int count = 1;
    int last = h[0] + m;

    for (int i = 1; i < h.length; i++){
      if (last <= h[i]) {
        count++;
        last = h[i] + m;        
      }
    }
    return count >= c;
  }
}

