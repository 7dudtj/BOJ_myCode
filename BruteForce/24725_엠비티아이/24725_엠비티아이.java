import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {
  static char[][] map;
  static int N, M;
  static char[] list = {'I','S','T','J','I','S','T','P','I','S','F','J','I','S','F','P', 
                        'I','N','T','J','I','N','T','P','I','N','F','J','I','N','F','P',
                        'E','S','T','J','E','S','T','P','E','S','F','J','E','S','F','P', 
                        'E','N','T','J','E','N','T','P','E','N','F','J','E','N','F','P'};
  public static void main(String[] args) throws IOException{
    // set needed components
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine(), " ");
    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());
    map = new char[N][M];
    int answer = 0;

    // get map
    for (int i = 0; i < N; i++){
      map[i] = br.readLine().toCharArray();
    }

    // count answer
    for (int i = 0; i < N; i++){
      for (int j = 0; j < M; j++){
        answer += find(i, j);
      }
    }

    // print answer and end program
    System.out.print(answer);
    br.close();
    return;
  }

  // MBTI finding function
  private static int find(int i, int j){
    int sum = 0;
    boolean find = false;

    // 1. right
    if (j+3 < M){
      for (int l = 0; l < 64; l += 4){
        find = true;
        for (int m = 0; m < 4; m++){
          if (list[l+m] != map[i][j+m]){
            find = false;
            break;
          }
        }
        if (find) sum++;
      }
    }
    // 2. left
    if (j-3 >= 0){
      for (int l = 0; l < 64; l += 4){
        find = true;
        for (int m = 0; m < 4; m++){
          if (list[l+m] != map[i][j-m]){
            find = false;
            break;
          }
        }
        if (find) sum++;
      }
    }
    // 3. up
    if (i-3 >= 0){
      for (int l = 0; l < 64; l += 4){
        find = true;
        for (int m = 0; m < 4; m++){
          if (list[l+m] != map[i-m][j]){
            find = false;
            break;
          }
        }
        if (find) sum++;
      }
    }
    // 4. down
    if (i+3 < N){
      for (int l = 0; l < 64; l += 4){
        find = true;
        for (int m = 0; m < 4; m++){
          if (list[l+m] != map[i+m][j]){
            find = false;
            break;
          }
        }
        if (find) sum++;
      }
    }
    // 5. right-bottom
    if (i+3 < N && j+3 < M){
      for (int l = 0; l < 64; l += 4){
        find = true;
        for (int m = 0; m < 4; m++){
          if (list[l+m] != map[i+m][j+m]){
            find = false;
            break;
          }
        }
        if (find) sum++;
      }
    }
    // 6. right-top
    if (i-3 >= 0 && j+3 < M){
      for (int l = 0; l < 64; l += 4){
        find = true;
        for (int m = 0; m < 4; m++){
          if (list[l+m] != map[i-m][j+m]){
            find = false;
            break;
          }
        }
        if (find) sum++;
      }
    }
    // 7. left-bottom
    if (i+3 < N && j-3 >= 0){
      for (int l = 0; l < 64; l += 4){
        find = true;
        for (int m = 0; m < 4; m++){
          if (list[l+m] != map[i+m][j-m]){
            find = false;
            break;
          }
        }
        if (find) sum++;
      }
    }
    // 8. left-top
    if (i-3 >= 0 && j-3 >= 0){
      for (int l = 0; l < 64; l += 4){
        find = true;
        for (int m = 0; m < 4; m++){
          if (list[l+m] != map[i-m][j-m]){
            find = false;
            break;
          }
        }
        if (find) sum++;
      }
    }

    return sum;
  }
}