import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    // set needed component
    int[] mush = new int[11];
    mush[10] = 0;
    Scanner read = new Scanner(System.in);
    String shuttle;
    int less = 0, much = 0;

    // get data
    for (int i = 0; i < 10; i++){
      shuttle = read.nextLine();
      mush[i] = Integer.parseInt(shuttle);
    }
    read.close();

    // do process
    less = mush[0];
    much = mush[0]+mush[1];
    for (int i = 1; i < 10; i++){
      if (less <= 100 && much >= 100){
        if (100-less >= much-100){
          System.out.print(much);
          return;
        }else{
          System.out.print(less);
          return;
        }
      }
      less += mush[i];
      much += mush[i+1];
    }
    System.out.print(much);
    return;
  }
}