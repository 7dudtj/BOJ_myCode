import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
  public static void main(String[] args) throws IOException{
    // set needed components
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());
    tile(N);
  }

  public static void tile(int n){
    long[] len = new long[n+1];
    len[0] = 0; len[1] = 1;
    long answer = 0;

    for (int i = 2; i <= n; i++){
      len[i] = len[i-1] + len[i-2];
    }

    answer = len[n-1]*2 + len[n]*4;

    System.out.print(answer);
  }
}
