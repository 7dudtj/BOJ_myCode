import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {
  public static void main(String[] args) throws IOException{
    // set needed components
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    double pi = 3.141592653589793238462643383279502884197169399375105820974944;
    StringTokenizer st = new StringTokenizer(br.readLine(), " ");
    double[] x = new double[3];
    double[] y = new double[3];
    double x_h = 0, y_h = 0;
    double sam = 0, x_answer = 0, y_answer = 0;;

    // get input
    for (int i = 0; i < 6; i++){
      if (i%2==0) x[i/2] = Double.parseDouble(st.nextToken());
      else y[i/2] = Double.parseDouble(st.nextToken());
    }

    // get sam
    sam = Math.abs((x[0]*y[1]+x[1]*y[2]+x[2]*y[0])-(x[1]*y[0]+x[2]*y[1]+x[0]*y[2]))/2;

    // get x_h and y_h
    x_h = (y[0]+y[1]+y[2])/3;
    y_h = (x[0]+x[1]+x[2])/3;

    // calculate answer
    x_answer = sam*2*pi*x_h;
    y_answer = sam*2*pi*y_h;

    // print answer and end program
    System.out.print(x_answer+" "+y_answer);
    br.close();
    return;
  }
}