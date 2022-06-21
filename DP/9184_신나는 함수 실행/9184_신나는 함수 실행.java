import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {
  static int[][][] map;
  public static void main(String[] args) throws IOException{
    // set needed components
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;
    StringBuilder sb = new StringBuilder();
    int a, b, c;

    // make map
    map = new int[21][21][21];
    for (a = 0; a <= 20; a++){
      for (b = 0; b <= 20; b++){
        for (c = 0; c <= 20; c++){
          // basic setting
          if (a==0 || b==0 || c==0) map[a][b][c] = 1;
          // do dp
          else if (a<b && b<c){
            map[a][b][c] = map[a][b][c-1] + map[a][b-1][c-1] - map[a][b-1][c];
          }else map[a][b][c] = map[a-1][b][c] + map[a-1][b-1][c] + map[a-1][b][c-1] - map[a-1][b-1][c-1];
        }
      }
    }

    // do main process
    String s;
    int answer;
    while (true){
      // get a, b, and c
      st = new StringTokenizer(br.readLine(), " ");
      a = Integer.parseInt(st.nextToken());
      b = Integer.parseInt(st.nextToken());
      c = Integer.parseInt(st.nextToken());
      if (a==-1 && b==-1 && c==-1) break;
      
      // get answer
      if (a<=0 || b<=0 || c<= 0) answer = 1;
      else if (a>20 || b>20 || c>20) answer = map[20][20][20];
      else answer = map[a][b][c];

      // make string
      s = "w("+a+", "+b+", "+c+") = "+answer;
      sb.append(s).append('\n');
    }

    // print answer and end program
    System.out.print(sb);
    br.close();
    return;
  }
}