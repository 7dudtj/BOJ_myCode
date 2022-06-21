import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.lang.Math;

public class Main {
  // set static variables
  public static void main(String[] args) throws IOException{
    // set needed components
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine(), " ");
    int D, h, w;
    D = Integer.parseInt(st.nextToken());
    h = Integer.parseInt(st.nextToken());
    w = Integer.parseInt(st.nextToken());

    // calculate rate
    double rate = D / Math.sqrt(Math.pow(h, 2) + Math.pow(w, 2));

    // print answer and end program
    System.out.print((int)Math.floor(rate*h)+" "+(int)Math.floor(rate*w));
    br.close();
    return;
  }
}