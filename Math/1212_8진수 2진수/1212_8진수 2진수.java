import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    // set needed component
    Scanner read = new Scanner(System.in);
    String s;
    int len;

    // get data
    s = read.nextLine();
    len = s.length();

    // do process
    if (s.substring(0,1).equals("0"))
      System.out.print("0");
    else if (s.substring(0,1).equals("1"))
      System.out.print("1");
    else if (s.substring(0,1).equals("2"))
      System.out.print("10");
    else if (s.substring(0,1).equals("3"))
      System.out.print("11");
    else if (s.substring(0,1).equals("4"))
      System.out.print("100");
    else if (s.substring(0,1).equals("5"))
      System.out.print("101");
    else if (s.substring(0,1).equals("6"))
      System.out.print("110");
    else
      System.out.print("111");              
    for (int i = 1; i < len; i++){
      if (s.substring(i,i+1).equals("0"))
        System.out.print("000");
      else if (s.substring(i,i+1).equals("1"))
        System.out.print("001");
      else if (s.substring(i,i+1).equals("2"))
        System.out.print("010");
      else if (s.substring(i,i+1).equals("3"))
        System.out.print("011");
      else if (s.substring(i,i+1).equals("4"))
        System.out.print("100");
      else if (s.substring(i,i+1).equals("5"))
        System.out.print("101");
      else if (s.substring(i,i+1).equals("6"))
        System.out.print("110");
      else
        System.out.print("111"); 
    }
  }
}
