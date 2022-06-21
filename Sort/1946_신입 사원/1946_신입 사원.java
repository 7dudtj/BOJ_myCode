import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.Arrays;

public class Main {
  // set needed static variables
  public static void main(String[] args) throws IOException{
    // set needed variables
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;
    int T = Integer.parseInt(br.readLine());
    int N, a, b, count, max;
    Score[] list;

    // do main process for T times
    for (int times = 0; times < T; times++){
      // get N and set list
      N = Integer.parseInt(br.readLine());
      list = new Score[N];

      // get list
      for (int i = 0; i < N; i++){
        st = new StringTokenizer(br.readLine(), " ");
        a = Integer.parseInt(st.nextToken());
        b = Integer.parseInt(st.nextToken());
        list[i] = new Score(a, b);
      }

      // sort list by aval
      Arrays.sort(list);

      // count answer
      count = 1;
      max = list[0].bval;
      for (int i = 1; i < N; i++){
        if (list[i].bval < max){
          count++;
          max = list[i].bval;
        }
      }

      // print answer
      System.out.println(count);
    }

    // end program
    br.close();
    return;
  }
}

// Score class
class Score implements Comparable<Score>{
  // class variables
  int aval;
  int bval;
  // constructor
  public Score(int a, int b){
    aval = a;
    bval = b;
  }
  // comparable
  @Override
  public int compareTo(Score s){
    return aval - s.aval;
  }
}
