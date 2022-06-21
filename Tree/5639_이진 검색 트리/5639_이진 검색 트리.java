import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
  // set needed variables
  public static void main(String[] args) throws IOException{
    // set needed components
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int data;
    String s = "";

    // get root Node and set Binary Tree
    data = Integer.parseInt(br.readLine());
    BinaryTree bt = new BinaryTree();
    bt.setRoot(new Node<Integer>(data, null, null));

    // get datas and make Tree
    while ((s = br.readLine()) != null && s.length() != 0){
      bt.setRoot(makeTree(bt.getRoot(), Integer.parseInt(s)));
    }

    // print answer
    bt.showOrder();

    // end program
    br.close();
    return;
  }

  // make tree class
  public static Node makeTree(Node<Integer> root, int newdata){
    // find location
    if (root == null){
      root = new Node(newdata, null, null);
      return root;
    }

    // check
    if (root.getKey() < newdata){
      root.setRight(makeTree(root.getRight(), newdata));
    }else if (root.getKey() > newdata){
      root.setLeft(makeTree(root.getLeft(), newdata));
    }

    return root;
  }
}

// Binary Search Tree class
class BinaryTree<Key extends Comparable<Key>>{
  private Node root;
  // 트리 생성자
  public BinaryTree(){root = null;}
  public Node getRoot(){return root;}
  public void setRoot(Node newRoot){root = newRoot;}
  public boolean isEmpty(){return root == null;}
  // 후위순회
  public void postorder(Node n){
    if (n != null){
      postorder(n.getLeft());
      postorder(n.getRight());
      System.out.println(n.getKey());
    }
  }
  // 후위순회 결과 보기
  public void showOrder(){
    postorder(root);
  }
}

// Node class
class Node<Key extends Comparable<Key>>{
  private Key item;
  private Node<Key> left;
  private Node<Key> right;
  // 노드 생성자
  public Node(Key newItem, Node lt, Node rt){
    item = newItem; left = lt; right = rt;
  }
  public Key getKey(){return item;}
  public Node<Key> getLeft(){return left;}
  public Node<Key> getRight(){return right;}
  public void setKey(Key newItem) {item = newItem;}
  public void setLeft(Node<Key> lt) {left = lt;}
  public void setRight(Node<Key> rt) {right = rt;}
}

