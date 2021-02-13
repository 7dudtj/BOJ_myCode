import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {
  public static void main(String[] args) throws IOException{
    // set needed components
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    int count = 1;
    int from = 2, to = 7;

    if (n == 1){
      System.out.println(1);
      br.close();
      return;
    }

    while (true){
      if (from <= n && n <= to){
        System.out.println(count + 1);
        br.close();
        return;
      }

      from += count*6;
      to += (count+1)*6;
      count++;
    }
  }
}
