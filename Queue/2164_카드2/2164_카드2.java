import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// set needed components
		Queue myQ = new Queue();
		Scanner read = new Scanner(System.in);
		int N, i, answer;
		
		// get N
		N = read.nextInt();
		read.close();
		
		// make queue
		for (i = 1; i <= N; i++) {
			myQ.enqueue(i);
		}
		
		// do process
		doProcess(myQ);
		
		// display answer
		answer = myQ.firstData();
		System.out.println(answer);
		return;
	}
	
	public static void doProcess(Queue q) {
		while (true) {
			if (q.len == 1) break;
			
			q.dequeue();
			int top = q.firstData();
			q.dequeue();
			q.enqueue(top);
		}
		
		return;
	}

}

class Node {
	public int data;
	public Node next;
}

class LinkedList {
	public Node first, last;
	
	public LinkedList() {
		first = null;
		last = null;
	}
	
	public boolean isEmpty() {
		return (first == null);
	}
	
	public int deleteFirst() {
		int ret;
		
		if (first == null) return -1;
		ret = first.data;
		first = first.next;
		if (first == null) last = null;
		return ret;
	}
	
	public void insertAtEnd(int x) {
		Node newnode;
		
		newnode = new Node();
		newnode.data = x;
		newnode.next = null;
		if (last == null) first = last = newnode;
		else {
			last.next = newnode;
			last = newnode;
		}
	}
}

class Queue {
	private final LinkedList llist;
	int len = 0;
	
	public Queue() {
		llist = new LinkedList();
	}
	
	public void enqueue(int x) {
		llist.insertAtEnd(x);
		len++;
	}
	
	public int dequeue() {
		len--;
		return llist.deleteFirst();
	}
	
	public boolean isEmpty() {
		return llist.isEmpty();
	}
	
	public int firstData() {
		return llist.first.data;
	}
}
