import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {
  public static void main(String[] args) throws IOException{
    // set needed components
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    int[] list = new int[n];
    int[] count = new int[n];
    for (int i = 0; i < n; i++) count[i] = 1;
    StringTokenizer st = new StringTokenizer(br.readLine(), " ");
    for (int i = 0; i < n; i++) list[i] = Integer.parseInt(st.nextToken());
    int max = 0;

    // do dp
    for (int i = 0; i < n-1; i++){
      for (int j = i+1; j < n; j++){
        if (list[i] < list[j]){
          if (count[i]+1 > count[j]) count[j] = count[i]+1;
        }
      }
    }

    // find answer
    for (int i = 0; i < n; i++){
      if (count[i] > max) max = count[i];
    }

    // print answer and end program
    System.out.print(max);
    br.close();
    return;
  }
}