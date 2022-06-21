import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
	public static void main(String args[]) throws Exception	{
    // set needed variables
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String s = br.readLine();

    // len 1
    if (s.length() == 1){
      System.out.println(s+" "+s);
      return;
    }

    // len 2
    if (s.length() == 2){
      int first = Integer.parseInt(s.substring(0,1));
      int second = Integer.parseInt(s.substring(1,2));

      if (first + 1 == second){
        System.out.println(first+" "+second);
        return;
      }else{
        System.out.println(s+" "+s);
        return;
      }
    }

    // len >= 3
    for (int i = 1; i <= 3; i++){
      for (int j = 1; j <= 3; j++){
        int start = Integer.parseInt(s.substring(0, i));
        int end = Integer.parseInt(s.substring(s.length()-j, s.length()));

        if (s.equals(stringBuild(start, end))){
          System.out.print(start+" "+end);
          return;
        }
      }
    }
  }

  // string build function
  private static String stringBuild(int s, int e){
    String st = "";

    for (int i = s; i <= e; i++){
      st += Integer.toString(i);
    }

    return st;
  }
}