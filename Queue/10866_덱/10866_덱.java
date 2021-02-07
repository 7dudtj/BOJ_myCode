import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.NoSuchElementException;

public class Main {
  public static void main(String[] args) throws IOException{
    // set needed components
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N;
    String s;
    ListQueue q = new ListQueue();

    // get N
    N = Integer.parseInt(br.readLine());

    // do process
    for (int i = 0; i < N; i++){
      // get command
      s = br.readLine();

      // check command and do
      if (s.equals("back")){
        if (q.isEmpty()) System.out.println(-1);
        else System.out.println(q.rear.item);
      }else if (s.equals("front")){
        if (q.isEmpty()) System.out.println(-1);
        else System.out.println(q.front.item);
      }else if (s.equals("empty")){
        if (q.isEmpty()) System.out.println(1);
        else System.out.println(0);
      }else if (s.equals("size")){
        System.out.println(q.size());
      }else if (s.equals("pop_back")){
        if (q.isEmpty()) System.out.println(-1);
        else{
          System.out.println(q.removeback());
        }
      }else if (s.equals("pop_front")){
        if (q.isEmpty()) System.out.println(-1);
        else{
          System.out.println(q.removefront());
        }
      }else if (s.substring(0, 9).equals("push_back")){
        int x = Integer.parseInt(s.substring(10));
        q.addback(x);
      }else{
        int x = Integer.parseInt(s.substring(11));
        q.addfront(x);
      }
    }

    // end program
    br.close();
    return;
  }
}

// Node class
class Node <E>{
  public E item;
  public Node<E> next;
  public Node<E> before;
  // 생성자
  public Node(E newItem, Node<E> nnode, Node<E> bnode){
    item = newItem;
    next = nnode;
    before = bnode;
  }
  // get과 set 메소드
  public E getItem() {return item;}
  public Node<E> getNext() {return next;}
  public Node<E> getBefore() {return before;}
  public void setItem(E newItem) {item = newItem;}
  public void setNext(Node<E> newNext) {next = newNext;}
  public void setBefore(Node<E> newBefore) {before = newBefore;}
}

// ListDequeue class
class ListQueue<E>{
  public Node<E> front, rear;
  public int size;
  // 생성자
  public ListQueue(){
    front = rear = null;
    size = 0;
  }
  // 큐의 항목의 수를 리턴
  public int size(){return size;}
  // 큐가 empty이면 true 리턴
  public boolean isEmpty(){return size() == 0;}
  // 큐 삽입 연산
  public void addback(E newItem){
    Node newNode = new Node(newItem, null, null);
    if (isEmpty()) {
      front = rear = newNode;
    }  
    else {
      rear.setNext(newNode);
      newNode.setBefore(rear);
      rear = newNode;
    }  
    size++;
  }
  public void addfront(E newItem){
    Node newNode = new Node(newItem, null, null);
    if (isEmpty()) {
      front = rear = newNode;
    }  
    else {
      newNode.setNext(front);
      front.setBefore(newNode);
      front = newNode;
    }  
    size++;
  }
  // 큐 삭제 연산
  public E removefront(){
    if (isEmpty()) throw new NoSuchElementException();
    E frontItem = front.getItem();
    front = front.getNext();
    if (isEmpty()) rear = null;
    size--;
    return frontItem;
  }
  public E removeback(){
    if (isEmpty()) throw new NoSuchElementException();
    E backItem = rear.getItem();
    rear = rear.getBefore();
    if (isEmpty()) front = null;
    size--;
    return backItem;
  }
}
