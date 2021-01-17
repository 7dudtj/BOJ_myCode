import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    // set needed components
    Scanner read = new Scanner(System.in);
    int t, n, m, answer, pos;
    String shuttle;

    // get data
    t = Integer.parseInt(read.nextLine());
    for (int i = 0; i < t; i++){
      shuttle = read.nextLine();
      pos = shuttle.indexOf(" ");
      n = Integer.parseInt(shuttle.substring(0,pos));
      m = Integer.parseInt(shuttle.substring(pos+1));

      answer = comb(n,m);
      System.out.println(answer);
    }

    // end program
    read.close();
    return;
  }

  // combination function
  public static int comb(int n, int m){
    int answer = 1;

    for (int i = 0; i < n; i++){
      answer *= m;
      answer /= i+1;
      m--;
    }

    return answer;
  }
}
