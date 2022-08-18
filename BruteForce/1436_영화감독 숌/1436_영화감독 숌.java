import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main{

  // set static variables

  public static void main(String[] args) throws IOException{

    // set needed variables
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());
    int count = 0;
    String answer = "";

    // find answer
    for (int i = 1; i <= 10000000; i++){

      answer = String.valueOf(i);
      if (answer.contains("666")){
        count++;
        if (count == N) break;
      }
    }

    // print answer and end program
    System.out.print(answer);
    br.close();
    return;
  }
}