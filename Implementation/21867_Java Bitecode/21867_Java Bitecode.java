import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
  public static void main(String[] args) throws IOException{
    // set needed variables
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());
    String s = br.readLine();
    StringBuilder sb = new StringBuilder();
    int count = 0;

    // do process
    for (int i = 0; i < N; i++){
      if (s.substring(i,i+1).equals("J") || s.substring(i,i+1).equals("A") || s.substring(i,i+1).equals("V")){
        count++;
      }else{
        sb.append(s.substring(i,i+1));
      }
    }

    // print answer and end program
    if (count == N) System.out.print("nojava");
    else System.out.print(sb);
    br.close();
    return;
  }
}
