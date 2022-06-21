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
    int a = ccw(in[0],in[2],in[6],in[1],in[3],in[7]) 
    * ccw(in[0],in[2],in[4],in[1],in[3],in[5]);
    int b = ccw(in[6],in[4],in[0],in[7],in[5],in[1]) 
    * ccw(in[6],in[4],in[2],in[7],in[5],in[3]);

    // print answer and end program
    if (a < 0 && b < 0) System.out.print(1);
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
}