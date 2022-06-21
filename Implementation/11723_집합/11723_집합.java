import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

public class Main {
  public static void main(String[] args) throws IOException{
    // set needed components
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    ArrayList<Integer> list = new ArrayList<Integer>();
    StringBuilder sb = new StringBuilder();
    int M = Integer.parseInt(br.readLine());
    int value;
    String s;

    // do process
    for (int i = 0; i < M; i++){
      s = br.readLine();
      // add operation
      if (s.substring(0,3).equals("add")){
        value = Integer.parseInt(s.substring(4));
        if (!list.contains(value)) list.add(value);
      }
      // remove operation
      else if (s.substring(0,3).equals("rem")){
        value = Integer.parseInt(s.substring(7));
        if (list.contains(value)) list.remove(list.indexOf(value));
      }
      // check operation
      else if (s.substring(0,3).equals("che")){
        value = Integer.parseInt(s.substring(6));
        if (list.contains(value)) sb.append(1).append('\n');
        else sb.append(0).append('\n');
      }
      // toggle operation
      else if (s.substring(0,3).equals("tog")){
        value = Integer.parseInt(s.substring(7));
        if (list.contains(value)) list.remove(list.indexOf(value));
        else list.add(value);
      }
      // all operation
      else if (s.substring(0,3).equals("all")){
        list = new ArrayList<Integer>();
        for (int j = 1; j <= 20; j++) list.add(j);
      }
      // empty operation
      else{
        list.clear();
      }
    }

    // end program
    System.out.print(sb);
    br.close();
    return;
  }
}
