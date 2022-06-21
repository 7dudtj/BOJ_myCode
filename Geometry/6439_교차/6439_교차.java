import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {
  // set static variables
  static long[][] d;
	public static void main(String args[]) throws IOException	{
    // set needed variables
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;
    StringBuilder sb = new StringBuilder();
    int T = Integer.parseInt(br.readLine());
    
    // do process for T times
    for (int times = 0; times < T; times++){
      // get input
      st = new StringTokenizer(br.readLine(), " ");
      long[] list = new long[8];
      for (int i = 0; i < 8; i++){
        list[i] = Long.parseLong(st.nextToken());
      }

      // find rectangular
      long xl, xr, yb, yt;
      if (list[4] > list[6]){
        xl = list[6];
        xr = list[4];
      }else{
        xl = list[4];
        xr = list[6];
      }
      if (list[7] > list[5]){
        yt = list[7];
        yb = list[5];
      }else{
        yt = list[5];
        yb = list[7];
      }

      // replace data
      d = new long[5][4];
      for (int i = 0; i < 4; i++) d[0][i] = list[i];
      d[1][0] = d[3][0] = d[4][0] = d[4][2] = xl;
      d[1][2] = d[2][0] = d[2][2] = d[3][2] = xr;
      d[1][1] = d[1][3] = d[2][1] = d[4][1] = yb;
      d[2][3] = d[3][1] = d[3][3] = d[4][3] = yt;
      long xs = list[0], ys = list[1], xe = list[2], ye = list[3];

      // check if line is in rectangular
      if (xl<xs&&xs<xr&&xl<xe&&xe<xr&&yb<ys&&ys<yt&&yb<ye&&ye<yt){
        // line is in rectangular
        sb.append("T").append('\n');
      }
      // line is not in rectangular
      else{
        // check intersect
        boolean contact = false;
        for (int i = 1; i <= 4; i++){
          if (intersect(0, i)){
            contact = true;
          }
        }

        // print answer
        if (contact) sb.append("T").append('\n');
        else sb.append("F").append('\n');
      }
    }

    // print answer and end program
    System.out.print(sb);
    br.close();
    return;
  }

  // check line intersection function
  private static boolean intersect(int i, int j){
    long aa = ccw(d[i][0], d[i][2], d[j][2], d[i][1], d[i][3], d[j][3]);
    long bb = ccw(d[i][0], d[i][2], d[j][0], d[i][1], d[i][3], d[j][1]);
    long cc = ccw(d[j][2], d[j][0], d[i][0], d[j][3], d[j][1], d[i][1]);
    long dd = ccw(d[j][2], d[j][0], d[i][2], d[j][3], d[j][1], d[i][3]);

    if (aa==0&&bb==0&&cc==0&&dd==0){
      if (check(d[i][0], d[i][2], d[i][1], d[i][3], d[j][2], d[j][3]) || 
      check(d[i][0], d[i][2], d[i][1], d[i][3], d[j][0], d[j][1])){
        return true;
      }else if (check(d[j][0], d[j][2], d[j][1], d[j][3], d[i][2], d[i][3]) || 
      check(d[j][0], d[j][2], d[j][1], d[j][3], d[i][0], d[i][1])){
        return true;
      }else return false;
    }
    else if (aa*bb <= 0 && cc*dd <= 0) return true;
    else return false;
  }

  // ccw function
  private static long ccw(long x1, long x2, long x3, long y1, long y2, long y3){
    long a = (x1*y2+x2*y3+x3*y1) - (x2*y1+x3*y2+x1*y3);
    if (a > 0) return 1;
    else if (a == 0) return 0;
    else return -1;
  }

  // line and point check function
  private static boolean check(long x1, long x2, long y1, long y2, long xa, long ya){
    // sort points
    if (x1 >= x2){
      long tmp = x1;
      x1 = x2;
      x2 = tmp;
    }
    if (y1 >= y2){
      long tmp = y1;
      y1 = y2;
      y2 = tmp;
    }

    // check
    if ((x1 <= xa && xa <= x2) && (y1 <= ya && ya <= y2)) return true;
    else return false;
  }
}