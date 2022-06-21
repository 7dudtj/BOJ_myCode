import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {
  public static void main(String[] args) throws IOException{
    // set needed components
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine(), " "); br.close();
    int D = Integer.parseInt(st.nextToken());
    int K = Integer.parseInt(st.nextToken());
    int[] pibo = new int[29];
    int[][] data = new int[31][2];
    int a, b, A=0, B=0;

    // get pibo
    pibo[0] = 1;
    pibo[1] = 1;
    for (int i = 2; i <= 28; i++){
      pibo[i] = pibo[i-1] + pibo[i-2];
    }

    // get data
    for (int i = 3; i <= 30; i++){
      data[i][0] = pibo[i-3];
      data[i][1] = pibo[i-2];
    }

    // get a and b
    a = data[D][0];
    b = data[D][1];

    // aA+bB = K, A,B = ?
    for (A = 1; A <= 50000; A++){
      for (B = A; B <= 50000; B++){
        // find answer
        if (a*A+b*B == K){
          // print answer and end program
          System.out.println(A);
          System.out.print(B);
          return;
        }

        // input is big
        if (a*A+b*B > K){
          break;
        }
      }
    }
    return;
  }
}