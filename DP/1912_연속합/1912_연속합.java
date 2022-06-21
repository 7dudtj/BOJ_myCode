import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {
  public static void main(String[] args) throws IOException{
    // set needed components
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    int max = Integer.MIN_VALUE;
    int[] list = new int[n];
    StringTokenizer st = new StringTokenizer(br.readLine());
    for (int i = 0; i < n; i++) list[i] = Integer.parseInt(st.nextToken());

    // do dp
    for (int i = 0; i < n-1; i++){
      if (list[i]+list[i+1] > list[i+1]) list[i+1] += list[i];
    }

    // find answer
    for (int i = 0; i < n; i++){
      if (list[i] > max) max = list[i];
    }

    // print answer and end program
    System.out.print(max);
    br.close();
    return;
  }
}