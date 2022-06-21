import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.io.IOException;

public class Main {
  // set needed variables
  static int n;
  public static void main(String[] args) throws IOException{
    // set needed components
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int m;
    StringTokenizer st;
    int[] card;

    // get n and m
    st = new StringTokenizer(br.readLine(), " ");
    n = Integer.parseInt(st.nextToken());
    m = Integer.parseInt(st.nextToken());

    // get cards
    card = new int[n];
    st = new StringTokenizer(br.readLine(), " ");
    for (int i = 0; i < n; i++)
      card[i] = Integer.parseInt(st.nextToken());

    // do process
    int min = Integer.MAX_VALUE;
    int ip = 0, jp = 0, kp = 0;
    for (int i = 0; i < n; i++){
      for (int j = i+1; j < n; j++){
        for (int k = j+1; k < n; k++){
          int sum = card[i] + card[j] + card[k];
          int diff = m - sum;
          if (diff == 0){
            System.out.print(sum);
            br.close();
            return;
          }
          if (0 < diff && diff <= min) {
            min = diff;
            ip = i; jp = j; kp = k;
          }  
        }
      }
    }
    System.out.print(card[ip]+card[jp]+card[kp]);
    br.close();
    return;
  }
}
