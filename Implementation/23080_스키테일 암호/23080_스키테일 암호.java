import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
	public static void main(String args[]) throws IOException	{
    // set needed variables
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int K = Integer.parseInt(br.readLine());
    String s = br.readLine();
    String answer = "";

    // get answer
    for (int i = 0; i < s.length(); i += K){
      answer += s.substring(i,i+1);
    }

    // print answer and end program
    System.out.println(answer);
    br.close();
    return;
  }
}