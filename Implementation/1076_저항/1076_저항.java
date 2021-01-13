import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    // set needed component
    String first, second, third;
    Scanner read = new Scanner(System.in);
    long answer = 0;

    // get data
    first = read.nextLine();
    second = read.nextLine();
    third = read.nextLine();
    read.close();

    // process first data
    if (first.equals("black"))
      answer = 0;
    else if (first.equals("brown"))
      answer = 10;
    else if (first.equals("red"))
      answer = 20;
    else if (first.equals("orange"))
      answer = 30;
    else if (first.equals("yellow"))
      answer = 40;
    else if (first.equals("green"))
      answer = 50;
    else if (first.equals("blue"))
      answer = 60;
    else if (first.equals("violet"))
      answer = 70;
    else if (first.equals("grey"))
      answer = 80;
    else
      answer = 90;                  

    // process second data
    if (second.equals("black"))
      answer += 0;
    else if (second.equals("brown"))
      answer += 1;
    else if (second.equals("red"))
      answer += 2;
    else if (second.equals("orange"))
      answer += 3;
    else if (second.equals("yellow"))
      answer += 4;
    else if (second.equals("green"))
      answer += 5;
    else if (second.equals("blue"))
      answer += 6;
    else if (second.equals("violet"))
      answer += 7;
    else if (second.equals("grey"))
      answer += 8;
    else
      answer += 9;

    // process third data
    if (third.equals("black"))
      answer *= 1;
    else if (third.equals("brown"))
      answer *= 10;
    else if (third.equals("red"))
      answer *= 100;
    else if (third.equals("orange"))
      answer *= 1000;
    else if (third.equals("yellow"))
      answer *= 10000;
    else if (third.equals("green"))
      answer *= 100000;
    else if (third.equals("blue"))
      answer *= 1000000;
    else if (third.equals("violet"))
      answer *= 10000000;
    else if (third.equals("grey"))
      answer *= 100000000;
    else
      answer *= 1000000000;

    // print answer
    System.out.print(answer);
  }
}
