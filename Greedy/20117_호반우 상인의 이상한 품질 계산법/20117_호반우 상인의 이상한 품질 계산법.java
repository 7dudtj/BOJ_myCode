import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.Arrays;

public class Main {
  public static void main(String[] args) throws IOException{
    // set needed components
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());
    int[] hobanwo = new int[N];
    int answer = 0;

    // get hobanwo
    StringTokenizer st = new StringTokenizer(br.readLine(), " ");
    for (int i = 0; i < N; i++) hobanwo[i] = Integer.parseInt(st.nextToken());

    // sort hobanwo
    Arrays.sort(hobanwo);

    // calculate answer
    if (N % 2 == 0){
      for (int i = N/2; i < N; i++) answer += hobanwo[i];
      answer *= 2;
    } else if (N == 1){
      answer = hobanwo[0];
    } else{
      for (int i = N/2 + 1; i < N; i++) answer += hobanwo[i];
      answer *= 2;
      answer += hobanwo[N/2];
    }

    // print answer and end program
    System.out.print(answer);
    br.close();
    return;
  }
}