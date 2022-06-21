import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {
	public static void main(String args[]) throws IOException	{
    // set needed variables
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine(), " ");
    int N = Integer.parseInt(st.nextToken());
    int M = Integer.parseInt(st.nextToken());
    char[][] map = new char[N][M];
    long answer = N*M;
    int[][] dp = new int[N][M];

    // get map
    for (int i = 0; i < N; i++){
      map[i] = br.readLine().toCharArray();
    }

    // set dp map
    for (int i = 1; i < N; i++){
      for (int j = 1; j < M; j++){
        if (map[i][j] == 'B'){
          if (map[i-1][j-1] == 'B' && map[i][j-1] == 'W' && map[i-1][j] == 'W'){
            dp[i][j] = 1;
            answer++;
          }
        } else{
          if (map[i-1][j-1] == 'W' && map[i][j-1] == 'B' && map[i-1][j] == 'B'){
            dp[i][j] = 1;
            answer++;
          }
        }
      }
    }

    // do dp
    for (int i = 2; i < N; i++){
      for (int j = 2; j < M; j++){
        if (dp[i][j] != 0){
          int a = dp[i][j];
          dp[i][j] = Math.min(dp[i-1][j-1], Math.min(dp[i-1][j], dp[i][j-1])) + 1;
          answer += (dp[i][j] - a);
        }
      }
    }

    // print answer and end program
    System.out.print(answer);
    br.close();
    return;
  }
}