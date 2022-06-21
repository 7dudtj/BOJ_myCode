import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.lang.Math;
import java.util.Arrays;

public class Main {
  // set needed variables
  public static void main(String[] args) throws IOException{
    // set needed components
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());
    StringTokenizer st = new StringTokenizer(br.readLine(), " ");
    long[] list = new long[N];
    for (int i = 0; i < N; i++) list[i] = Long.parseLong(st.nextToken());
    Data[] data = new Data[N-1];

    // sort list
    Arrays.sort(list);

    // do search >> time: O(NlogN)
    // time: O(N)
    for (int i = 0; i < N-1; i++){
      int start = i+1;
      int end = N-1;
      long to = Long.parseLong("10000000000");
      
      // time: O(logN)
      while (start <= end){
        int mid = (start + end) / 2;

        // find 0
        if ((list[i] + list[mid]) == 0){
          to = list[mid];
          break;
        }
        // sum > 0
        else if ((list[i] + list[mid]) > 0){
          if (Math.abs(list[i] + to) > Math.abs(list[i] + list[mid])){
            to = list[mid];
          }
          end = mid - 1;
        }
        // sum < 0
        else{
          if (Math.abs(list[i] + to) > Math.abs(list[i] + list[mid])){
            to = list[mid];
          }
          start = mid + 1;
        }
      }

      // make Data
      data[i] = new Data((int)list[i], (int)to);
    }
    // sort data
    Arrays.sort(data);

    // print answer and end program
    System.out.println(data[0].one+" "+data[0].two);
    br.close();
    return;
  }
}

// Data class
class Data implements Comparable<Data>{
  // data
  int one;
  int two;
  int sum;
  // constructor
  public Data(int one, int two){
    this.one = one;
    this.two = two;
    this.sum = one + two;
  }
  // comparable
  @Override
  public int compareTo(Data d){
    return Math.abs(sum) - Math.abs(d.sum);
  }
}
