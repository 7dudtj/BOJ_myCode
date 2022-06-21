import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
	public static void main(String args[]) throws IOException	{
    // set needed variables
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());
    int checksum = 0;
    String s;
    br.close();

    for (int i = 1; i < N; i++){
      checksum = i;
      s = Integer.toString(i);
      for (int j = 0; j < s.length(); j++){
        checksum += Integer.parseInt(s.substring(j,j+1));
      }
      if (checksum == N) {
        System.out.println(i);
        return;
      }
    }

    // print answer and end program
    System.out.println(0);
    return;
  }
}