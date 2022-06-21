import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.Arrays;
import java.util.Comparator;

public class Main {
	public static void main(String args[]) throws IOException	{
    // set needed variables
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());
    data[] list = new data[N];
    StringBuilder sb = new StringBuilder();

    // get list
    StringTokenizer st = new StringTokenizer(br.readLine(), " ");
    for (int i = 0; i < N; i++) 
      list[i] = new data(Integer.parseInt(st.nextToken()), 0, i);

    // sort by num
    Arrays.sort(list, new Comparator<data>(){
      @Override
      public int compare(data d1, data d2){
        return d1.num - d2.num;
      }
    });

    // find comp
    int c = 0;
    list[0].comp = 0;
    for (int i = 1; i < N; i++){
      if (list[i].num != list[i-1].num) c++;
      list[i].comp = c;
    }

    // sort by idx
    Arrays.sort(list, new Comparator<data>(){
      @Override
      public int compare(data d1, data d2){
        return d1.idx - d2.idx;
      }
    });

    // get answer, print answer, and end program
    for (int i = 0; i < N; i++) sb.append(list[i].comp+" ");
    System.out.print(sb);
    br.close();
    return;
  }
}

// pair class
class data{
  int num;
  int comp;
  int idx;
  public data(int n, int c, int i){
    num = n;
    comp = c;
    idx = i;
  }
}