import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.StringTokenizer;
import java.util.Collections;

public class Main {
  // set needed variables
  static int N, M;
  static int[][] map;
  static ArrayList<Integer> list = new ArrayList<>();

  public static void main(String[] args) throws IOException{
    // set needed components
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine(), " ");
    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());
    map = new int[N][M];

    // get map
    for (int i = 0; i < N; i++){
      st = new StringTokenizer(br.readLine(), " ");
      for (int j = 0; j < M; j++){
        map[i][j] = Integer.parseInt(st.nextToken());
      }
    }

    // do process
    hor();
    ver();
    cube();
    rotate1();
    rotate2();
    rotate3();
    rotate4();
    junc1();
    junc2();
    junc3();
    junc4();
    stair1();
    stair2();
    stair3();
    stair4();
    down();
    left();
    right();
    up();

    // sort list
    Collections.sort(list);

    // print answer and end program
    System.out.println(list.get(list.size()-1));
    br.close();
    return;
  }

  // hor
  public static void hor(){
    int sum;
    for (int i = 0; i < N; i++){
      for (int j = 3; j < M; j++){
        sum = 0; // reset sum
        for (int k = 0; k < 4; k++) sum += map[i][j-k]; // calculate sum
        list.add(sum); // get result
      }
    }
  }

  // ver
  public static void ver(){
    int sum;
    for (int i = 3; i < N; i++){
      for (int j = 0; j < M; j++){
        sum = 0;
        for (int k = 0; k < 4; k++) sum += map[i-k][j];
        list.add(sum);
      }
    }
  }

  // cube
  public static void cube(){
    int sum;
    for (int i = 1; i < N; i++){
      for (int j = 1; j < M; j++){
        sum = 0;
        sum = map[i][j]+map[i-1][j]+map[i][j-1]+map[i-1][j-1];
        list.add(sum);
      }
    }
  }

  // rotate1
  public static void rotate1(){
    int sum;
    for (int i = 2; i < N; i++){
      for (int j = 1; j < M; j++){
        sum = 0;
        sum = map[i][j]+map[i][j-1]+map[i-1][j-1]+map[i-2][j-1];
        list.add(sum);
      }
    }
  }

  // rotate2
  public static void rotate2(){
    int sum;
    for (int i = 1; i < N; i++){
      for (int j = 2; j < M; j++){
        sum = 0;
        sum = map[i][j-2]+map[i-1][j]+map[i-1][j-1]+map[i-1][j-2];
        list.add(sum);
      }
    }
  }

  // rotate3
  public static void rotate3(){
    int sum;
    for (int i = 2; i < N; i++){
      for (int j = 1; j < M; j++){
        sum = 0;
        sum = map[i][j]+map[i-1][j]+map[i-2][j]+map[i-2][j-1];
        list.add(sum);
      }
    }
  }

  // rotate4
  public static void rotate4(){
    int sum;
    for (int i = 1; i < N; i++){
      for (int j = 2; j < M; j++){
        sum = 0;
        sum = map[i][j]+map[i-1][j]+map[i][j-1]+map[i][j-2];
        list.add(sum);
      }
    }
  }

  // junc1
  public static void junc1(){
    int sum;
    for (int i = 2; i < N; i++){
      for (int j = 1; j < M; j++){
        sum = 0;
        sum = map[i][j]+map[i][j-1]+map[i-1][j]+map[i-2][j]; 
        list.add(sum);
      }
    }
  }

  // junc2
  public static void junc2(){
    int sum;
    for (int i = 1; i < N; i++){
      for (int j = 2; j < M; j++){
        sum = 0;
        sum = map[i][j]+map[i][j-1]+map[i][j-2]+map[i-1][j-2];
        list.add(sum);
      }
    }
  }

  // junc3
  public static void junc3(){
    int sum;
    for (int i = 2; i < N; i++){
      for (int j = 1; j < M; j++){
        sum = 0;
        sum = map[i-2][j]+map[i][j-1]+map[i-1][j-1]+map[i-2][j-1];
        list.add(sum);
      }
    }
  }

  // junc4
  public static void junc4(){
    int sum;
    for (int i = 1; i < N; i++){
      for (int j = 2; j < M; j++){
        sum = 0;
        sum = map[i][j]+map[i-1][j]+map[i-1][j-1]+map[i-1][j-2];
        list.add(sum);
      }
    }
  }

  // stair1
  public static void stair1(){
    int sum;
    for (int i = 2; i < N; i++){
      for (int j = 1; j < M; j++){
        sum = 0;
        sum = map[i][j]+map[i-1][j]+map[i-1][j-1]+map[i-2][j-1];
        list.add(sum);
      }
    }
  }

  // stair2
  public static void stair2(){
    int sum;
    for (int i = 1; i < N; i++){
      for (int j = 2; j < M; j++){
        sum = 0;
        sum = map[i][j-1]+map[i][j-2]+map[i-1][j]+map[i-1][j-1];
        list.add(sum);
      }
    }
  }

  // stair3
  public static void stair3(){
    int sum;
    for (int i = 1; i < N; i++){
      for (int j = 2; j < M; j++){
        sum = 0;
        sum = map[i][j]+map[i][j-1]+map[i-1][j-1]+map[i-1][j-2];
        list.add(sum);
      }
    }
  }

  // stair4
  public static void stair4(){
    int sum;
    for (int i = 2; i < N; i++){
      for (int j = 1; j < M; j++){
        sum = 0;
        sum = map[i-1][j]+map[i-2][j]+map[i][j-1]+map[i-1][j-1];
        list.add(sum);
      }
    }
  }

  // down
  public static void down(){
    int sum;
    for (int i = 1; i < N; i++){
      for (int j = 2; j < M; j++){
        sum = 0;
        sum = map[i][j-1]+map[i-1][j]+map[i-1][j-1]+map[i-1][j-2];
        list.add(sum);
      }
    }
  }

  // left
  public static void left(){
    int sum;
    for (int i = 2; i < N; i++){
      for (int j = 1; j < M; j++){
        sum = 0;
        sum = map[i][j]+map[i-1][j]+map[i-2][j]+map[i-1][j-1];
        list.add(sum);
      }
    }
  }

  // right
  public static void right(){
    int sum;
    for (int i = 2; i < N; i++){
      for (int j = 1; j < M; j++){
        sum = 0;
        sum = map[i-1][j]+map[i][j-1]+map[i-1][j-1]+map[i-2][j-1];
        list.add(sum);
      }
    }
  }

  // up
  public static void up(){
    int sum;
    for (int i = 1; i < N; i++){
      for (int j = 2; j < M; j++){
        sum = 0;
        sum = map[i][j]+map[i][j-1]+map[i][j-2]+map[i-1][j-1];
        list.add(sum);
      }
    }
  }
}
