import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.List;
import java.util.LinkedList;
import java.util.Arrays;

public class Main {
	public static void main(String args[]) throws Exception	{
    // set needed variables
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine(), " ");
    int N = Integer.parseInt(st.nextToken());
    int M = Integer.parseInt(st.nextToken());
    List<object> ob =  new LinkedList<>();
    int v, c, k;
    int[] dp = new int[M+1];

    // get objects
    for (int i = 0; i < N; i++){
      st = new StringTokenizer(br.readLine(), " ");
      v = Integer.parseInt(st.nextToken());
      c = Integer.parseInt(st.nextToken());
      k = Integer.parseInt(st.nextToken());

      for (int j = 1; k > 0; j <<= 1){
        int ix = Math.min(j, k);
        ob.add(new object(v*ix, c*ix));
        k -= ix;
      }
    }

    // do dp
    for (object o: ob){
      for (int j = M; j >= 0; j--){
        int e = j + o.v;
        if (e <= M){
          dp[e] = Math.max(dp[e], dp[j] + o.c);
        }
      }
    }
    Arrays.sort(dp);

    // print answer and end program
    System.out.print(dp[M]);
    br.close();
    return;
  }
}

// object class
class object{
  int v;
  int c;
  public object(int v, int c){
    this.v = v;
    this.c = c;
  }
}