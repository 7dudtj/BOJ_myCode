import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
	public static void main(String args[]) throws IOException	{
    // set needed variables
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String input = br.readLine();
    int answer = 0;

    // do main process
    if (input.length() == 4){
      answer += 20;
    }else if (input.length() == 3){
      if (input.substring(0,2).equals("10")){
        answer += 10;
        answer += Integer.parseInt(input.substring(2));
      }else{
        answer += 10;
        answer += Integer.parseInt(input.substring(0,1));
      }
    }else{
      answer += Integer.parseInt(input.substring(0,1));
      answer += Integer.parseInt(input.substring(1));
    }

    // print answer and end program
    System.out.println(answer);
    br.close();
    return;
  }
}