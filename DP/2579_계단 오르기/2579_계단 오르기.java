import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

// buttom-up DP
public class Main {
  public static void main(String[] args) throws IOException{
    // set needed components
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    int[] v = new int[n+1];
    int[] a = new int[n+1];

    // error-handling
    if (n == 1) {
      System.out.println(br.readLine());
      br.close();
      return;
    }
    if (n == 2){
      System.out.println(Integer.parseInt(br.readLine())+Integer.parseInt(br.readLine()));
      br.close();
      return;
    }  

    // get v
    v[0] = 0;
    for (int i = 1; i <= n; i++){
      v[i] = Integer.parseInt(br.readLine());
    }

    // buttom-up DP
    a[0] = 0; a[1] = v[1]; a[2] = v[1] + v[2];
    for (int i = 3; i <= n; i++){
      a[i] = Math.max(a[i-2], a[i-3]+v[i-1]) + v[i];
    }

    // print answer and end program
    System.out.println(a[n]);
    br.close();
    return;
  }
}
