import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {
  public static void main(String[] args) throws IOException{
    // set needed components
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine(), " ");
    int n = Integer.parseInt(st.nextToken());
    int m = Integer.parseInt(st.nextToken());
    int[][] map = new int[n][m];
    int[][] d = new int[n][m];
    int ans = 0;

    // get map
    for (int i = 0; i < n; ++i){
      String s = br.readLine();
      for (int j = 0; j < m; ++j){
        map[i][j] = d[i][j] = Integer.parseInt(s.substring(j,j+1));
        if (d[i][j] == 1) ans = 1;
      }
    }

    // do dp
    for (int i = 1; i < n; ++i){
      for (int j = 1; j < m; ++j){
        if (map[i][j] == 1){
          d[i][j] = Math.min(d[i][j-1], 
          Math.min(d[i-1][j], d[i-1][j-1])) + 1;
          ans = d[i][j] > ans ? d[i][j] : ans;
        }
      }
    }

    // print answer and end program
    System.out.print(ans*ans);
    br.close();
    return;
  }
}