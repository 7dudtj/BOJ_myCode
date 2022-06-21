import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {
  public static void main(String[] args) throws IOException{
    // set needed components
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int T = Integer.parseInt(br.readLine());

    // do T times
    for (int i = 1; i <= T; i++){
      // print answer
      System.out.println("Material Management "+i);
      System.out.println("Classification ---- End!");

      // get rid of dummy data
      int N = Integer.parseInt(br.readLine());
      br.readLine();
      for (int j = 0; j < N; j++) br.readLine();
    }
  }
}