import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Arrays;

public class Main {
  // set needed variables
  public static void main(String[] args) throws IOException{
    // set needed components
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int[] dwarf = new int[9];
    int sum = 0, iidx = 0, jidx = 0;

    // get nine dwarfs
    for (int i = 0; i < 9; i++){
      dwarf[i] = Integer.parseInt(br.readLine());
      sum += dwarf[i];
    }

    // find seven dwarfs
    for (int i = 0; i < 8; i++){
      for (int j = i+1; j < 9; j++){
        // find answer
        if ((dwarf[i] + dwarf[j]) == (sum - 100)){
          iidx = i;
          jidx = j;
        }
      }
    }

    // get rid of two fake dwarfs
    dwarf[iidx] = dwarf[jidx] = 0;

    // sor dwarfs
    Arrays.sort(dwarf);

    // print answer and end program
    for (int i = 2; i < 9; i++) System.out.println(dwarf[i]);
    br.close();
    return;
  }
}
