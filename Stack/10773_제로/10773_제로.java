import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// set needed components
		Scanner read = new Scanner(System.in);
		Stack myS = new Stack();
		int K, input, i, answer;
		
		// get K
		K = read.nextInt();
		
		// store or delete
		for (i = 0; i < K; i++) {
			// get input
			input = read.nextInt();
			
			// process
			if (input == 0) {
				myS.pop();
			} else {
				myS.push(input);
			}
		}
		
		// calculate sum
		answer = myS.calSum();
		
		// display answer
		System.out.println(answer);
		
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
	
	public void push(int x) {
		llist.insertAtFront(x);
	}
	
	public void pop() {
		llist.deleteFirst();
	}

	public int calSum() {
		int ans = 0;
		
		while (llist.first != null) {
			ans += llist.first.data;
			llist.first = llist.first.next;
		}
		
		return ans;
	}
}
