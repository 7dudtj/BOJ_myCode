import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.Stack;

public class Main {
  // set needed variables
  public static void main(String[] args) throws IOException{
    // set needed components
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();
    StringTokenizer st = new StringTokenizer(br.readLine(), " ");
    int N = Integer.parseInt(st.nextToken());
    int K = Integer.parseInt(st.nextToken());
    String input = br.readLine();
    Stack<Character> s = new Stack<>();
    int count = 0, len = input.length();

    // do main porcess
    s.push(input.charAt(0));
    for (int i = 1; i < len; i++){
      char c = input.charAt(i);

      while (!s.isEmpty()){
        // if answer is ready
        if (count == K) break;

        // peek() < c
        if (s.peek() < c){
          s.pop();
          count++;
        }
        // peek() >= c
        else break;
      }

      s.push(c);
    }

    // make answer
    if (count < K){
      for (int i = 0; i < s.size() - (K - count); i++) 
        sb.append(s.get(i));
    }else{
      for (int i = 0; i < s.size(); i++)
        sb.append(s.get(i));
    }

    // print answer and end program
    System.out.print(sb);
    br.close();
    return;
  }
}
