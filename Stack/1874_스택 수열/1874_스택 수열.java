import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Stack;

public class Main{

  // set static variables

  public static void main(String[] args) throws IOException{

    // set needed variables
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    int[] list = new int[n];
    StringBuilder sb = new StringBuilder();
    int push = 0, pop = 0, target = 0;
    Stack<Integer> s = new Stack<>();
    boolean possible = true;

    // get list
    for (int i = 0; i < n; i++) list[i] = Integer.parseInt(br.readLine());

    // find answer
    for (int i = 0; i < n; i++){

      target = list[i];

      // impossible
      if (!s.isEmpty() && s.peek() > target){
        possible = false;
        break;
      }

      // find answer
      if (!s.isEmpty() && s.peek() == target){
        s.pop();
        pop++;
        sb.append("-").append('\n');
        continue;
      }

      // push stack
      while (true){
        s.push(++push);
        sb.append("+").append('\n');
        if (s.peek() == target){
          s.pop();
          pop++;
          sb.append("-").append('\n');
          break;
        }
      }

    }

    // print answer and end program
    if (possible) System.out.print(sb);
    else System.out.print("NO");
    br.close();
    return;
  } 
}