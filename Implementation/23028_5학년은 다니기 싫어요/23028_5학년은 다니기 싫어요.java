import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {
	public static void main(String args[]) throws IOException	{
    // set needed variables
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine(), " ");
    int N = Integer.parseInt(st.nextToken());
    int A = Integer.parseInt(st.nextToken());
    int B = Integer.parseInt(st.nextToken());
    int[][] rest = new int[8-N][2];  

    // get rest data
    for (int i = 0; i < 8-N; i++){
      st = new StringTokenizer(br.readLine(), " ");
      rest[i][0] = Integer.parseInt(st.nextToken());
      rest[i][1] = Integer.parseInt(st.nextToken());
    }
    for (int i = 8-N; i < 10; i++) st = new StringTokenizer(br.readLine(), " ");

    // do main process
    int rest_t = 130 - B;
    int sum_t = 0;
    int rest_j = 66 - A;
    int sum_j = 0;
    for (int i = 0; i < 8-N; i++){
      if (rest[i][0]+rest[i][1] >= 7){
        sum_t += 6;
      }else sum_t += (rest[i][0]+rest[i][1]);
    }
    for (int i = 0; i < 8-N; i++){
      sum_j += rest[i][0];
    }

    // print answer and end program
    if (sum_t*3 >= rest_t && sum_j*3 >= rest_j){
      System.out.print("Nice");
    }else System.out.print("Nae ga wae");
    br.close();
    return;
  }
}