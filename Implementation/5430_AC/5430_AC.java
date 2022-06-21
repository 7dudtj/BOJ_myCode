import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {
  // set static variables
  static StringBuilder sb = new StringBuilder();
  static Deq dq;
  static boolean error;
	public static void main(String args[]) throws IOException	{
    // set needed variables
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;
    int T = Integer.parseInt(br.readLine());
    String p, input;
    int n;

    // do main process for T times
    for (int times = 0; times < T; times++){
      // get data
      p = br.readLine();
      n = Integer.parseInt(br.readLine());
      input = br.readLine();
      // n == 0
      if (input.length() == 2){
        dq = new Deq();
      }
      // n != 0
      else {
        input = input.substring(1, input.length()-1);
        st = new StringTokenizer(input, ",");
        dq = new Deq();
        for (int i = 0; i < n; i++) dq.addback(Integer.parseInt(st.nextToken()));
      }

      // search function p
      error = false;
      for (int i = 0; i < p.length(); i++){
        if (p.substring(i,i+1).equals("R")){
          doR();
        }else{
          doD();
        }
      }

      // print answer
      if (error){
        sb.append("error\n");
      }else{
        sb.append("[");
        dq.printQueue();
        String tmp = dq.s.toString();
        if (!tmp.equals("")){
          tmp = tmp.substring(0, tmp.length()-1);
          sb.append(tmp);
        }
        sb.append("]\n");
      }
    }

    // print answer and end program
    System.out.print(sb);
    br.close();
    return;
  }

  // R function
  private static void doR(){
    if (dq.front != dq.rear){
      dq.reverse = !dq.reverse;
    }
  }

  // D function
  private static void doD(){
    // reverse
    if (dq.reverse){
      if(!dq.removeback()) error = true;
    }
    // not reverse
    else{
      if(!dq.removefront()) error = true;
    }
  }
}

// Node class
class Node{
  public int item;
  public Node next;
  public Node before;
  // 생성자
  public Node(int newItem, Node nnode, Node bnode){
    item = newItem;
    next = nnode;
    before = bnode;
  }
  // get과 set 메소드
  public int getItem() {return item;}
  public Node getNext() {return next;}
  public Node getBefore() {return before;}
  public void setItem(int newItem) {item = newItem;}
  public void setNext(Node newNext) {next = newNext;}
  public void setBefore(Node newBefore) {before = newBefore;}
}

class Deq{
  public Node front, rear;
  public int size;
  public StringBuilder s;
  public boolean reverse;
  // 생성자
  public Deq(){
    front = rear = null;
    size = 0;
    s = new StringBuilder();
    reverse = false;
  }
  // 큐의 항목의 수를 리턴
  private int size(){return size;}
  // 큐가 empty이면 true 리턴
  private boolean isEmpty(){return size() == 0;}
  // 큐 삽입 연산
  public void addback(int newItem){
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
  // 큐 삭제 연산
  public boolean removefront(){
    if (isEmpty()){
      return false;
    }
    int frontItem = front.getItem();
    front = front.getNext();
    size--;
    if (isEmpty()) {
      rear = null;
    }else{
      front.getBefore().setNext(null);
      front.setBefore(null);
    }
    return true;
  }
  public boolean removeback(){
    if (isEmpty()){
      return false;
    }
    int backItem = rear.getItem();
    rear = rear.getBefore();
    size--;
    if (isEmpty()) {
      front = null;
    }else{
      rear.getNext().setBefore(null);
      rear.setNext(null);
    }
    return true;
  }
  // 큐 출력
  public void printQueue(){
    // print normal order
    if (!reverse){
      for (Node i = front; i != null; i = i.getNext()){
        s.append(i.getItem() + ",");
      }
    }
    // print reverse order
    else{
      for (Node i = rear; i != null; i = i.getBefore()){
        s.append(i.getItem() + ",");
      }
    }
  }
}