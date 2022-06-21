import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {
  // set needed variables
  static int[] in;
  static int[] post;
  static int[] pos;

  public static void main(String[] args) throws IOException{
    // set needed components
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;
    int n = Integer.parseInt(br.readLine());
    in = new int[n];
    post = new int[n];
    pos = new int[n+1];

    // get inorder, get postorder, and set position
    st = new StringTokenizer(br.readLine(), " ");
    for (int i = 0; i < n; i++) in[i] = Integer.parseInt(st.nextToken());
    st = new StringTokenizer(br.readLine(), " ");
    for (int i = 0; i < n; i++) post[i] = Integer.parseInt(st.nextToken());
    for (int i = 0; i < n; i++) pos[in[i]] = i;

    // do process
    find(0, n-1, 0, n-1);

    // end program
    br.close();
    return;
  }  

  // find preorder function
  public static void find(int il, int ir, int pl, int pr){
    if (il > ir || pl > pr) return;
    int root = post[pr];
    System.out.print(root+" ");
    int rootidx = pos[root];
    int left = rootidx - il;
    find(il, rootidx-1, pl, pl+left-1);
    find(rootidx+1, ir, pl+left, pr-1);
  }
}

