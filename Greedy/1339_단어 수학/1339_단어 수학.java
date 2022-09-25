import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Arrays;

public class Main {
  public static void main(String[] args) throws IOException{
    // set needed components
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());
    String[] s = new String[N];
    int[] alpha = new int[26];

    // get s
    for (int i = 0; i < N; i++) s[i] = br.readLine();

    // do main process
    for (int i = 0; i < N; i++){
      int temp = (int)Math.pow(10, s[i].length()-1);
      for (int j = 0; j < s[i].length(); j++){
        alpha[(int)s[i].charAt(j)-65] += temp;
        temp /= 10;
      }
    }

    // sort alpha
    Arrays.sort(alpha);

    // find answer
    int idx = 9;
    int sum = 0;
    for (int i = alpha.length-1; i >= 0; i--){
      if (alpha[i] == 0) break;
      sum += alpha[i] * idx;
      idx--;
    }

    // print answer and end program
    System.out.println(sum);
    br.close();
    return;
  }
}
