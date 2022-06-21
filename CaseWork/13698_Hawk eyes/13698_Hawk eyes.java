import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
  // set static variables
  static int[] ball = new int[5];
	public static void main(String args[]) throws IOException	{
    // set needed variables
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    ball[1] = 0;
    ball[2] = 10;
    ball[3] = 20;
    ball[4] = 100;
    String input = br.readLine();

    // do main process
    for (int i = 0; i < input.length(); i++){
      String code = input.substring(i, i+1);

      if (code.equals("A")){
        swap(1,2);
      }else if (code.equals("B")){
        swap(1,3);
      }else if (code.equals("C")){
        swap(1,4);
      }else if (code.equals("D")){
        swap(2,3);
      }else if (code.equals("E")){
        swap(2,4);
      }else {
        swap(3,4);
      }
    }

    // find answer, print answer, and end program
    int small = 0, big = 0;
    for (int i = 1; i <= 4; i++){
      if (ball[i] == 0) small = i;
      if (ball[i] == 100) big = i;
    }
    System.out.println(small);
    System.out.println(big);
    br.close();
    return;
  }

  // swap function
  private static void swap(int a, int b){
    int tmp = ball[b];
    ball[b] = ball[a];
    ball[a] = tmp;
  }
}