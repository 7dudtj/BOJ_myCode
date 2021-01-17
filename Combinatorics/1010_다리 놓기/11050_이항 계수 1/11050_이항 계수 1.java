import java.util.Scanner;


public class Main {
  public static void main(String[] args) {
    // set needed components
    Scanner read = new Scanner(System.in);
    String s;
    int pos, n, k;

    // get data
    s = read.nextLine();
    pos = s.indexOf(" ");
    n = Integer.parseInt(s.substring(0,pos));
    k = Integer.parseInt(s.substring(pos+1));
    read.close();

    // do process
    int u = fact(n);
    int d1 = fact(k);
    int d2 = fact(n-k);
    int answer = u / (d1 * d2);

    // print answer
    System.out.print(answer);
  }

  public static int fact(int i){
    int[] memo = new int[i+1];
    for (int j = 2; j <= i; j++) memo[j] = 0; 
    memo[0] = 1; 
    if (i != 0) memo[1] = 1;
    for (int n = 2; n <= i; n++)
      memo[n] = n * memo[n-1];
    return memo[i];  
  }
}
