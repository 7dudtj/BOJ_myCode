import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {
	public static void main(String args[]) throws IOException	{
    // set needed variables
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;
    long[] in = new long[8];
    st = new StringTokenizer(br.readLine(), " ");
    for (int i = 0; i < 4; i++){
      in[i] = Long.parseLong(st.nextToken());
    }
    st = new StringTokenizer(br.readLine(), " ");
    for (int i = 4; i < 8; i++){
      in[i] = Long.parseLong(st.nextToken());
    }

    // find answer
    int a = ccw(in[0],in[2],in[6],in[1],in[3],in[7]);
    int b = ccw(in[0],in[2],in[4],in[1],in[3],in[5]);
    int c = ccw(in[6],in[4],in[0],in[7],in[5],in[1]);
    int d = ccw(in[6],in[4],in[2],in[7],in[5],in[3]);

    // print answer and end program
    if (a==0&&b==0&&c==0&&d==0) {
        if (check(in[0],in[2],in[1],in[3],in[6],in[7]) || 
        check(in[0],in[2],in[1],in[3],in[4],in[5])){
            System.out.print(1);
        }else if (check(in[4],in[6],in[5],in[7],in[2],in[3]) ||
        check(in[4],in[6],in[5],in[7],in[0],in[1])){
            System.out.print(1);
        }else System.out.print(0);
    }
    else if (a*b <= 0 && c*d <= 0) System.out.print(1);
    else System.out.print(0);
    br.close();
    return;
  }

  // ccw function
  private static int ccw
  (long x1, long x2, long x3, long y1, long y2, long y3){
    long a = (x1*y2+x2*y3+x3*y1) - (x2*y1+x3*y2+x1*y3);
    if (a > 0) return 1;
    else if (a == 0) return 0;
    else return -1;
  }

  // line and point check function
  private static boolean check
  (long x1, long x2, long y1, long y2, long xa, long ya){
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