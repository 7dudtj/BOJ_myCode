import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.io.IOException;

public class Main {
  public static void main(String[] args) throws IOException{
    // set needed components
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());
    String[] arr = new String[N];

    // get data
    for (int i = 0; i < N; i++){
      arr[i] = br.readLine();
    }

    // sort data
    Arrays.sort(arr, new Comparator<String>(){
      public int compare(String s1, String s2){
        // words have same length
        if (s1.length() == s2.length()){
          return s1.compareTo(s2);
        }
        // words have different length
        else{
          return s1.length() - s2.length();
        }
      }
    });

    // set StringBuilder
    StringBuilder sb = new StringBuilder();

    // build answer
    sb.append(arr[0]).append('\n');
    // delete same words
    for (int i = 1; i < N; i++){
      if (!arr[i].equals(arr[i-1])){
        sb.append(arr[i]).append('\n');
      }
    }
    
    // print answer and end program
    System.out.println(sb);
    br.close();
    return;
  }
}
