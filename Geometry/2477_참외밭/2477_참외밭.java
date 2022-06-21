import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.lang.Math;

public class Main {
  public static void main(String[] args) throws IOException{
    // set needed components
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;
    int K = Integer.parseInt(br.readLine());
    int[][] list = new int[5][2];
    boolean[] one = new boolean[5];
    int ans = 0, sum = 0, prev = 0, first = 0, lw, lh;

    // get data and calculate sum
    for (int i = 0; i < 6; i++){
      st = new StringTokenizer(br.readLine(), " ");
      int code = Integer.parseInt(st.nextToken());
      int data = Integer.parseInt(st.nextToken());

      if (i == 0) first = data;
      sum += prev * data;

      if (!one[code]) {
        list[code][0] = data;
        one[code] = true;
      }  
      else list[code][1] = data;

      prev = data;
    }
    sum += prev*first;

    // find long width and long height
    if (list[4][1] == 0) lw = list[4][0];
    else lw = list[3][0];
    if (list[2][1] == 0) lh = list[2][0];
    else lh = list[1][0];

    // print answer and end program
    System.out.print(K * (lw*lh - (3*lw*lh - sum)));
    br.close();
    return;
  }
}