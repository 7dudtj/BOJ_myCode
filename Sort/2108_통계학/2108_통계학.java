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
    int[] count = new int[8001];
    int input, idx = 0, max = Integer.MIN_VALUE, maxcount = 0;
    double one = 0;

    // get datas
    for (int i = 0; i < N; i++){
      input = Integer.parseInt(br.readLine());
      count[input+4000]++;
      list[i] = input;
    }

    // sort data
    Arrays.sort(list);

    // get answer
    for (int i = 0; i < N; i++) one+= (double)list[i];
    System.out.println(Math.round(one / N));
    System.out.println(list[N/2]);
    for (int i = 0; i <= 8000; i++){
      if (count[i] != 0 && count[i] >= max) {
        max = count[i];
      }
    }
    for (int i = 0; i <= 8000; i++){
      if (count[i] == max){
        maxcount++;
        if (1 <= maxcount && maxcount <= 2) idx = i;
      }
    }
    System.out.println(idx - 4000);
    System.out.println(list[N-1]-list[0]);

    // end program
    br.close();
    return;
  }
}
