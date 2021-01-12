import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    // set needed component
    Scanner read = new Scanner(System.in);
    int[] maxlist = new int[9];
    int[] loclist = new int[9];
    int realmax = Integer.MIN_VALUE;
    int realloc = -1;
    
    // do it for 9 line
    for (int i = 0; i < 9; i++){
      int max = Integer.MIN_VALUE;
      int[] map = new int[9];
      int loc = -1;
      String s = read.nextLine();
      String[] ss = s.split(" ");

      for (int j = 0; j < 9; j++){
        map[j] = Integer.parseInt(ss[j]);
      }
      for (int m = 0; m < 9; m++){
        if (map[m] > max){
          max = map[m];
          loc = m;
        }
      }
      maxlist[i] = max;
      loclist[i] = loc;
    }

    for (int i = 0; i < 9; i++){
      if (maxlist[i] > realmax){
        realmax = maxlist[i];
        realloc = i;
      }
    }

    // print answer
    System.out.println(realmax);
    System.out.print((realloc+1)+" "+(loclist[realloc]+1));
  }
}
