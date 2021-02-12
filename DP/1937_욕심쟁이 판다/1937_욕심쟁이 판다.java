import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.List;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Arrays;

// buttom-up DP
public class Main {
  // set needed variables
  static int n;

  public static void main(String[] args) throws IOException{
    // set needed components
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    PriorityQueue<forest> pq = new PriorityQueue<forest>();
    StringTokenizer st;
    int[] dx = {0,1,0,-1};
    int[] dy = {-1,0,1,0};
    int[][] map;
    int[][] info; 
    forest f;

    // get n
    n = Integer.parseInt(br.readLine());

    // set map and info
    map = new int[n][n];
    info = new int[n][n];

    // fill map and forest
    for (int i = 0; i < n; i++){
      st = new StringTokenizer(br.readLine(), " ");
      for (int j = 0; j < n; j++){
        map[i][j] = Integer.parseInt(st.nextToken());
        pq.add(new forest(i, j, map[i][j]));
      }
    }

    // do DP
    for (int i = 0; i < n*n; i++){
      f = pq.poll();
      ArrayList<Integer> list = new ArrayList<Integer>();
      for (int k = 0; k < 4; k++){
        // get data
        if (inRange(f.icor+dx[k], f.jcor+dy[k])){
          if (map[f.icor+dx[k]][f.jcor+dy[k]] > f.value){
            list.add(info[f.icor+dx[k]][f.jcor+dy[k]]);
          }
        }
      }

      // check data
      if (list.size() == 0) info[f.icor][f.jcor] = 1;
      else{
        Collections.sort(list);
        info[f.icor][f.jcor] = list.get(list.size() - 1) + 1;
      }
    }

    // abstract answer
    int[] answer = new int[n*n];
    for (int i = 0; i < n; i++){
      for (int j = 0; j < n; j++){
        answer[i*n+j] = info[i][j];
      }
    }
    Arrays.sort(answer);

    // print answer and end program
    System.out.println(answer[n*n-1]);
    br.close();
    return;
  }

  // check if neighbor is in range
  public static boolean inRange(int i, int j){
    if (i < 0 || i >= n || j < 0 || j >= n) return false;
    return true;
  }
}

// forest class
class forest implements Comparable<forest>{
  // variables
  int icor;
  int jcor;
  int value;
  // constructor
  public forest (int i, int j, int v){
    icor = i;
    jcor = j;
    value = v;
  }
  // desc
  public int compareTo(forest f){
    return f.value-this.value;
  }
}
