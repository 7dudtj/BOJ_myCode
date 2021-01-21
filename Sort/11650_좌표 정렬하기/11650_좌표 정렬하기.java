import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.util.Comparator;

public class Main {
  public static void main(String[] args) throws IOException{
    // set needed components
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());
    int[][] cor = new int[N][2];

    // get data
    for (int i = 0; i < N; i++){
      StringTokenizer st = new StringTokenizer(br.readLine(), " ");
      cor[i][0] = Integer.parseInt(st.nextToken());
      cor[i][1] = Integer.parseInt(st.nextToken());
    }

    // sort data
    Arrays.sort(cor, new Comparator<int[]>(){
      // x: asc, y: asc
      @Override
      public int compare(int[] s1, int[] s2){
        if (s1[0] == s2[0]){
          return s1[1] - s2[1];
        }else{
          return s1[0] - s2[0];
        }
      }
    });

    // set StringBuilder
    StringBuilder sb = new StringBuilder();

    // make StringBuilder
    for (int i = 0; i < N; i++){
      sb.append(cor[i][0]+" "+cor[i][1]+'\n');
    }

    // print answer and end program
    System.out.print(sb);
    br.close();
    return;
  }
}

