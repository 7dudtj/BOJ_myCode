import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.lang.Math;
import java.util.Queue;
import java.util.LinkedList;

public class Main {
  // set needed static variables
  static int[] input;
  static int[] output;
  static int len;

  public static void main(String[] args) throws IOException{
    // set needed variables
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int k = Integer.parseInt(br.readLine());
    StringTokenizer st = new StringTokenizer(br.readLine(), " ");
    len = (int) Math.pow(2,k) - 1;
    input = new int[len+1];
    output = new int[len+1];
    for (int i = 1; i <= len; i++) input[i] = Integer.parseInt(st.nextToken());
    Node tree;

    // make tree
    tree = makeTree(new Node(input[len/2 + 1]), len/2 + 1, len);

    // level order
    levelOrder(tree);

    // print answer
    int j = 2;
    for (int i = 1; i <= len; i++){
      if (i != (j-1)){
        System.out.print(output[i]+" ");
      }else{
        j *= 2;
        System.out.println(output[i]);
      }
    }

    // end program
    br.close();
    return;
  }

  // make tree function
  private static Node makeTree(Node root, int cur, int child){
    if ((root == null) || (child == 0)) return null;
    int s = (((child/2)/2)+1);

    if (child != 1){
      root.left = makeTree(new Node(input[cur - s]), cur - s, child/2);
      root.right = makeTree(new Node(input[cur + s]), cur + s, child/2);
    }

    return root;
  }

  // level order function
  private static void levelOrder(Node root){
    Queue<Node> q = new LinkedList<>();
    Node t;
    int idx = 1;

    q.add(root);
    while (!q.isEmpty()){
      t = q.poll();
      output[idx] = t.value;
      idx++;
      if (t.left != null) q.add(t.left);
      if (t.right != null) q.add(t.right);
    }
  }
}

// Node class
class Node{
  // class variables
  int value;
  Node left;
  Node right;
  // constructor
  public Node(int v){
    value = v;
    left = null;
    right = null;
  }
}
