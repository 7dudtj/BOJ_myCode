import java.util.Scanner;
import java.util.Stack;


public class Main {
  public static void main(String[] args) {
    // set needed components
    Stack<String> st = new Stack();
    Scanner read = new Scanner(System.in);
    String s;

    // do process
    // get data
    s = read.nextLine();
    while (!s.equals("0")){
      boolean odd = true;
      int j = 0;
      boolean pal = true;
      // get input's length
      int len = s.length();
      // check if length is 1
      if (len == 1){
        System.out.println("yes");
        s = read.nextLine();
        continue;
      }
      // check len is even or odd
      if (len % 2 == 0) odd = false;
      // push data
      for (int i = 0; i < len/2; i++)
        st.push(s.substring(i,i+1));
      if (odd) j = len/2 + 2;
      else j = len/2 + 1;
      // match data
      for (int i = j; i <= len; i++){
        String in = st.pop();
        String out = s.substring(i-1,i);
        // not palindrome
        if (!in.equals(out)) pal = false;
      }
      // it is palindrome
      if (pal) System.out.println("yes"); 
      else System.out.println("no");   
      // get next data
      s = read.nextLine();
    }
    // end program
    read.close();
    return;
  }
}
