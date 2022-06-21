import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
	public static void main(String args[]) throws IOException	{
    // set needed variables
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());

    // print answer and end program
    if (N % 2 == 0) System.out.println("CY");
    else System.out.println("SK");
    br.close();
    return;
  }
}