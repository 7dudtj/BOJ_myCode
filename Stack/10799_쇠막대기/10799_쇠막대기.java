import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Stack;

public class Main {
  public static void main(String[] args) throws IOException{
    // set needed components
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    Stack<Integer> s = new Stack<>();
    String input;
    int answer = 0;

    // get input
    input = br.readLine();

    // do process
    for (int i = 0; i < input.length(); i++){
      // "("
      if (input.substring(i,i+1).equals("(")) s.push(i);
      // ")"
      else{
        // if raser is found
        if (s.peek() == i-1){
          s.pop();
          answer += s.size();
        }
        // raser is not found
        else{
          s.pop();
          answer++;
        }
      }
    }

    // print answer and end program
    System.out.println(answer);
    br.close();
    return;
  }
}
