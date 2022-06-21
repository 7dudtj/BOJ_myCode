import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Arrays;

public class Main {
  // set needed variables
  public static void main(String[] args) throws IOException{
    // set needed components
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());
    int[] list = new int[N];
    int[] max = new int[N];

    // get data
    for (int i = 0; i < N; i++) list[i] = Integer.parseInt(br.readLine());

    // sort list
    Arrays.sort(list);

    // find answer
    for (int i = 0; i < N; i++){
      if (list[i] * (N-i) >= list[N-1]) max[i] = list[i] * (N-i);
      else max[i] = 0;
    }

    // sort max
    Arrays.sort(max);

    // print answer and end program
    System.out.println(max[N-1]);
    br.close();
    return;
  }
}

