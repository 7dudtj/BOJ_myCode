import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
	public static void main(String args[]) throws IOException	{
    // set needed variables
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    int[] money = new int[n+1];
    int answer = 0;

    // if n <= 8
    if (n == 1) answer = -1;
    else if (n == 2) answer = 1;
    else if (n == 3) answer = -1;
    else if (n == 4) answer = 2;
    else if (n == 5) answer = 1;
    else if (n == 6) answer = 3;
    else if (n == 7) answer = 2;
    else if (n == 8) answer = 4;
    if (answer != 0){
      System.out.println(answer);
      br.close();
      return;
    }

    // n > 8
    // set dp
    money[1] = -1;
    money[2] = 1;
    money[3] = -1;
    money[4] = 2;
    money[5] = 1;
    money[6] = 3;
    money[7] = 2;
    money[8] = 4;

    // do dp
    for (int i = 9; i <= n; i++){
      if (i % 5 == 0) money[i] = i/5;
      else money[i] = Math.min(money[i-2], money[i-5]) + 1;
    }
    answer = money[n];

    // print answer and end program
    System.out.println(answer);
    br.close();
    return;
  }
}