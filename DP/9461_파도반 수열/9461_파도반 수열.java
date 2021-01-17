import java.util.Scanner;


public class Main {
  public static void main(String[] args) {
    // set needed components
    Scanner read = new Scanner(System.in);
    int t, n;

    // get t
    t = Integer.parseInt(read.nextLine());

    // find answer
    for (int i = 0; i < t; i++){
      n = Integer.parseInt(read.nextLine());
      // n: 1, 2, 3
      if (1 <= n && n <=3)
        System.out.println(1);
      // n: 4, 5, 6...  
      else{
        long answer = padovan(n);
        System.out.println(answer);
      }  
    }

    // end program
    read.close();
  }

  // padovan function. n >= 4
  public static long padovan(int n){
    // set memo
    long[] pado = new long[n+1];
    for (int i = 0; i < 4; i++) pado[i] = 1;
    for (int i = 4; i <= n; i++) pado[i] = 0;

    // calculation
    for (int i = 4; i <= n; i++){
      pado[i] = pado[i-2] + pado[i-3];
    }

    return pado[n];
  }
}
