import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.Stack;

public class Main{
  
  // set static variables
  static Stack<Integer> s = new Stack<>();

  public static void main(String[] args) throws IOException{

    // set needed variables
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());
    String input = "", command = "";
    StringTokenizer st = null;
    int item = 0;
    StringBuilder sb = new StringBuilder();

    // do commands
    for (int i = 0; i < N; i++){

      // get command
      input = br.readLine();
      command = input.substring(0,3);

      // do command
      if (command.equals("pus")){ // push
        st = new StringTokenizer(input);
        input = st.nextToken();
        item = Integer.parseInt(st.nextToken());
        push(item);
        continue;
      }
      else if (command.equals("pop")){ // pop
        item = pop();
      }
      else if (command.equals("siz")){ // size
        item = size();
      }
      else if (command.equals("emp")){ // empty
        item = empty();
      } 
      else if (command.equals("top")){ // top
        item = top();
      }else{
        continue;
      }
      sb.append(item).append('\n');
    }

    // print answer and end program
    System.out.print(sb);
    br.close();
    return;
  }


  // commands---------------------------------------\
  private static void push(int item){ // push

    s.push(item);
    return;
  }

  private static int pop(){ // pop

    if (empty() == 1) return -1;
    else return s.pop();
  }

  private static int size(){ // size

    return s.size();
  }

  private static int empty(){ // empty

    if (s.isEmpty()) return 1;
    else return 0;
  }

  private static int top(){ // top
    if (empty() == 1) return -1;
    else return s.peek();
  }
}