import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.Arrays;

public class Main {
	public static void main(String args[]) throws IOException	{
    // set needed variables
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());
    StringTokenizer st = new StringTokenizer(br.readLine(), " ");
    int[] asc = new int[N];
    int[] des = new int[N];
    asc[0] = 1;
    des[0] = 1;

    // get data and do dp
    int one = Integer.parseInt(st.nextToken());
    for (int i = 1; i < N; i++){
      int two = Integer.parseInt(st.nextToken());
      if (one < two) {
        asc[i] = asc[i-1] + 1;
        des[i] = 1;
      }else if (one > two){
        des[i] = des[i-1] + 1;
        asc[i] = 1;
      }else{
        asc[i] = asc[i-1] + 1;
        des[i] = des[i-1] + 1;
      }
      one = two;
    }

    // sort and find answer
    Arrays.sort(asc);
    Arrays.sort(des);
    int answer = Integer.MIN_VALUE;
    if (asc[N-1] > answer) answer = asc[N-1];
    if (des[N-1] > answer) answer = des[N-1];

    // print answer and end program
    System.out.println(answer);
    br.close();
    return;
  }
}