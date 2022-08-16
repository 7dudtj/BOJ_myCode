import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Queue;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main{

  // set static variables
  static Queue<Integer> q = new LinkedList<>();
  static StringBuilder sb = new StringBuilder();
  static int back = -1;

  public static void main(String[] args) throws IOException{

    // set needed variables
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());
    String input = "", command = "";
    int item = 0;
    StringTokenizer st = null;

    // do commands
    for (int i = 0; i < N; i++){

      // get command
      input = br.readLine();
      command = input.substring(0, 3);

      // do command
      if (command.equals("pus")){
        /* push */
        st = new StringTokenizer(input, " ");
        input = st.nextToken();
        item = Integer.parseInt(st.nextToken());
        push(item);
        back = item;
      }
      else if (command.equals("pop")){
        /* pop */
        item = pop();
        sb.append(item).append('\n');
        if (empty() == 1) back = -1;
      }
      else if (command.equals("siz")){
        /* size */
        item = size();
        sb.append(item).append('\n');
      }
      else if (command.equals("emp")){
        /* empty */
        item = empty();
        sb.append(item).append('\n');
      }
      else if (command.equals("fro")){
        /* front */
        item = front();
        sb.append(item).append('\n');
      }
      else if (command.equals("bac")){
        item = back();
        sb.append(item).append('\n');
      }
      else{
        continue;
      }
    }

    // print answer and end program
    System.out.print(sb);
    br.close();
    return;
  }

  
  // commands--------------------------------------\

  /* push function */
  private static void push(int x){

    q.add(x);
    return;
  }

  /* pop function */
  private static int pop(){

    if (empty() == 1) return -1;
    else return q.poll();
  }

  /* size function */
  private static int size(){

    return q.size();
  }

  /* empty function */
  private static int empty(){

    if (q.isEmpty()) return 1;
    else return 0;
  }

  /* front function */ 
  private static int front(){

    if (empty() == 1) return -1;
    else return q.peek();
  }

  /* back function */
  private static int back(){

    return back;
  }
}