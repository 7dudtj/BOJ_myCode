import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {
  public static void main(String[] args) throws IOException{
    // set needed variables
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine(), " ");
    int[] list = {100, 100, 200, 200, 300, 300, 400, 400, 500};
    int[] score = new int[9];
    int sum = 0;

    // get score
    for (int i = 0; i < 9; i++){
      score[i] = Integer.parseInt(st.nextToken());
      sum += score[i];
    }

    // check hacker
    for (int i = 0; i < 9; i++){
      if (score[i] > list[i]){
        System.out.print("hacker");
        return;
      }
    }

    // check sum
    if (sum >= 100) System.out.print("draw");
    else System.out.print("none");

    // end program
    br.close();
    return;
  }
}
