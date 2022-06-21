import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.List;
import java.util.LinkedList;

public class Main {
	public static void main(String args[]) throws Exception	{
    // set needed variables
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();
    boolean[] list = new boolean[40001];
    int C = Integer.parseInt(br.readLine());
    StringTokenizer st = new StringTokenizer(br.readLine(), " ");
    int[] c = new int[C];
    for (int i = 0; i < C; i++){
      c[i] = Integer.parseInt(st.nextToken());
    }
    int G = Integer.parseInt(br.readLine());
    int[] g = new int[G];
    st = new StringTokenizer(br.readLine(), " ");
    for (int i = 0; i < G; i++){
      g[i] = Integer.parseInt(st.nextToken());
    }

    // do dp
    for (int i = 0; i < C; i++){
      int now = c[i];
      List<Integer> wait = new LinkedList<>();
      for (int j = 1; j <= 40000; j++){
        if (list[j]){
          if (Math.abs(now - j) != 0){
            wait.add(Math.abs(now - j));
          }
          if (now + j <= 40000){
            wait.add(now + j);
          }
        }
      }
      for (int e: wait){
        list[e] = true;
      }
      list[now] = true;
    }
    
    // find answer
    for (int i = 0; i < G; i++){
      if (list[g[i]]) sb.append("Y ");
      else sb.append("N ");
    }

    // print answer and end program
    System.out.print(sb);
    br.close();
    return;
  }
}