import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
  public static void main(String[] args) throws IOException{
    // set needed components
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String input = br.readLine(); br.close();
    String s;
    int left=0, right=0, total=0, answer=0;

    // main process
    for (int i = 0; i < input.length(); i++){
      s = input.substring(i,i+1);
      
      // count
      if (s.equals("(")){
        left++;
        total++;
      }else{
        right++;
        total--;
      }

      // process
      if (total <= 1) left = 0;
      // right
      if (total == -1) {
        answer = right;
        break;
      }
    }

    // left
    if (total > 0) answer = left;

    // print answer and end program
    System.out.print(answer);
    return;
  }
}