import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.Arrays;

public class Main {
	public static void main(String args[]) throws Exception	{
    // set needed variables
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int T = Integer.parseInt(br.readLine());
    int[][] points = new int[4][2];
    long[] answer = new long[6];
    StringBuilder sb = new StringBuilder();
    StringTokenizer st;
    boolean square = true;

    // main process
    for (int times = 0; times < T; times++){
      // get four points
      for (int i = 0; i < 4; i++){
        st = new StringTokenizer(br.readLine(), " ");
        points[i][0] = Integer.parseInt(st.nextToken());
        points[i][1] = Integer.parseInt(st.nextToken());
      }

      // calculate
      int count = 0;
      for (int i = 0; i < 3; i++){
        for (int j = i+1; j < 4; j++){
          answer[count] = distance(points[i][0], points[i][1], points[j][0], points[j][1]);
          count++;
        }
      }

      // find answer
      Arrays.sort(answer);
      long len = answer[0];
      for (int i = 1; i < 4; i++){
        if (answer[i] != len){
          square = false;
          break;
        }
      }
      if (answer[4] != answer[5]) square = false;
      if (answer[3] == answer[4]) square = false;

      // get answer
      if (square) sb.append("1").append('\n');
      else sb.append("0").append('\n');
    }

    // print answer and end program
    System.out.print(sb);
    br.close();
    return;
  }

  // calculate distance function
  private static long distance(int ax, int ay, int bx, int by){
    return (ax - bx)*(ax - bx) + (ay - by)*(ay - by);
  }
}