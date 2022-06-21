import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Stack;

public class Main {
  // set needed static variables
  public static void main(String[] args) throws IOException{
    // set needed variables
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());
    Stack<Person> s = new Stack<>();
    int input;
    long answer = 0;
    
    // do main process
    for (int i = 0; i < N; i++){
      // get new input
      input = Integer.parseInt(br.readLine());
      Person p = new Person(input, 1);

      // if (peek() <= input), pop()
      while (!s.isEmpty()){
        if (s.peek().height <= input){
          answer += s.peek().friend;
          if (s.peek().height == input){
            p.friend += s.peek().friend;
          }
          s.pop();
        } else break;
      }

      // check if stack is empty
      if (!s.isEmpty()) answer++;

      // push input to stack
      s.push(p);
    }

    // print answer and end program
    System.out.println(answer);
    br.close();
    return;
  }  
}

// Person class
class Person{
  // class variables
  int height;
  int friend;
  // constructor
  public Person(int h, int f){
    height = h;
    friend = f;
  }
}
