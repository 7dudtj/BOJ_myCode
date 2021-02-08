import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Stack;

public class Main {
  // set needed variables
  static int[] count0 = new int[41];
  static int[] count1 = new int[41];
  
  // bottom-up DP
  public static void main(String[] args) throws IOException{
    // set needed components
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int T, N;

    // get T
    T = Integer.parseInt(br.readLine());

    // preset count
    count0[0] = 1; count0[1] = 0;
    count1[0] = 0; count1[1] = 1;
    for (int i = 2; i < 41; i++){
      count0[i] = count1[i] = Integer.MAX_VALUE;
    }

    // do process
    for (int i = 0; i < T; i++){
      N = Integer.parseInt(br.readLine());
      fib0();
      fib1();
      System.out.println(count0[N]+" "+count1[N]);
    }

    // end program
    br.close();
    return;
  }

  public static void fib0(){
    for (int i = 2; i <= 40; i++) {
      count0[i] = count0[i-1] + count0[i-2];
    }
  }

  public static void fib1(){
    for (int i = 2; i <= 40; i++) {
      count1[i] = count1[i-1] + count1[i-2];
    }
  }
}
