import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// set needed components
		Stack myS = new Stack();
		Scanner read = new Scanner(System.in);
		int N, i;
		String pro;
		
		// get N
		N = read.nextInt();
		pro = read.nextLine();
		
		// do process for N times
		for (i = 0; i < N; i++) {
			// get command
			pro = read.nextLine();
			
			// process by command
			// if command is 'PUSH'
			if (pro.substring(0, 2).contentEquals("pu")) {
				int pushNum;
				
				pushNum = Integer.parseInt(pro.substring(5));
				
				myS.push(pushNum);
			}
			// if command is 'POP'
			else if (pro.equals("pop")) {
				if (myS.isEmpty()) {
					System.out.println(-1);
				}else {
					int ansPOP;
					
					ansPOP = myS.pop();
					
					System.out.println(ansPOP);
				}
			}
			// if command is 'SIZE'
			else if (pro.equals("size")) {
				int ansSIZE;
				
				ansSIZE = myS.size;
				
				System.out.println(ansSIZE);
			}
			// if command is 'EMPTY'
			else if (pro.equals("empty")) {
				if (myS.isEmpty()) System.out.println(1);
				else System.out.println(0);
			}
			// if command is 'TOP'
			else if (pro.equals("top")) {
				if (myS.isEmpty()) System.out.println(-1);
				else {
					int ans = myS.top();
					System.out.println(ans);
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
	
	public void insertAtFront(int x) {
		Node newnode;
		
		newnode = new Node();
		newnode.data = x;
		newnode.next = first;
		first = newnode;
		if (last == null) last = newnode;
	}
	
	public int deleteFirst() {
		int ret;
		
		if (first == null) return -1;
		ret = first.data;
		first = first.next;
		if (first == null) last = null;
		return ret;
	}
}

class Stack {
	private final LinkedList llist;
	int size = 0;
	
	public Stack() {
		llist = new LinkedList();
	}
	
	public void push(int x) {
		llist.insertAtFront(x);
		size++;
	}
	
	public int pop() {
		size--;
		return llist.deleteFirst();
	}
	
	public boolean isEmpty() {
		return llist.isEmpty();
	}
	
	public int top() {
		int ans;
		
		ans = llist.first.data;
		
		return ans;
	}
}
