import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {
  // set static variables
  static int answer;
	public static void main(String args[]) throws IOException	{
    // set needed variables
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine(), " ");
    int N = Integer.parseInt(st.nextToken());
    int r = Integer.parseInt(st.nextToken());
    int c = Integer.parseInt(st.nextToken());
    int from = 0, n = (int)Math.pow(2,N), to = n*n-1;

    // do divide and conquer
    search(from, to, r, c, n);

    // print answer and end program
    System.out.print(answer);
    br.close();
    return;
  }

  // search function
  private static void search(int from, int to, int r, int c, int n){
    // find answer
    if (from == to) {
      answer = to;
      return;
    }

    // if n == 1
    if (n == 1){
      if (r == 0 && c == 0) answer = from;
      else if (r == 0 && c == 1) answer = from+1;
      else if (r == 1 && c == 0) answer = from+2;
      else answer = from+3;
      return;
    }

    // 1st
    if (r < n/2 && c < n/2){
      search(from, from + (n/2)*(n/2) - 1, r, c, n/2);
    }
    // 2nd
    else if (r < n/2 && c >= n/2){
      search(from + (n/2)*(n/2), from + 2*(n/2)*(n/2) - 1, r, c - n/2, n/2);
    }
    // 3rd
    else if (r >= n/2 && c < n/2){
      search(from + 2*(n/2)*(n/2), from + 3*(n/2)*(n/2)-1, r - n/2, c, n/2);
    }
    // 4th
    else{
      search(from + 3*(n/2)*(n/2), from + 4*(n/2)*(n/2)-1, r - n/2, c - n/2, n/2);
    }
  }
}