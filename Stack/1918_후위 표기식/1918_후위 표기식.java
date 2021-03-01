import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Stack;

public class Main {
  // set needed variables
  public static void main(String[] args) throws IOException{
    // set needed components
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();
    String input = br.readLine();
    Stack<String> s = new Stack<>();
    int len = input.length();
    int i = 0;

    // do process
    s.push(input.substring(i, i+1));
    i++;
    while (true){
      // if top is alphabet
      if (isalpha(s.peek())){
        sb.append(s.pop());
      }
      // if top is "-" or "+"
      else if (s.peek().equals("-") || s.peek().equals("+")){
        while (true){
          String tmp = s.pop();
          if (!s.isEmpty()){
            if (s.peek().equals("-") || s.peek().equals("+") || s.peek().equals("*") || s.peek()  .equals("/")){
              sb.append(s.pop());
              s.push(tmp);
            }else {
              s.push(tmp);
              break;
            }  
          }else {
            s.push(tmp);
            break;
          }  
        }
      }
      // if top is "*" or "/"
      else if (s.peek().equals("*") || s.peek().equals("/")){
        while (true){
          String tmp = s.pop();
          if (!s.isEmpty()){
            if (s.peek().equals("*") || s.peek().equals("/")){
              sb.append(s.pop());
              s.push(tmp);
            }else {
              s.push(tmp);
              break;
            } 
          }else {
            s.push(tmp);
            break;
          } 
        }
      }
      // if top is ")"
      else if (s.peek().equals(")")){
        while (true){
          if (s.peek().equals(")")) s.pop();
          else if (s.peek().equals("(")){
            s.pop();
            break;
          }
          else{
            sb.append(s.pop());
          }
        }
      }
      // if top is "("
      else{
        // do nothing
      }

      // check if finish
      if (i == len) {
        while (!s.isEmpty()) sb.append(s.pop());
        break;
      }
      s.push(input.substring(i, i+1));
      i++;
    }

    // print answer and end program
    System.out.print(sb);
    br.close();
    return;
  }

  // check if it is alphabet
  private static boolean isalpha(String s){
    return (!s.equals("+") && !s.equals("-") && !s.equals("*") 
    && !s.equals("/") && !s.equals("(") && !s.equals(")"));
  }
}

