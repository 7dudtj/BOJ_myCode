import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.Arrays;

public class Main {
	public static void main(String args[]) throws IOException	{
    // set needed variables
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;
    int N = Integer.parseInt(br.readLine());
    int[] a = new int[N];
    int[] b = new int[N];
    int match = 0;

    // get data
    st = new StringTokenizer(br.readLine(), " ");
    for (int i = 0; i < N; i++) a[i] = Integer.parseInt(st.nextToken());
    st = new StringTokenizer(br.readLine(), " ");
    for (int i = 0; i < N; i++) b[i] = Integer.parseInt(st.nextToken());

    // sort data
    Arrays.sort(a);
    Arrays.sort(b);

    // search data
    int i = 0, j = 0;
    while (i < N && j < N){
      if (a[i] == b[j]){
        match++;
        i++;
        j++;
      }else if (a[i] > b[j]){
        j++;
      }else{
        i++;
      }
    }

    // print answer and end program
    System.out.println(N-match);
    br.close();
    return;
  }
}
