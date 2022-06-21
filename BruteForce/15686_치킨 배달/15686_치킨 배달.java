import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.ArrayList;

public class Main {
  // set needed static variables
  static int N, M, len, answer = Integer.MAX_VALUE;
  static boolean[] check;
  static ArrayList<Loc> house = new ArrayList<>();
  static ArrayList<Loc> chicken = new ArrayList<>();

  public static void main(String[] args) throws IOException{
    // set needed variables
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine(), " ");
    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());
    int input;

    // make house and chicken list
    for (int i = 0; i < N; i++){
      st = new StringTokenizer(br.readLine(), " ");
      for (int j = 0; j < N; j++){
        input = Integer.parseInt(st.nextToken());
        // get house
        if (input == 1){
          house.add(new Loc(i, j));
        }
        // get chicken
        if (input == 2){
          chicken.add(new Loc(i, j));
        }
      }
    }

    // make chicken check
    len = chicken.size();
    check = new boolean[len];

    // do combination
    comb(0,0);

    // print answer and end program
    System.out.println(answer);
    br.close();
    return;
  }

  // combination function
  private static void comb(int start, int depth){
    // choose r chicken
    if (depth == M){
      answer = Math.min(answer, getMin());
      return;
    }

    // do backtracking
    for (int i = start; i < len; i++){
      check[i] = true;
      comb(i + 1, depth + 1);
      check[i] = false;
    }
  }

  // get city's chicken distance
  private static int getMin(){
    int sum = 0, tmp;
    for (Loc h: house){
      tmp = 2 * N;
      for (int i = 0; i < len; i++){
        if (!check[i]) continue;
        tmp = Math.min(tmp, getDis(h, chicken.get(i)));
      }
      sum += tmp;
      if (sum > answer) return sum;
    }
    return sum;
  }

  // get distance function
  private static int getDis(Loc a, Loc b){
    return Math.abs(a.iloc - b.iloc) + Math.abs(a.jloc - b.jloc);
  }
}

// Loc class
class Loc{
  // class variables
  int iloc;
  int jloc;
  // class constructor
  public Loc(int i, int j){
    iloc = i;
    jloc = j;
  }
}
