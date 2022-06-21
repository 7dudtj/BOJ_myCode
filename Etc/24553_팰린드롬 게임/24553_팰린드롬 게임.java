import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
  public static void main(String[] args) throws IOException{
    // set needed components
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();
    int T = Integer.parseInt(br.readLine());

    // get input and answer
    for (int i = 0; i < T; i++){
      if (Long.parseLong(br.readLine()) % 10 == 0) sb.append(1).append('\n');
      else sb.append(0).append('\n');
    }

    // print answer and end program
    System.out.print(sb);
    br.close();
    return;
  }
}