import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Stack;
 
public class Main {
  public static void main(String args[]) throws IOException  {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String key = br.readLine();
    String input = br.readLine();
    Stack<Character> left = new Stack<>();
    Stack<Character> right = new Stack<>();
    int start = 0;
    int end = input.length()-1;
    boolean find = false;

    // find key at both side
    while (start <= end){
      if (!find){
        left.push(input.charAt(start++));
        // find key at left side
        if (left.size() >= key.length() && left.peek() == key.charAt(key.length()-1)){
          int keyLen = key.length() - 1;
          boolean check = true;
          for (int i = left.size()-1; i >= left.size()-key.length(); i--){
            if (left.get(i) != key.charAt(keyLen--)){
              check = false;
              break;
            }
          }
          if (check){
            find = true;
            for (int i = 0; i < key.length(); i++) left.pop();
          }
        }
      }

      // find key at right side
      if (find && start <= end){
        String revKey = new StringBuilder(key).reverse().toString();
        right.push(input.charAt(end--));
        if (right.size() >= key.length() && right.peek() == revKey.charAt(revKey.length()-1)){
          int keyLen = key.length() - 1;
          boolean check = true;
          for (int i = right.size()-1; i >= right.size()-key.length(); i--){
            if (right.get(i) != revKey.charAt(keyLen--)){
              check = false;
              break;
            }
          }
          if (check){
            for (int i = 0; i < key.length(); i++) right.pop();
            find = false;
          }
        }
      }
    }

    // add two stack
    int leftSize = left.size();
    for (int i = 0; i < leftSize; i++) {
      right.push(left.pop());
    }  

    // build new string
    StringBuilder sb = new StringBuilder();
    while (!right.isEmpty()) sb.append(right.pop());

    // delete combined key
    while (true){
      int idx = sb.indexOf(key);
      if (idx < 0) break;
      sb.delete(idx, idx+key.length());
    }

    // print answer and end program
    System.out.print(sb); 
    br.close();
    return;
  }
}