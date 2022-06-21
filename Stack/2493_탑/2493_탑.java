import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.Stack;

public class Main {
  public static void main(String[] args) throws IOException{
    // set needed components
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    Stack<tower> s = new Stack<>();
    StringBuilder sb = new StringBuilder();
    int N = Integer.parseInt(br.readLine());
    int[] info = new int[N];

    // get data
    StringTokenizer st = new StringTokenizer(br.readLine(), " ");
    for (int i = 0; i < N; i++){
      info[i] = Integer.parseInt(st.nextToken());
    }

    // do process
    for (int i = 0; i < N; i++){
      while (!s.isEmpty()){
        if (s.peek().height >= info[i]){
          sb.append(s.peek().pos+1+" ");
          s.push(new tower(i, info[i]));
          break;
        }
        else{
          s.pop();
        }
      }

      if (s.isEmpty()){
        sb.append(0+" ");
        s.push(new tower(i, info[i]));
      }
    }

    // print answer and end program
    System.out.print(sb);
    br.close();
    return;
  }
}

// tower class
class tower{
  int pos;
  int height;
  public tower (int p, int h){
    pos = p;
    height = h;
  }
}
