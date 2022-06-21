import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.Arrays;

public class Main {
  // set needed variables
  static String[][] map;

  public static void main(String[] args) throws IOException{
    // set needed components
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;
    int N, M, count = 0;
    int[] answer;
    String s;

    // get N and M
    st = new StringTokenizer(br.readLine(), " ");
    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());

    // set answer
    answer = new int[(N-7)*(M-7)];

    // get map
    map = new String[N][M];
    for (int i = 0; i < N; i++){
      s = br.readLine();
      for (int j = 0; j < M; j++){
        map[i][j] = s.substring(j,j+1);
      }
    }

    // do bruteforce
    for (int i = 0; i <= N-8; i++){
      for (int j = 0; j <= M-8; j++){
        answer[count] = find(i,j);
        count++;
      }
    }

    // sort arrays
    Arrays.sort(answer);

    // print answer and end program
    System.out.println(answer[0]);
    br.close();
    return;
  }

  public static int find(int ii, int jj){
    String[][] copy = new String[8][8];
    int ver1, ver2;

    for (int i = 0; i < 8; i++){
      for (int j = 0; j < 8; j++){
        copy[i][j] = map[ii+i][jj+j];
      }
    }

    ver1 = dover1(copy);
    ver2 = dover2(copy);

    if (ver1 < ver2) return ver1;
    else return ver2;
  }

  public static int dover1(String[][] copy){
    int answer = 0;

    for (int i = 0; i < 8; i++){
      for (int j = 0; j < 8; j++){
        if ((i % 2 == 0) && (j % 2 == 0)){
          if (copy[i][j].equals("B")) answer++;
        }else if ((i % 2 == 1) && (j % 2 == 1)){
          if (copy[i][j].equals("B")) answer++;
        }else if ((i % 2 == 0) && (j % 2 == 1)){
          if (copy[i][j].equals("W")) answer++;
        }else{
          if (copy[i][j].equals("W")) answer++;
        }
      }
    }

    return answer;
  }

  public static int dover2(String[][] copy){
    int answer = 0;

    for (int i = 0; i < 8; i++){
      for (int j = 0; j < 8; j++){
        if ((i % 2 == 0) && (j % 2 == 0)){
          if (copy[i][j].equals("W")) answer++;
        }else if ((i % 2 == 1) && (j % 2 == 1)){
          if (copy[i][j].equals("W")) answer++;
        }else if ((i % 2 == 0) && (j % 2 == 1)){
          if (copy[i][j].equals("B")) answer++;
        }else{
          if (copy[i][j].equals("B")) answer++;
        }
      }
    }

    return answer;
  }
}
