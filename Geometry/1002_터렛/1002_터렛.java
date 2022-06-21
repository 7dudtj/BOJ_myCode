import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {
	public static void main(String args[]) throws Exception	{
    // set needed variables
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;
    StringBuilder sb = new StringBuilder();
    int T = Integer.parseInt(br.readLine());
    double[] d; // x1, y1, r1, x2, y2, r2
    double r1, r2, r, tmp;

    // do main process
    for (int times = 0; times < T; times++){
      // get data
      d = new double[6];
      st = new StringTokenizer(br.readLine(), " ");
      for (int i = 0; i < 6; i++) d[i] = Double.parseDouble(st.nextToken());
      r1 = d[2];
      r2 = d[5];
      r = Math.sqrt(Math.pow(d[3] - d[0], 2) + Math.pow(d[4] - d[1], 2));

      // calculate
      // two cor >> same
      if (d[0] == d[3] && d[1] == d[4]){
        if (r1 == r2) sb.append(-1).append('\n');
        else sb.append(0).append('\n');
      }
      // two cor >> not same
      else{
        if (r1 + r2 < r) sb.append(0).append('\n');
        else if (r1 + r2 == r) sb.append(1).append('\n');
        else{
          // r1 >= r2
          if (r2 > r1){
            tmp = r2;
            r2 = r1;
            r1 = tmp;
          }

          if (r1 - r2 == r) sb.append(1).append('\n');
          else if (r1 - r2 > r) sb.append(0).append('\n');
          else sb.append(2).append('\n');
        }
      }
    }

    // print answer and end program
    System.out.print(sb);
    br.close();
    return;
  }
}