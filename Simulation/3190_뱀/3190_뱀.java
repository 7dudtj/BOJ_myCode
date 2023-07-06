import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.Queue;
import java.util.LinkedList;

public class Main {
  // set needed variables
  private static int N, K, L;
  private static int[][] map;

  public static void main(String[] args) throws IOException{
    // set needed components
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    Queue<Snake> q = new LinkedList<Snake>();
    StringTokenizer st;
    N = Integer.parseInt(br.readLine());
    K = Integer.parseInt(br.readLine());
    map = new int[N+2][N+2];
    int curTime = 0;
    int[] wayi = {0,-1,0,1};
    int[] wayj = {1,0,-1,0};
    int[] turnTime;
    String[] turnDir;
    int turncount = 0;
    int curway = 0, curi = 1, curj = 1;

    // fill wall
    for (int i = 0; i < N+2; i++){
      map[0][i] = 9;
      map[N+1][i] = 9;
      map[i][0] = 9;
      map[i][N+1] = 9;
    }

    // get and fill apple
    for (int i = 0; i < K; i++){
      st = new StringTokenizer(br.readLine(), " ");
      int a = Integer.parseInt(st.nextToken());
      int b = Integer.parseInt(st.nextToken());
      map[a][b] = 2;
    }

    // get L and direction
    L = Integer.parseInt(br.readLine());
    turnTime = new int[L];
    turnDir = new String[L];
    for (int i = 0; i < L; i++){
      st = new StringTokenizer(br.readLine(), " ");
      turnTime[i] = Integer.parseInt(st.nextToken());
      turnDir[i] = st.nextToken();
    }

    // do game
    Snake start = new Snake(1,1);
    q.add(start);
    map[1][1] = 1;
    while (q.size() != 0){
      curTime++;
      // meets wall
      if (map[curi+wayi[curway]][curj+wayj[curway]] == 9){
        System.out.println(curTime);
        br.close();
        return;
      }
      // meets empty place
      else if (map[curi+wayi[curway]][curj+wayj[curway]] == 0){
        Snake s = q.poll();
        map[s.icor][s.jcor] = 0;
        q.add(new Snake(curi+wayi[curway], curj+wayj[curway]));
        map[curi+wayi[curway]][curj+wayj[curway]] = 1;
        curi += wayi[curway];
        curj += wayj[curway];
      }
      // meets apple
      else if (map[curi+wayi[curway]][curj+wayj[curway]] == 2){
        q.add(new Snake(curi+wayi[curway], curj+wayj[curway]));
        map[curi+wayi[curway]][curj+wayj[curway]] = 1;
        curi += wayi[curway];
        curj += wayj[curway];
      }
      // meets itself
      else if (map[curi+wayi[curway]][curj+wayj[curway]] == 1){
        System.out.println(curTime);
        br.close();
        return;
      }

      // change direction
      if (turncount < L && curTime == turnTime[turncount]){
        if (turnDir[turncount].equals("D")){
          if (curway == 0) curway = 3;
          else curway--;
        }else{
          if (curway == 3) curway = 0;
          else curway++;
        }
        turncount++;        
      }
    }
  }
}

// Snake class
class Snake{
  int icor;
  int jcor;
  public Snake(int i, int j){
    icor = i;
    jcor = j;
  }
}