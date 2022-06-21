import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
  static double pi = 3.141592653589793238462643383279502884197169399375105820974944;
	public static void main(String args[]) throws IOException	{
    // set needed variables
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    double R = Double.parseDouble(br.readLine());

    // print answer and end program
    System.out.println(getU1(R));
    System.out.println(getT1(R));
    br.close();
    return;
  }

  // get U1
  private static String getU1(double r){
    return String.format("%.6f", r*r*pi);
  }

  // get T1
  private static String getT1(double r){
    return String.format("%.6f", 2*r*r);
  }
}