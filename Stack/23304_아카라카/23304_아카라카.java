import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.ArrayDeque;

public class Main {
	public static void main(String args[]) throws IOException	{
    // set needed variables
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String input = br.readLine();

    // find answer, print answer, and end program
    if (isAP(input)){
      System.out.println("AKARAKA");
    }else System.out.println("IPSELENTI");
    br.close();
    return;
  }

  // check akaraka palindrome function
  private static boolean isAP(String s){
    if (s.length() == 1) return true;

    if (!isP(s)) return false;

    int sublen = s.length()/2;

    if (!isAP(s.substring(0, sublen))) return false;

    return true;
  }

  // check palindrome function
  private static boolean isP(String s){
    if (s.length() == 1) return true;

    ArrayDeque<String> ad = new ArrayDeque<>();

    // push stack
    for (int i = 0; i < s.length() / 2; i++){
      ad.push(s.substring(i,i+1));
    }

    // pop and match
    int from;
    String data;
    if (s.length()%2 == 0) from = s.length() / 2;
    else from = (s.length() / 2) + 1;
    for (int i = from; i < s.length(); i++){
      data = ad.pop();
      if (!data.equals(s.substring(i,i+1))) return false;
    }
    return true;
  }
}
