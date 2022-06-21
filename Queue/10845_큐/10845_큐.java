import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// set needed components
		Queue myQ = new Queue();
		Scanner read = new Scanner(System.in);
		int N, i;
		String pro;
		
		// get N
		N = read.nextInt();
		
		// process trash value
		pro = read.nextLine();
		
		// do process for N times
		for (i = 0; i < N; i++) {
			// get command
			pro = read.nextLine();
			
			// process by command
			// if command is 'PUSH'
			if (pro.substring(0, 2).equals("pu")) {
				int pushNum;
				
				pushNum = Integer.parseInt(pro.substring(5));
				
				myQ.enqueue(pushNum);
			}
			// if command is 'POP'
			else if (pro.equals("pop")) {
				if (myQ.isEmpty()) {
					System.out.println(-1);
				}else {
					int ansPOP;
					
					ansPOP = myQ.dequeue();
					
					System.out.println(ansPOP);
				}
			}
			// if command is 'SIZE'
			else if (pro.equals("size")){
				int ansSIZE;
				
				ansSIZE = myQ.size;
				
				System.out.println(ansSIZE);
			}
			// if command is 'EMPTY'
			else if (pro.equals("empty")) {
				if (myQ.isEmpty()) System.out.println(1);
				else System.out.println(0);
			}
			// if command is 'FRONT'
			else if (pro.equals("front")) {
				int ansFRONT;
				
				if (myQ.isEmpty()) System.out.println(-1);
				else {
					ansFRONT = myQ.getFront();
					
					System.out.println(ansFRONT);
				}
			}
			// if command is 'BACK'
			else if (pro.equals("back")) {
				int ansBACK;
				
				if (myQ.isEmpty()) System.out.println(-1);
				else {
					ansBACK = myQ.getBack();
					
					System.out.println(ansBACK);
				}
			}
		}
		
		// end program
		read.close();
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
	int size = 0;
	
	public Queue() {
		llist = new LinkedList();
	}
	
	public void enqueue(int x) {
		llist.insertAtEnd(x);
		++size;
	}
	
	public int dequeue() {
		--size;
		return llist.deleteFirst();
	}
	
	public boolean isEmpty() {
		return llist.isEmpty();
	}
	
	public int getFront() {
		return llist.first.data;
	}
	
	public int getBack() {
		return llist.last.data;
	}
}
