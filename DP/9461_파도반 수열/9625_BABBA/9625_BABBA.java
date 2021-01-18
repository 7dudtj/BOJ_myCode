import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    // set needed components
    Scanner read = new Scanner(System.in);
    int k, a = 0, b = 0;
    String kanswer;

    // get k
    k = Integer.parseInt(read.nextLine());

    // print answer
    baba(k);

    // end program
    read.close();
    return;
  }

  public static void baba(int k){
    // set memo
    int[] amemo = new int[k+1];
    int[] bmemo = new int[k+1];
    amemo[0] = 1; amemo[1] = 0;
    bmemo[0] = 0; bmemo[1] = 1;

    // calculation
    for (int i = 2; i <= k; i++){
      amemo[i] = amemo[i-2] + amemo[i-1];
      bmemo[i] = bmemo[i-2] + bmemo[i-1];
    }

    // print
    System.out.println(amemo[k]+" "+bmemo[k]);
  }
}
