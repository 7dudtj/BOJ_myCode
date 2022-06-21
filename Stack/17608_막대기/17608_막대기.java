import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Stack;

public class Main {
	public static void main(String args[]) throws Exception	{
    // set needed variables
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    Stack<Integer> s = new Stack<>();
    int N = Integer.parseInt(br.readLine());
    int input, answer = 0, top;

    // get data
    for (int i = 0; i < N; i++){
      input = Integer.parseInt(br.readLine());
      s.push(input);
    }

    // do process
    top = 0;
    while (!s.empty()){
      int now = s.pop();
      if (now > top){
        top = now;
        answer++;
      }
    }

    // print answer and end program
    System.out.print(answer);
    br.close();
    return;
  }
}