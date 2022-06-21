import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {
  static int N;
	public static void main(String args[]) throws IOException	{
    // set needed variables
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine(), " ");
    N = Integer.parseInt(st.nextToken());
    long B = Long.parseLong(st.nextToken());
    int[][] A = new int[N][N];
    
    // get matrix A
    for (int i = 0; i < N; i++){
      st = new StringTokenizer(br.readLine(), " ");
      for (int j = 0; j < N; j++){
        A[i][j] = Integer.parseInt(st.nextToken());
      }
    }

    // dot B times by divide and conquer
    A = dots(A, B);

    // print answer and end program
    for (int i = 0; i < N; i++){
      for (int j = 0; j < N; j++){
        System.out.print(A[i][j]+" ");
      } System.out.println();
    }
    br.close();
    return;
  }

  // matrix dot function
  private static int[][] dot(int[][] a, int[][] b){
    int[][] result = new int[N][N];

    for (int i = 0; i < N; i++){
      for (int j = 0; j < N; j++){
        for (int k = 0; k < N; k++){
          result[i][j] += a[i][k]*b[k][j];
        }
        result[i][j] %= 1000;
      }
    }
    
    return result;
  }

  // matrix dots function (recursive)
  private static int[][] dots(int[][] a, long b){
    if (b == 1) {
      for (int i = 0; i < N; i++){
        for (int j = 0; j < N; j++){
          a[i][j] %= 1000;
        }
      }
      return a;
    }  

    int[][] half = dots(a, b/2);
    if (b % 2 == 0) return dot(half, half);
    else return dot(dot(half, half), a);
  }
}