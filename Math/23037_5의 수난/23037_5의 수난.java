import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
public class Main {
	public static void main(String args[]) throws IOException	{
    // set needed variables
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String input = br.readLine();
    int one = Integer.parseInt(input.substring(0,1));
    int two = Integer.parseInt(input.substring(1,2));
    int three = Integer.parseInt(input.substring(2,3));
    int four = Integer.parseInt(input.substring(3,4));
    int five = Integer.parseInt(input.substring(4,5));

    int answer = mulfive(one) + mulfive(two) + mulfive(three)
    + mulfive(four) + mulfive(five);

    System.out.println(answer);
    br.close();
    return;
  }

  // multiply 5 times function
  private static int mulfive(int a){
    return a*a*a*a*a;
  }
}