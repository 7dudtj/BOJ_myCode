import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {
  // set needed variables
  public static void main(String[] args) throws IOException{
    // set needed components
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;
    StringBuilder sb = new StringBuilder();
    int N, M;
    int[] cards = new int[20000001];

    // get N and cards
    N = Integer.parseInt(br.readLine());
    st = new StringTokenizer(br.readLine(), " ");
    for (int i = 0; i < N; i++) ++cards[Integer.parseInt(st.nextToken())+10000000];

    // get M and count cards
    M = Integer.parseInt(br.readLine());
    st = new StringTokenizer(br.readLine(), " ");
    for (int i = 0; i < M; i++){
      if (cards[Integer.parseInt(st.nextToken())+10000000] != 0)
        sb.append(1+" ");
      else sb.append(0+" ");  
    }

    // print answer and end program
    System.out.print(sb);
    br.close();
    return;
  }
}
