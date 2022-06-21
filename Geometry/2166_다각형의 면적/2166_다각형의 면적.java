import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {
	public static void main(String args[]) throws Exception	{
    // set needed variables
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;
    int N = Integer.parseInt(br.readLine());
    int[][] cor = new int[N+1][2];
    long first = 0, second = 0, result = 0, a, b;
    String answer = "";

    // get cors
    for (int i = 0; i < N; i++){
      st = new StringTokenizer(br.readLine(), " ");
      cor[i][0] = Integer.parseInt(st.nextToken());
      cor[i][1] = Integer.parseInt(st.nextToken());
    }
    cor[N][0] = cor[0][0];
    cor[N][1] = cor[0][1];

    // get first
    for (int i = 0; i < N; i++){
      a = cor[i][0];
      b = cor[i+1][1];
      first += (a * b);
    }

    // get second
    for (int i = 0; i < N; i++){
      a = cor[i+1][0];
      b = cor[i][1];
      second += (a * b);
    }

    // get result
    result = Math.abs(first - second);

    // get answer
    if (result % 2 == 0){
      answer = String.valueOf(result/2 + ".0");
    } else{
      answer = String.valueOf(result/2 + ".5");
    }

    // print answer and end program
    System.out.println(answer);
    br.close();
    return;
  }
}