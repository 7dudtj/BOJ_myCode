import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.Stack;
import java.util.Collections;
import java.util.ArrayList;
import java.util.Comparator;

public class Main {
  public static void main(String[] args) throws IOException{
    // set needed components
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;
    ArrayList<line> list = new ArrayList<>();
    int N = Integer.parseInt(br.readLine());
    int from = Integer.MIN_VALUE, to = Integer.MAX_VALUE;
    int answer = 0;

    // get lines
    for (int i = 0; i < N; i++){
      st = new StringTokenizer(br.readLine(), " ");
      int f = Integer.parseInt(st.nextToken());
      int t = Integer.parseInt(st.nextToken());
      list.add(new line(f, t));
    }

    // sort list
    Collections.sort(list, new Comparator<line>(){
      @Override
      public int compare(line a, line b){
        return a.from - b.from;
      }
    });

    // do process
    for (line i: list){
      // set new single line
      if (from == Integer.MIN_VALUE && to == Integer.MAX_VALUE){
        from = i.from;
        to = i.to;
      }
      // if new single line starts
      else if (to < i.from){
        answer += (to - from);
        from = i.from;
        to = i.to;
      }
      // extends single line
      else{
        if (to <= i.to) to = i.to;
      }
    }

    // add last line
    answer += (to - from);

    // print answer and end progrma
    System.out.print(answer);
    br.close();
    return;
  }
}

// line class
class line{
  int from;
  int to;
  public line(int f, int t){
    from = f;
    to = t;
  }
}
