import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main{
  public static void main(String[] args) throws IOException{
    // set needed variables
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());
    int answer = 0;
    int left = 1;
    int right = 1;
    int sum = 1;

    // find answer by two pointers
    while (left <= right && right <= N){
      // case 1. find answer
      if (sum == N){
        answer++;
        sum += (++right);
      }
      // case 2. sum < N
      else if (sum < N){
        sum += (++right);
      }
      // case 3. sum > N
      else {
        sum -= (left++);
      }
    }

    // print answer and end program
    System.out.println(answer);
    br.close();
    return;
  }
}
