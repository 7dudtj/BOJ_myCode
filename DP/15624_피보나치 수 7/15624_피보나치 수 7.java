import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
	public static void main(String args[]) throws IOException	{
    // set needed variables
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());
    int[] fibb = new int[N+1];
    if (N == 0 || N == 1){
      System.out.println(N);
      return;
    }
    fibb[1] = 1;

    // fibonacci
    for (int i = 2; i <= N; i++){
      fibb[i] = (fibb[i-1]+fibb[i-2])%1000000007;
    }

    // print answer and end program
    System.out.println(fibb[N]);
    br.close();
    return;
  }
}