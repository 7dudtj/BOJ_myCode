import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

// buttom-up DP
public class Main {
  public static void main(String[] args) throws IOException{
    // set needed components
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();
    int N = Integer.parseInt(br.readLine());
    int[] memo = new int[N+1];
    int[] value = new int[N+1];
    memo[0] = 0; memo[1] = 0; value[1] = 1;

    // make value list
    for (int i = 2; i <= N; i++){
      memo[i] = memo[i-1] + 1;
      value[i] = i-1;
      if (i % 3 == 0) {
        if (memo[i/3]+1 <= memo[i]){
          memo[i] = memo[i/3] + 1;
          value[i] = i/3;
        }  
      }  
      if (i % 2 == 0) {
        if (memo[i/2]+1 <= memo[i]){
          memo[i] = memo[i/2] + 1;
          value[i] = i/2;
        }  
      }
    }

    // get answer
    sb.append(memo[N]).append('\n').append(N).append(" ");
    int input = N;
    while (input > 1){
      sb.append(value[input]).append(" ");
      input = value[input];
    }

    // print answer and end program
    System.out.print(sb);
    br.close();
    return;
  }
}