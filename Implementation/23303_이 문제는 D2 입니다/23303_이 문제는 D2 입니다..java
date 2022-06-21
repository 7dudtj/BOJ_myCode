import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
	public static void main(String args[]) throws IOException	{
    // set needed variables
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String s = br.readLine();
    String answer = "unrated";

    for (int i = 0; i < s.length()-1; i++){
      if (s.substring(i, i+2).equals("D2")){
        answer = "D2";
        break;
      }
      if (s.substring(i,i+2).equals("d2")){
        answer = "D2";
        break;
      }
    }

    System.out.println(answer);
    br.close();
    return;
  }
}
