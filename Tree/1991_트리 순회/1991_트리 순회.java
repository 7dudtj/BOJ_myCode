import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
  // set needed variables
  static Node[] list;

  public static void main(String[] args) throws IOException{
    // set needed components
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;
    int N = Integer.parseInt(br.readLine());
    BinaryTree bt = new BinaryTree();
    char data, left, right;
    list = new Node[N];
    Node leftdata, rightdata;

    // get Nodes
    for (int i = 0; i < N; i++){
      st = new StringTokenizer(br.readLine(), " ");
      data = st.nextToken().charAt(0);
      left = st.nextToken().charAt(0);
      right = st.nextToken().charAt(0);
      if (left == '.') leftdata = new Node('x', null, null);
      else leftdata = new Node(left, null, null);
      if (right == '.') rightdata = new Node('x', null, null);
      else rightdata = new Node(right, null, null);
      Node n = new Node(data, leftdata, rightdata);
      list[(int)n.getKey() - 65] = n;
    }

    // make BinaryTree
    bt.setRoot(list[0]);
    makeTree(bt.getRoot());

    // show order
    bt.showOrder();

    // end program
    br.close();
    return;
    

    /*
    // for test
    for (int i = 0; i < N; i++){
      System.out.println((char)(i+65)+": "+list[i].getKey()+", left: "+list[i].getLeft().getKey()+", right: "+list[i].getRight().getKey());
    }
    */
  }
  // make tree function
  public static void makeTree(Node root){

    if (root.getLeft().getKey() != 'x'){
      root.setLeft(list[(int)root.getLeft().getKey()-65]);
      makeTree(root.getLeft());
    }
    if (root.getRight().getKey() != 'x'){
      root.setRight(list[(int)root.getRight().getKey()-65]);
      makeTree(root.getRight());
    }
  }
}

// Node class
class Node{
  private char item;
  private Node left;
  private Node right;
  // 노드 생성자
  public Node(char newItem, Node lt, Node rt){
    item = newItem; left = lt; right = rt;
  }
  public char getKey(){return item;}
  public Node getLeft(){return left;}
  public Node getRight(){return right;}
  public void setKey(char newItem) {item = newItem;}
  public void setLeft(Node lt) {left = lt;}
  public void setRight(Node rt) {right = rt;}
}

// BinaryTree class
class BinaryTree{
  private Node root;
  // 트리 생성자
  public BinaryTree(){root = null;}
  public Node getRoot(){return root;}
  public void setRoot(Node newRoot){root = newRoot;}
  public boolean isEmpty(){return root == null;}
  // 전위순회
  public void preorder(Node n){
    if (n.getKey() != 'x'){
      System.out.print(n.getKey()); // 노드 n 방문
      preorder(n.getLeft()); // n의 왼쪽 서브트리를 순회하기 위해
      preorder(n.getRight()); // n의 오른쪽 서브트리를 순회하기 위해
    }
  }
  // 중위순회
  public void inorder(Node n){
    if (n.getKey() != 'x'){
      inorder(n.getLeft()); // n의 왼쪽 서브트리를 순회하기 위해
      System.out.print(n.getKey()); // 노드 n 방문
      inorder(n.getRight()); // n의 오른쪽 서브트리를 순회하기 위해
    }
  }
  // 후위순회
  public void postorder(Node n){
    if (n.getKey() != 'x'){
      postorder(n.getLeft()); // n의 왼쪽 서브트리를 순회하기 위해
      postorder(n.getRight()); // n의 오른쪽 서브트리를 순회하기 위해
      System.out.print(n.getKey()); // 노드 n 방문
    }
  }
  // 전위, 중위, 후위, 레벨순회 결과 보기
  public void showOrder(){
    preorder(root); System.out.println();
    inorder(root); System.out.println();
    postorder(root); System.out.println();
  }
}
