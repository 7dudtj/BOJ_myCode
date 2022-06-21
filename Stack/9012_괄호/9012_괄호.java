import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// set needed components
		Stack myS = new Stack();
		Scanner read = new Scanner(System.in);
		int T, i, j;
		String input, one;
		
		// get T
		T = read.nextInt();
		
		// process trash value
		input = read.nextLine();
		
		// do process
		for (i = 0; i < T; i++) {
			input = read.nextLine();
			for (j = 0; j < input.length(); j++) {
				one = input.substring(j, j + 1);
				if (one.contentEquals("(")) {
					myS.push(one);
				}else {
					if (myS.isEmpty()) {
						myS.push(one);
					}else if (myS.top().contentEquals("(")) {
						myS.pop();
					}else {
						myS.push(one);
					}
				}
			}
			// check answer
			if (myS.isEmpty()) {
				System.out.println("YES");
			}else {
				System.out.println("NO");
			}
			// delete stack
			myS.deleteStack();
		}
		
		// end program
		read.close();
		return;
	}

}

class Node {
	public String data;
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
	
	public void insertAtFront(String x) {
		Node newnode;
		
		newnode = new Node();
		newnode.data = x;
		newnode.next = first;
		first = newnode;
		if (last == null) last = newnode;
	}
	
	public void deleteFirst() {
		first = first.next;
		if (first == null) last = null;
	}
}

class Stack {
	private final LinkedList llist;
	
	public Stack() {
		llist = new LinkedList();
	}
	
	public void push(String x) {
		llist.insertAtFront(x);
	}
	
	public void pop() {
		llist.deleteFirst();
	}
	
	public boolean isEmpty() {
		return llist.isEmpty();
	}
	
	public String top() {
		return llist.first.data;
	}
	
	public void deleteStack() {
		llist.first = null;
		llist.last = null;
	}
}
