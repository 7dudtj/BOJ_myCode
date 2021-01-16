import java.util.Scanner;
import java.util.Arrays;

public class Main {
  public static void main(String[] args) {
    // set needed components
    Scanner read = new Scanner(System.in);
    int N, M;
    int[] n, m;
    String s;
    String[] ns, ms;

    // get data
    N = Integer.parseInt(read.nextLine());
    ns = read.nextLine().split("\\s");
    n = new int[N];
    for (int i = 0; i < N; i++)
      n[i] = Integer.parseInt(ns[i]);
    M = Integer.parseInt(read.nextLine());
    ms = read.nextLine().split("\\s");
    m = new int[M];
    for (int i = 0; i <M; i++)
      m[i] = Integer.parseInt(ms[i]);
    read.close();

    // sort n
    Arrays.sort(n);

    // do binary search
    for (int i = 0; i < M; i++){
      int target = m[i];
      int answer = doBinarySearch(n, target);
      System.out.println(answer);
    }
    return;
  }

  // binary search function
  public static int doBinarySearch(int[] n, int target){
    int mid;
    int left = 0;
    int right = n.length-1;

    while (right >= left){
      mid = (left+right)/2;

      // find target
      if (target == n[mid])
        return 1;
      // target is bigger or smaller 
      if (target < n[mid])
        right = mid - 1;
      else
        left = mid + 1;
    }

    // not find target
    return 0;
  }
}
