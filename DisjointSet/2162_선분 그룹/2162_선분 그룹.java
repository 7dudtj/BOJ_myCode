import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.Arrays;

public class Main {
  // set static variables
  static double[][] line;
  static int[] list;
	public static void main(String args[]) throws IOException	{
    // set needed variables
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;
    int N = Integer.parseInt(br.readLine());
    line = new double[N][4];
    list = new int[N];
    for (int i = 0; i < N; i++) list[i] = i;

    // get line
    for (int i = 0; i < N; i++){
      st = new StringTokenizer(br.readLine(), " ");
      for (int j = 0; j < 4; j++){
        line[i][j] = Double.parseDouble(st.nextToken());
      }
    }

    // do main process
    for (int i = 0; i < N; i++){
      for (int j = 0; j < N; j++){
        if (i == j) continue;

        int ip = find(i);
        int jp = find(j);

        if (ip != jp){
          if (intersect(i, j)){
            union(find(i), find(j));
          }
        }
      }
    }

    // find number of group, and size of biggest group
    int nog = 1, sobg;
    Arrays.sort(list);
    int standard = list[0];
    for (int i = 1; i < N; i++){
      if (list[i] != standard) {
        nog++;
        standard = list[i];
      }  
    }
    int[] groupList = new int[N];
    for (int i = 0; i < N; i++){
      groupList[list[i]]++;
    }
    Arrays.sort(groupList);
    sobg = groupList[N-1];

    // print answer and end program
    System.out.println(nog);
    System.out.println(sobg);
    br.close();
    return;
  }

  // union function
  private static void union(int a, int b){
    if (a < b) list[b] = a;
    else list[a] = b;
  }

  // find function
  private static int find(int v){
    if (list[v] == v) return v;

    return list[v] = find(list[v]);
  }

  // check line intersection function
  private static boolean intersect(int i, int j){
    double a = ccw(line[i][0], line[i][2], line[j][2], 
    line[i][1], line[i][3], line[j][3]);
    double b = ccw(line[i][0], line[i][2], line[j][0],
    line[i][1], line[i][3], line[j][1]);
    double c = ccw(line[j][2], line[j][0], line[i][0],
    line[j][3], line[j][1], line[i][1]);
    double d = ccw(line[j][2], line[j][0], line[i][2],
    line[j][3], line[j][1], line[i][3]);

    if (a==0&&b==0&&c==0&&d==0){
      if (check(line[i][0], line[i][2], line[i][1],
      line[i][3], line[j][2], line[j][3]) || 
      check(line[i][0], line[i][2], line[i][1], 
      line[i][3], line[j][0], line[j][1])){
        return true;
      }else if (check(line[j][0], line[j][2], line[j][1],
      line[j][3], line[i][2], line[i][3]) || 
      check(line[j][0], line[j][2], line[j][1],
      line[j][3], line[i][0], line[i][1])){
        return true;
      }else return false;
    }
    else if (a*b <= 0 && c*d <= 0) return true;
    else return false;
  }

  // ccw function
  private static double ccw(double x1, double x2, double x3, double y1, double y2, double y3){
    double a = (x1*y2+x2*y3+x3*y1) - (x2*y1+x3*y2+x1*y3);
    if (a > 0) return 1;
    else if (a == 0) return 0;
    else return -1;
  }

  // line and point check function
  private static boolean check(double x1, double x2, double y1, double y2, double xa, double ya){
    // sort points
    if (x1 >= x2){
      double tmp = x1;
      x1 = x2;
      x2 = tmp;
    }
    if (y1 >= y2){
      double tmp = y1;
      y1 = y2;
      y2 = tmp;
    }

    // check
    if ((x1 <= xa && xa <= x2) && (y1 <= ya && ya <= y2)) return true;
    else return false;
  }
}