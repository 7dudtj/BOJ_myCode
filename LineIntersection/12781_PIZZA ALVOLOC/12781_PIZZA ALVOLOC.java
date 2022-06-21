import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {
	public static void main(String args[]) throws IOException	{
    // set needed variables
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int[] input = new int[8];
    StringTokenizer st = new StringTokenizer(br.readLine(), " ");
    for (int i = 0; i < 8; i++){
      input[i] = Integer.parseInt(st.nextToken());
    }
    int answer = 0;

    // do ccw
    int a = ccw(input[4],input[5],input[6],input[7],input[0],input[1]) * 
    ccw(input[4],input[5],input[6],input[7],input[2],input[3]);
    int b = ccw(input[0],input[1],input[2],input[3],input[4],input[5]) *
    ccw(input[0],input[1],input[2],input[3],input[6],input[7]);

    if (a<0 && b<0) answer = 1;

    // print answer and end program
    System.out.println(answer);
    br.close();
    return;
  }

  // ccw function
  private static int ccw(int x1, int y1, int x2, int y2, int x3, int y3){
    int a = (x1*y2+x2*y3+x3*y1) - (y1*x2+y2*x3+y3*x1);

    if (a > 0) return 1;
    else if (a == 0) return 0;
    else return -1;
  }
}