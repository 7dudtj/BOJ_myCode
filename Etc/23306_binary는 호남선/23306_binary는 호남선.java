import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
	public static void main(String args[]) throws IOException	{
    // set needed variables
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());
    int first, last;
    int answer;
    
    // do process
    System.out.println("? 1");
    System.out.flush();
    first = Integer.parseInt(br.readLine());
    System.out.println("? "+N);
    System.out.flush();
    last = Integer.parseInt(br.readLine());

    // print answer and end program
    if (first == last) answer = 0;
    else if (first > last) answer = -1;
    else answer = 1;
    System.out.println("! "+answer);
    br.close();
    return;
  }
}