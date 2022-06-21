import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.Arrays;
import java.util.Comparator;

public class Main {
  // set needed variables
  public static void main(String[] args) throws IOException{
    // set needed components
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;
    int N = Integer.parseInt(br.readLine());
    int from, to;
    int[][] time = new int[N][2];

    // get time
    for (int i = 0; i < N; i++){
      st = new StringTokenizer(br.readLine(), " ");
      time[i][0] = Integer.parseInt(st.nextToken());
      time[i][1] = Integer.parseInt(st.nextToken());
    }

    // sort time 
    Arrays.sort(time, new Comparator<int[]>(){
      // end: asc, start: asc
      @Override
      public int compare(int[] t1, int[] t2){
        if (t1[1] == t2[1]) return t1[0]-t2[0];
        else return t1[1]-t2[1];
      }
    });

    // count
    int count = 0;
    int prev_endtime = 0;
    for (int i = 0; i < N; i++){
      if (time[i][0] >= prev_endtime){
        prev_endtime = time[i][1];
        count++;
      }
    }

    // print answer and end program
    System.out.println(count);
    br.close();
    return;
  }
}
