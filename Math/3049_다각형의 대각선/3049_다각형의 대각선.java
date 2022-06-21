import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
	public static void main(String args[]) throws Exception	{
    // set needed variables
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    int answer = n * (n-1) * (n-2) * (n-3) / 24;
    System.out.print(answer);
  }
}